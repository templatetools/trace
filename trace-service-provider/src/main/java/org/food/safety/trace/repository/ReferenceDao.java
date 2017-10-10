package org.food.safety.trace.repository;

import org.food.safety.trace.entity.Reference;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ReferenceDao extends PagingAndSortingRepository<Reference, String> {

    List<Reference> findBySourceId(String id);

    List<Reference> findByTargetNameAndSourceId(String targetName, String id);

    @Query("delete from Reference where sourceId=?1")
    @Modifying
    void deleteBySourceId(String id);
}
