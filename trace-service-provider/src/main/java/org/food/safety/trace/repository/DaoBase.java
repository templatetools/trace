package org.food.safety.trace.repository;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.food.safety.trace.dto.ListFilter;
import org.food.safety.trace.dto.SearchFilter;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.convert.QueryByExamplePredicateBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User: tom
 * Date: 2017/8/25
 */
@NoRepositoryBean
public class DaoBase<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements Dao<T, ID>{
    public DaoBase(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
    }

    public List findAllByFilter(ListFilter listFilter) {
        return super.findAll(new ExampleSpecification(listFilter), getSort(listFilter));
    }

    private static class ExampleSpecification<T> implements Specification<T> {
        private final ListFilter filter;

        public ExampleSpecification(ListFilter filter) {
            Assert.notNull(filter, "filter must not be null!");
            this.filter = filter;
        }

        public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            Predicate reault = criteriaBuilder.conjunction();
            Predicate orFilter = toPredicates(root, criteriaBuilder, filter.getFilters(), Predicate.BooleanOperator.OR);
            Predicate andFilter = toPredicates(root, criteriaBuilder, filter.getAndFilters(), Predicate.BooleanOperator.AND);

            if(null == orFilter){
                if (null != andFilter){
                    reault = andFilter;
                }
            }else{
                if (null == andFilter){
                    reault = orFilter;
                }
            }

            if (null != orFilter && null != andFilter){
                reault = criteriaBuilder.and(orFilter, andFilter);
            }

            return reault;
        }

        private Predicate toPredicates(Root root, CriteriaBuilder builder, List<SearchFilter> filters, Predicate.BooleanOperator whereType) {
            if (null == filters){
                return null;
            }

            ArrayList predicates = Lists.newArrayList();
            Iterator it = filters.iterator();

            while (it.hasNext()) {
                SearchFilter filter = (SearchFilter) it.next();
                String[] names = StringUtils.split(filter.fieldName, ".");
                Path expression = root.get(names[0]);
                for (int i = 1; i < names.length; i++) {
                    expression = expression.get(names[i]);
                }

                switch (filter.getOperator()) {
                    case EQ:
                        predicates.add(builder.equal(expression, filter.value));
                        break;
                    case LIKE:
                        predicates.add(builder.like(expression, "%" + filter.value + "%"));
                        break;
                    case GT:
                        predicates.add(builder.greaterThan(expression, (Comparable) filter.value));
                        break;
                    case LT:
                        predicates.add(builder.lessThan(expression, (Comparable) filter.value));
                        break;
                    case GTE:
                        predicates.add(builder.greaterThanOrEqualTo(expression, (Comparable) filter.value));
                        break;
                    case LTE:
                        predicates.add(builder.lessThanOrEqualTo(expression, (Comparable) filter.value));
                        break;
                    case NOT_EQ:
                        predicates.add(builder.notEqual(expression, (Comparable) filter.value));
                }
            }

            if (!predicates.isEmpty()) {
                if (Predicate.BooleanOperator.AND.equals(whereType)) {
                    return builder.and((Predicate[]) predicates.toArray(new Predicate[predicates.size()]));
                } else {
                    return builder.or((Predicate[]) predicates.toArray(new Predicate[predicates.size()]));
                }
            } else {
                return builder.conjunction();
            }
        }
    }

    private Sort getSort(@NotNull ListFilter listFilter) {
        Sort sort;
        if (listFilter.getSort() != null) {
            Splitter splitter = Splitter.on(",").omitEmptyStrings().trimResults();
            sort = new Sort(Sort.Direction.fromString(listFilter.getSort().getDirection()), splitter.splitToList(listFilter.getSort().getFieldName()));
        } else {
            sort = new Sort(Sort.Direction.DESC, new String[]{"id"});
        }
        return sort;
    }
}
