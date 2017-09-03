package org.food.safety.trace.repository;

import org.food.safety.trace.entity.ListView;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ListViewDao extends PagingAndSortingRepository<ListView, String> {
	List<ListView> findByEntityNameLike(String entityName);
}
