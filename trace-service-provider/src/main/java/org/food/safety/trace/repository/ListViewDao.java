package org.food.safety.trace.repository;

import org.food.safety.trace.entity.ListView;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
@CacheConfig(cacheNames = "ListView")
public interface ListViewDao extends PagingAndSortingRepository<ListView, String> {

	@Cacheable
	List<ListView> findByEntityNameLike(String entityName);
}
