package org.food.safety.trace.service;

import lombok.Getter;
import org.food.safety.trace.dto.ListFilter;
import org.food.safety.trace.repository.Dao;
import org.food.safety.trace.repository.DaoBase;
import org.hibernate.jpa.internal.metamodel.MetamodelImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import javax.validation.constraints.NotNull;
import java.util.List;

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

        return daoBase.findAllByFilter(listFilter);
    }

    @Override
    public Object createOrUpdte(String name, Object entity) {
        Dao dao = getDAO(name);

        return dao.save(entity);
    }
}
