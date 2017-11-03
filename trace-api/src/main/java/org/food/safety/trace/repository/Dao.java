package org.food.safety.trace.repository;

import org.food.safety.trace.dto.ListFilter;
import org.food.safety.trace.dto.PageSearch;
import org.food.safety.trace.dto.SearchFilter;
import org.food.safety.trace.dto.Token;
import org.food.safety.trace.service.CURDService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
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
    List findAllByFilter(ListFilter listFilter);

    /**
     * 分页数据，根据过滤条件
     * @param pageSearch 分页信息
     * @return
     */
    Page page(PageSearch pageSearch);

    static <DTO> DTO findOneByKeyAndValue(Dao dao, Token token, String key, Object value) {
        DTO result = null;

        SearchFilter searchFilter = new SearchFilter(key, SearchFilter.Operator.EQ, value);

        ListFilter listFilter = new ListFilter();
        listFilter.addFilters(searchFilter);

        SearchFilter organizationSearchFilter = new SearchFilter(CURDService.FIELD_ORGANIZATION, SearchFilter.Operator.EQ, token.getOrganizationId());
        listFilter.addAndFilters(organizationSearchFilter);

        List list = dao.findAllByFilter(listFilter);

        if (null != list && list.size()>0){
            result = (DTO)list.get(0);
        }

        return result;
    }
}
