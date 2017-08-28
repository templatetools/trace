package org.food.safety.trace.service;

import lombok.NonNull;
import org.food.safety.trace.dto.ListFilter;
import org.food.safety.trace.dto.PageSearch;
import org.food.safety.trace.repository.Dao;
import org.springframework.data.domain.Page;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * CURD 服务 接口
 * User: tom
 * Date: 2017/8/25
 */
public interface CURDService {
    /**
     * 根据实体名称，获取 dao
     * @param name 实体名称
     * @return
     */
    Dao getDAO(@NotNull String name);

    /**
     * 列表查询
     *
     * @param name 实体名称
     * @param listFilter 过滤条件
     * @return
     */
    List list(@NotNull String name, @NotNull ListFilter listFilter);

    /**
     * 存储对象
     * @param name 实体名称
     * @param entity 实体数据
     * @return
     */
    Object createOrUpdte(@NotNull String name, @NotNull String entity);

    /**
     * 分野查询
     * @param name 实体名称
     * @param pageSearch 查询条件
     * @return
     */
    Page page(@NotNull String name, @NotNull PageSearch pageSearch);
}
