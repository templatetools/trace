package org.food.safety.trace.service;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.ParseException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.food.safety.trace.dto.*;
import org.food.safety.trace.entity.ListView;
import org.food.safety.trace.entity.Reference;
import org.food.safety.trace.repository.Dao;
import org.food.safety.trace.repository.DaoBase;
import org.food.safety.trace.repository.ListViewDao;
import org.food.safety.trace.repository.ReferenceDao;
import org.hibernate.jpa.internal.metamodel.MetamodelImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: tom
 * Date: 2017/8/25
 */
@Service
@Getter
@Slf4j
@Primary
public class CURDServiceImpl implements CURDService,SearchService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CURDServiceImpl.class);

    /**
     * 视图信息
     */
    private static final String LISTVIEW_ENTITY = "ListView";
    private static final String LISTVIEW_SELECT_TYPE_MULTIPLE = "multiple";
    private static final String LISTVIEW_SELECT_TYPE_COMBOBOX = "combobox";
    private static final String SEARCH_TEXT = "searchText";

    @Autowired
    private EntityManager entityManager;
    @Autowired
    protected ListViewDao listViewDao;
    @Autowired
    private ReferenceDao referenceDao;

    private EntityType findEntiytyTypeByName(String name){
        MetamodelImpl metamodel = (MetamodelImpl)entityManager.getEntityManagerFactory().getMetamodel();

        EntityType entity = null;
        for (EntityType entityType : metamodel.getEntities()){
            if (entityType.getName().endsWith(name)){
                entity = entityType;
            }
        }

        if (null == entity){
            throw new RuntimeException("not fond " + name + " entity!");
        }

        return entity;
    }

    private DaoBase createDao(@NotNull EntityType entity ){
        return new DaoBase(entity.getBindableJavaType(), entityManager);
    }

    @Override
    public Dao getDAO(String name) {
        EntityType entityType = findEntiytyTypeByName(name);
        return createDao(entityType);
    }

    @Override
    public List list(String name,@NotNull ListFilter listFilter) {
        DaoBase daoBase = (DaoBase) getDAO(name);

        searchBefore(name, listFilter);

        List data = daoBase.findAllByFilter(listFilter);

        queryAfter(name, data);

        return data;
    }

    @Override
    @Transactional
    public Viewable createOrUpdte(String name, String entityJson) {
        Dao dao = getDAO(name);
        EntityType entityType = findEntiytyTypeByName(name);

        Object entity = null;
        try {
            entity = JSON.parse(entityJson, entityType.getBindableJavaType());
            createBefore(name, entity);
        } catch (ParseException e) {
            log.warn("模型数据转换错误:{} to {}", entityJson, entityType.getBindableJavaType());
        }

        dao.save(entity);

        createAfter(name, entity);

        return (Viewable) entity;
    }

    public void createBefore(String name, final Object entity) {
        if (entity instanceof SelectViewable) {
            List<ListView> columns = viewList(name);
            for (ListView c : columns) {
                if (LISTVIEW_SELECT_TYPE_COMBOBOX.equalsIgnoreCase(c.getItemValue())) {
                    try {
                        SelectItemView selectItemView = (SelectItemView) PropertyUtils.getProperty(entity, c.getName()+"SelectItem");

                        if (null  != selectItemView){
                            PropertyUtils.setProperty(entity, c.getName(), selectItemView.getKey());
                        }
                    }catch (Exception e) {
                        log.warn("not found",e);
                    }
                }
            }
        }
    }

    @Override
    public void createAfter(@NotNull String name, @NotNull Object entity) {
        if (entity instanceof SelectViewable){
            List<ListView> columns = viewList(name);
            for (ListView c: columns){
                if (LISTVIEW_SELECT_TYPE_MULTIPLE.equalsIgnoreCase(c.getItemValue())) {

                    String id = null;
                    List selectItemViews = null;

                    try {
                        selectItemViews = (List)PropertyUtils.getProperty(entity, c.getName()+"List");

                        id = PropertyUtils.getProperty(entity, "id") + "";
                    }catch (Exception e) {
                        log.warn("sourceId not found",e);
                    }

                    if (null ==  id || null == selectItemViews){
                        return;
                    }

                    referenceDao.deleteBySourceId(id);

                    for (int i = 0; i < selectItemViews.size();i++){
                        Map<String, String> map = (Map<String, String>)selectItemViews.get(i);

                        Reference reference = new Reference();

                        reference.setTargetId(map.get("key"));
                        reference.setTargetName(c.getRefType());
                        reference.setSourceName(name);
                        reference.setSourceId(id);

                        referenceDao.save(reference);
                    }

                }
            }


        }
    }

    @Override
    public Page page(String name, PageSearch pageSearch) {
        Dao dao = getDAO(name);

        searchBefore(name, pageSearch);

        Page page = dao.page(pageSearch);

        queryAfter(name, page.getContent());

        return page;
    }

    @Override
    public Viewable detail(@NotNull String name, @NotNull Serializable id) {
        Dao dao = getDAO(name);
        return (Viewable) dao.findOne(id);
    }

    @Override
    @Transactional
    public Boolean delete(String name, String ids) {

        try {
            Dao dao = getDAO(name);
            if (org.apache.commons.lang3.StringUtils.indexOf(ids, ",") > -1){
                for (String id: StringUtils.split(ids, ',')){
                    dao.delete(id);
                }
            }else{
                dao.delete(ids);
            }
        }catch (Exception e){
            log.warn("delete exception:{}", ids, e);
            return false;
        }
        return true;
    }

    @Override
    public List viewList(String name) {
        List result = listViewDao.findByEntityNameLike('%' + name);
        return result;
    }

    @Override
    public ListFilter searchBefore(@NotNull String name, @NotNull ListFilter filters) {
        if (null != filters.getFilters()){
            String searchText = null;
            for (SearchFilter searchFilter: filters.getFilters()){
                if (SEARCH_TEXT.equalsIgnoreCase(searchFilter.getFieldName())){
                    searchText = searchFilter.getValue()+"";

                    filters.getFilters().remove(searchFilter);

                    List<ListView> columns = viewList(name);
                    for (ListView view: columns){
                        if (view.isSearchable()){
                            SearchFilter sf = new SearchFilter(view.getName(), SearchFilter.Operator.LIKE, searchText + "%");
                            filters.getFilters().add(sf);
                        }
                    }
                    break;
                }
            }
        }

        return filters;
    }

    @Override
    public void queryAfter(String name, @NotNull List data) {
        ReferenceDao referenceDao = getReferenceDao();

        List<ListView> columns = viewList(name);
        for (ListView view : columns) {
            if (org.apache.commons.lang3.StringUtils.isNotEmpty(view.getRefType())) {

                for (Object d : data) {
                    try {
                        if (LISTVIEW_SELECT_TYPE_MULTIPLE.equalsIgnoreCase(view.getItemValue())) {
                            List<Reference> references = referenceDao.findBySourceId(PropertyUtils.getProperty(d, "id") + "");

                            List<SelectItemView> selectItemViews = new ArrayList<>();
                            List<String> titles = new ArrayList<>();

                            for (Reference reference : references) {
                                SelectItemView selectItemView = new SelectItemView();
                                selectItemView.setKey(reference.getTargetId());

                                Object target = this.detail(reference.getTargetName(), reference.getTargetId());

                                selectItemView.setLabel(PropertyUtils.getProperty(target, "name") + "");
                                selectItemViews.add(selectItemView);
                                titles.add(selectItemView.getLabel());
                            }

                            PropertyUtils.setProperty(d, view.getName() + "List", selectItemViews);
                            PropertyUtils.setProperty(d, view.getName(), org.apache.commons.lang3.StringUtils.join(titles, ","));
                        }else{
                            Object key = PropertyUtils.getProperty(d, view.getName());
                            if (null != key && StringUtils.isNotEmpty(key+"")) {
                                String refId = key+"";
                                SelectItemView selectItemView = new SelectItemView();
                                selectItemView.setKey(refId);

                                Object target = this.detail(view.getRefType(), refId);
                                log.debug("{} find ref type:{}", key, target);
                                selectItemView.setLabel(PropertyUtils.getProperty(target, "name") + "");
                                PropertyUtils.setProperty(d, view.getName() + "SelectItem", selectItemView);
                            }
                        }
                    } catch (Exception e) {
                        log.debug("set list:{}", view.getName(), e);
                    }
                }
            }
        }
    }

}
