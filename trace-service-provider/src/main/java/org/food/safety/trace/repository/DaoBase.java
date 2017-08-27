package org.food.safety.trace.repository;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * User: tom
 * Date: 2017/8/25
 */
@NoRepositoryBean
public class DaoBase<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>{
    public DaoBase(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
    }
}
