package org.food.safety.trace.repository;

import org.food.safety.trace.entity.Menu;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MenuDao extends PagingAndSortingRepository<Menu, String> {

}
