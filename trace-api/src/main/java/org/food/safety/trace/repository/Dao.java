package org.food.safety.trace.repository;

import org.food.safety.trace.dto.ListFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * 数据库 访问接口
 * Created by tom on 2017/8/27.
 */
@NoRepositoryBean
public interface Dao<T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
    /**
     * 返回列表，根据过滤条件
     *
     * @param listFilter
     * @return
     */
    public List findAllByFilter(ListFilter listFilter);
}
