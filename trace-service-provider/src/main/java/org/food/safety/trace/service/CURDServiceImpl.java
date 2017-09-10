package org.food.safety.trace.service;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.ParseException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.util.StringUtils;
import org.food.safety.trace.dto.ListFilter;
import org.food.safety.trace.dto.PageSearch;
import org.food.safety.trace.dto.SearchFilter;
import org.food.safety.trace.dto.Viewable;
import org.food.safety.trace.entity.ListView;
import org.food.safety.trace.repository.Dao;
import org.food.safety.trace.repository.DaoBase;
import org.food.safety.trace.repository.ListViewDao;
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

    /**
     * 视图信息
     */
    private static final String LISTVIEW_ENTITY = "ListView";
    private static final String SEARCH_TEXT = "searchText";

    @Autowired
    private EntityManager entityManager;
    @Autowired
    protected ListViewDao listViewDao;

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
        } catch (ParseException e) {
            log.warn("模型数据转换错误:{} to {}", entityJson, entityType.getBindableJavaType());
        }

        return (Viewable) dao.save(entity);
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
                for (String id:StringUtils.split(ids, ',')){
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
        return;
    }

}
