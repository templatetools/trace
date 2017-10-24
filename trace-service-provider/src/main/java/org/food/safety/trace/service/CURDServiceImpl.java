package org.food.safety.trace.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public static final String FIELD_ID = "id";
    public static final String FIELD_ORGANIZATION="organization";
    public static final String FIELD_DISPLAY="name";
    public static final String FIELD_SELECT_ITEM="SelectItem";
    public static final String FIELD_SELECT_LIST="List";
    public static final String FIELD_SELECT_OPTION_KEY="key";
    public static final String FIELD_SELECT_OPTION_LABEL="label";

    /**
     * 视图信息
     */
    private static final String LISTVIEW_ENTITY = "ListView";
    private static final String LISTVIEW_SELECT_TYPE_MULTIPLE = "multiple";
    private static final String LISTVIEW_SELECT_TYPE_COMBOBOX = "combobox";
    private static final String LISTVIEW_SELECT_TYPE_STATIC = "static";
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
    public List list(Token token, String name,@NotNull ListFilter listFilter) {
        DaoBase daoBase = (DaoBase) getDAO(name);

        searchBefore(token, name, listFilter);

        List data = daoBase.findAllByFilter(listFilter);

        queryAfter(token, name, data);

        return data;
    }

    @Override
    @Transactional
    public Viewable createOrUpdte(Token token, String name, String entityJson) {
        Dao dao = getDAO(name);
        EntityType entityType = findEntiytyTypeByName(name);

        Object entity = null;
        Class clazz = entityType.getBindableJavaType();
        try {
            entity = JSON.parseObject(entityJson, clazz);
            createBefore(token, name, entity);
        } catch (Exception e) {
            log.warn("模型数据转换错误:{} to {}", entityJson, clazz);
        }

        dao.save(entity);

        createAfter(token, name, entity);

        return (Viewable) entity;
    }

    public void createBefore(Token token, String name, final Object entity) {
        if (entity instanceof SelectViewable) {
            List<ListView> columns = viewList(name);
            for (ListView c : columns) {
                if (LISTVIEW_SELECT_TYPE_COMBOBOX.equalsIgnoreCase(c.getItemValue()) || LISTVIEW_SELECT_TYPE_STATIC.equalsIgnoreCase(c.getRefType())) {
                    try {
                        SelectItemView selectItemView = (SelectItemView) PropertyUtils.getProperty(entity, c.getName()+FIELD_SELECT_ITEM);

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
    public void createAfter(Token token, @NotNull String name, @NotNull Object entity) {
        if (entity instanceof SelectViewable){
            List<ListView> columns = viewList(name);
            for (ListView c: columns){
                if (LISTVIEW_SELECT_TYPE_MULTIPLE.equalsIgnoreCase(c.getItemValue())) {

                    String id = null;
                    List selectItemViews = null;

                    try {
                        selectItemViews = (List)PropertyUtils.getProperty(entity, c.getName()+FIELD_SELECT_LIST);

                        id = PropertyUtils.getProperty(entity, FIELD_ID) + "";
                    }catch (Exception e) {
                        log.warn("sourceId not found",e);
                    }

                    if (null ==  id || null == selectItemViews){
                        return;
                    }

                    referenceDao.deleteBySourceId(id);

                    for (int i = 0; i < selectItemViews.size();i++){
                        SelectItemView map = (SelectItemView)selectItemViews.get(i);

                        Reference reference = new Reference();

                        reference.setTargetId(map.getKey());
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
    public Page page(Token token, String name, PageSearch pageSearch) {
        Dao dao = getDAO(name);

        searchBefore(token, name, pageSearch);

        Page page = dao.page(pageSearch);

        queryAfter(token, name, page.getContent());

        return page;
    }

    @Override
    public Viewable detail(Token token, @NotNull String name, @NotNull Serializable id) {
        Dao dao = getDAO(name);
        return (Viewable) dao.findOne(id);
    }

    @Override
    @Transactional
    public Boolean delete(Token token, String name, String ids) {

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
    public ListFilter searchBefore(Token token, @NotNull String name, @NotNull ListFilter filters) {
        parseFilter(name, filters.getFilters());
        parseFilter(name, filters.getAndFilters());

        try {
            EntityType entityType = findEntiytyTypeByName(name);

            if (!Token.ADMIN.equalsIgnoreCase(token.getUserId()) && null != entityType.getAttribute(FIELD_ORGANIZATION)) {
                SearchFilter organizationSearchFilter = new SearchFilter(FIELD_ORGANIZATION, SearchFilter.Operator.EQ, token.getOrganizationId());
                filters.addAndFilters(organizationSearchFilter);
            }
        }catch (Exception e){

        }

        return filters;
    }
    private void parseFilter(@NotNull String name, @NotNull final List<SearchFilter> searchFilters){
        if (null != searchFilters){
            String searchText = null;
            for (SearchFilter searchFilter: searchFilters){
                if (SEARCH_TEXT.equalsIgnoreCase(searchFilter.getFieldName())){
                    searchText = searchFilter.getValue()+"";

                    searchFilters.remove(searchFilter);

                    List<ListView> columns = viewList(name);
                    for (ListView view: columns){
                        if (view.isSearchable()){
                            SearchFilter sf = new SearchFilter(view.getName(), SearchFilter.Operator.LIKE, searchText + "%");
                            searchFilters.add(sf);
                        }
                    }
                    break;
                }
            }
            for (SearchFilter searchFilter: searchFilters){
                if (SearchFilter.FILTER_TYPE_REF.equalsIgnoreCase(searchFilter.getType())){
                    try {
                        SearchFilter refSearchFilter = new SearchFilter();
                        BeanUtils.copyProperties(refSearchFilter, searchFilter.getValue());
                        Dao dao = getDAO(refSearchFilter.getType());
                        Object o = Dao.findOneByKeyAndValue(dao, refSearchFilter.getFieldName(), refSearchFilter.getValue());
                        searchFilter.setValue(BeanUtils.getProperty(o, FIELD_ID));
                    } catch (Exception e) {
                        log.debug("filter parse error!", e);
                    }
                }
            }
        }
    }

    @Override
    public void queryAfter(Token token, String name, @NotNull List data) {
        ReferenceDao referenceDao = getReferenceDao();

        List<ListView> columns = viewList(name);
        for (ListView view : columns) {
            if (org.apache.commons.lang3.StringUtils.isNotEmpty(view.getRefType())) {

                for (Object d : data) {
                    try {
                        if (LISTVIEW_SELECT_TYPE_MULTIPLE.equalsIgnoreCase(view.getItemValue())) {
                            List<Reference> references = referenceDao.findBySourceId(PropertyUtils.getProperty(d, FIELD_ID) + "");

                            List<SelectItemView> selectItemViews = new ArrayList<>();
                            List<String> titles = new ArrayList<>();

                            for (Reference reference : references) {
                                SelectItemView selectItemView = new SelectItemView();
                                selectItemView.setKey(reference.getTargetId());

                                Object target = this.detail(token, reference.getTargetName(), reference.getTargetId());

                                selectItemView.setLabel(PropertyUtils.getProperty(target, FIELD_DISPLAY) + "");
                                selectItemViews.add(selectItemView);
                                titles.add(selectItemView.getLabel());
                            }

                            PropertyUtils.setProperty(d, view.getName() + FIELD_SELECT_LIST, selectItemViews);
                            PropertyUtils.setProperty(d, view.getName(), org.apache.commons.lang3.StringUtils.join(titles, ","));
                        }else{
                            Object key = PropertyUtils.getProperty(d, view.getName());
                            if (null != key && StringUtils.isNotEmpty(key+"")) {
                                String refId = key + "";
                                SelectItemView selectItemView = new SelectItemView();
                                selectItemView.setKey(refId);

                                if (LISTVIEW_SELECT_TYPE_STATIC.equalsIgnoreCase(view.getRefType())){
                                    List<Object> selects = JSON.parseObject(view.getItemValue(), List.class);
                                    for (Object t: selects){
                                        if (key.equals(PropertyUtils.getProperty(t, FIELD_SELECT_OPTION_KEY)+"")){
                                            selectItemView.setLabel(PropertyUtils.getProperty(t, FIELD_SELECT_OPTION_LABEL)+"");
                                        }
                                    }
                                }else {
                                    Object target = this.detail(token, view.getRefType(), refId);
                                    if (StringUtils.isNotEmpty(view.getRefField())){
                                        target = Dao.findOneByKeyAndValue(this.getDAO(view.getRefType()), view.getRefField(), refId);
                                    }
                                    log.debug("{} find ref type:{}", key, target);
                                    selectItemView.setLabel(PropertyUtils.getProperty(target, FIELD_DISPLAY) + "");
                                }

                                PropertyUtils.setProperty(d, view.getName() + FIELD_SELECT_ITEM, selectItemView);
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
