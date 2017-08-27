package org.food.safety.trace.service;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import lombok.Getter;
import org.apache.commons.collections.MapUtils;
import org.food.safety.trace.dto.ListFilter;
import org.food.safety.trace.dto.SearchFilter;
import org.food.safety.trace.entity.UserEntity;
import org.food.safety.trace.repository.DaoBase;
import org.hibernate.jpa.internal.metamodel.EntityTypeImpl;
import org.hibernate.jpa.internal.metamodel.MetamodelImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.management.RuntimeMBeanException;
import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * User: tom
 * Date: 2017/8/25
 */
@Service
@Getter
public class CURDServiceImpl implements CURDService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CURDServiceImpl.class);
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

    DaoBase createDao(@NotNull EntityType entity ){
        return new DaoBase(entity.getBindableJavaType(), entityManager);
    }

    @Override
    public List list(String name,@NotNull ListFilter listFilter) {
        EntityType entityType = findEntiytyTypeByName(name);

        DaoBase daoBase = createDao(entityType);

        return daoBase.findAllByFilter(listFilter);
    }


}
