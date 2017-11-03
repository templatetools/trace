package org.food.safety.trace.service;

import org.food.safety.trace.dto.Token;
import org.food.safety.trace.repository.Dao;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.metamodel.EntityType;
import javax.validation.constraints.NotNull;

/**
 * CURD 服务 接口
 * User: tom
 * Date: 2017/8/25
 */
public interface DBService {
    /**
     * 获取对象实例
     * @param name 实体名称
     * @return
     */
    EntityType findEntiytyTypeByName(String name);

    /**
     * 创建 实体 dao
     * @param entity 实体对象
     * @return
     */
    Dao createDao(@NotNull EntityType entity);

    /**
     * 根据实体名称，获取 dao
     * @param name 实体名称
     * @return
     */
    Dao getDAO(@NotNull String name);

//    @Cacheable(value = "queryRefObject", key = "#refType+'_'+#refField+'_'+#refId")
    @Cacheable("queryRefObject")
    Object queryRefObject(Token token, String refType, String refField, String refId);
}
