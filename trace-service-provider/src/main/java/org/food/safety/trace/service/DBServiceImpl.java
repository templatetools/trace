package org.food.safety.trace.service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.food.safety.trace.repository.Dao;
import org.food.safety.trace.repository.DaoBase;
import org.hibernate.jpa.internal.metamodel.MetamodelImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import javax.validation.constraints.NotNull;

/**
 * User: tom
 * Date: 2017/8/25
 */
@Service
@Getter
@Slf4j
@Primary
@CacheConfig(cacheNames = "DBService")
public class DBServiceImpl implements DBService {
    @Autowired
    private EntityManager entityManager;

    @Override
    public EntityType findEntiytyTypeByName(String name){
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
    @Override
    public Dao createDao(@NotNull EntityType entity){
        return new DaoBase(entity.getBindableJavaType(), entityManager);
    }

    @Override
    @Cacheable(value = "queryRefObject", key = "#refType+'_'+#refField+'_'+#refId")
    public Object queryRefObject(String refType, String refField, String refId) {
        log.debug("queryRefObject:{},{},{}",refType, refField, refId);
        return Dao.findOneByKeyAndValue(this.getDAO(refType), refField, refId);
    }

    @Override
    public Dao getDAO(String name) {
        EntityType entityType = findEntiytyTypeByName(name);
        return createDao(entityType);
    }
}
