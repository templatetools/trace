package org.food.safety.trace.service;

import org.food.safety.trace.dto.ListFilter;
import org.food.safety.trace.dto.PageSearch;
import org.food.safety.trace.dto.SearchFilter;

import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

/**
 * CURD 服务 接口
 * User: tom
 * Date: 2017/8/25
 */
public interface CURDService {
    List list(String name, ListFilter listFilter);

//    Page page(PageSearch pageSearch);
//
//    Object detail(ID id);
//
    Object createOrUpdte(String name, Object entity);

//    void delete(ID id);
}
