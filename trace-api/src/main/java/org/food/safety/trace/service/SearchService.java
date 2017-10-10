package org.food.safety.trace.service;

import org.food.safety.trace.dto.ListFilter;
import org.food.safety.trace.dto.Token;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 搜索 服务 接口
 * User: tom
 * Date: 2017/8/25
 */
public interface SearchService {
    /**
     * 搜索条件处理
     * @param name 实体名称
     * @param filters 索索条件处理
     * @return
     */
    ListFilter searchBefore(Token token, @NotNull String name, @NotNull ListFilter filters);

    /**
     * 处理查询数据
     * @param name
     * @param data 查询结果
     */
    void queryAfter(Token token, String name, @NotNull final List data);
}
