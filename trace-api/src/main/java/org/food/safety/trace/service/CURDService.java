package org.food.safety.trace.service;

import org.food.safety.trace.dto.ListFilter;
import org.food.safety.trace.dto.PageSearch;
import org.food.safety.trace.dto.Token;
import org.food.safety.trace.dto.Viewable;
import org.food.safety.trace.repository.Dao;
import org.springframework.data.domain.Page;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * CURD 服务 接口
 * User: tom
 * Date: 2017/8/25
 */
public interface CURDService {
    public static final String FIELD_ID = "id";
    public static final String FIELD_ORGANIZATION="organization";
    public static final String FIELD_DISPLAY="name";
    public static final String FIELD_SELECT_ITEM="SelectItem";
    public static final String FIELD_SELECT_LIST="List";
    public static final String FIELD_SELECT_OPTION_KEY="key";
    public static final String FIELD_SELECT_OPTION_LABEL="label";

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
    List list(Token token, @NotNull String name, @NotNull ListFilter listFilter);

    /**
     * 存储对象
     * @param name 实体名称
     * @param entity 实体数据
     * @return
     */
    Viewable createOrUpdte(Token token, @NotNull String name, @NotNull String entity);

    /**
     * 创建对象之前
     * @param name 实体名称
     * @param entity 实体数据
     */
    void createBefore(Token token, @NotNull String name,@NotNull final Object entity);

    /**
     * 创建对象之后
     * @param name 实体名称
     * @param entity 实体数据
     */
    void createAfter(Token token, @NotNull String name,@NotNull final Object entity);

    /**
     * 分页查询
     * @param name 实体名称
     * @param pageSearch 查询条件
     * @return
     */
    Page page(Token token, @NotNull String name, @NotNull PageSearch pageSearch);

    /**
     * 详情
     * @param name 实体名称
     * @param id id
     * @return
     */
    Viewable detail(Token token, @NotNull String name, @NotNull Serializable id);

    /**
     * 删除
     * @param name
     * @param id
     * @return
     */
    Boolean delete(Token token, String name, String id);

    /**
     * 对象 列表视图信息
     * @param name 名称
     * @return
     */
    List viewList(String name);
}
