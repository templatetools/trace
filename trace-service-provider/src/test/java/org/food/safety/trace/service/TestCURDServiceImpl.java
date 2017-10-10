package org.food.safety.trace.service;

import com.alibaba.dubbo.common.json.JSON;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.food.safety.trace.TestSmartApplication;
import org.food.safety.trace.dto.*;
import org.hibernate.jpa.internal.metamodel.MetamodelImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: tom
 * Date: 2017/8/25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestSmartApplication.class)
@ComponentScan("org.food.safety.trace")
@EnableAutoConfiguration
@Slf4j
public class TestCURDServiceImpl{

    static final String NAME = "UserEntity";
    @Autowired
    CURDService curdService;
    Token token = new Token("1/1");

    @Autowired
    private EntityManager entityManager;

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

    @Test
    public void delete(){
        boolean result = curdService.delete(token, NAME, "ff8080815e26bfc2015e26bfccfb0000");
        log.debug("delete:{}", result);
    }
    @Test
    public void detail(){
        Viewable result = curdService.detail(token, NAME, "ff8080815e22f191015e22f198aa0000");
        log.debug("detail:{}", result);
    }
    @Test
    public void list(){
        List list = curdService.list(token, NAME, new ListFilter());
        log.debug("list:{}", list);
    }
    @Test
    public void page(){
        PageSearch pageSearch = new PageSearch();
        pageSearch.setPageNumber(1);
        pageSearch.setPageSize(2);

        Sort sort = new Sort();
        sort.setDirection("desc");
        sort.setFieldName("name");
        pageSearch.setSort(sort);

        List<SearchFilter> filters = new ArrayList<>();
        SearchFilter searchFilter = new SearchFilter();
        searchFilter.setFieldName("name");
        searchFilter.setOperator(SearchFilter.Operator.LIKE.toString());
        searchFilter.setValue("j");
        filters.add(searchFilter);
        pageSearch.setFilters(filters);
        pageSearch.setAndFilters(filters);

        Page result = curdService.page(token, NAME, pageSearch);
        log.debug("page:{}", result);


        result = curdService.page(token, NAME, new PageSearch());
        log.debug("page search is emplty:{}", result);
    }

    @Test
    @Rollback(false)
    public void create() throws IOException {
        val entityName = "UserEntity";

        Map<String, String> entity = ImmutableMap.of("name", "jia","loginName","j","password", "123");

        log.debug("class:{}", curdService.createOrUpdte(token, entityName, JSON.json(entity)));
    }

    @Test
    public void fields(){
        EntityType entityType = findEntiytyTypeByName(NAME);

        log.debug("entity:{}", entityType);
    }

}
