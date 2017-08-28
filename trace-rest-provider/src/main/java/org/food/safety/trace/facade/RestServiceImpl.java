package org.food.safety.trace.facade;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.food.safety.trace.dto.ListFilter;
import org.food.safety.trace.dto.PageSearch;
import org.food.safety.trace.dto.RestResult;
import org.food.safety.trace.dto.Viewable;
import org.food.safety.trace.service.CURDService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

/**
 * Created by X on 2017/8/25.
 */
@Service(protocol = "rest")
@Path("rest")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Api(value = "rest", description = "dbrest接口")
@Getter
@Slf4j
public class RestServiceImpl implements RestService {
    @Autowired
    private CURDService curdService;

    @Override
    public RestResult<List> list(@HeaderParam(HEADER_AUTHORIZATION_KEY) String token, String version, String name, ListFilter listFilter) {
        log.debug("listFilter:{}", listFilter);
        List list = curdService.list(name, listFilter);
        log.debug("list result:{}", list);
        return RestResult.OK(list);
    }

    @Override
    public RestResult<Page<Viewable>> page(@HeaderParam(HEADER_AUTHORIZATION_KEY) String token, String version, String name, PageSearch pageSearch) {
        log.debug("pageSearch:{}", pageSearch);
        Page page = curdService.page(name, pageSearch);
        log.debug("pageSearch result:{}", page);
        return RestResult.OK(page);
    }

    @Override
    public RestResult<Viewable> detail(@ApiParam("id") String id) {
        return null;
    }

    @Override
    public RestResult<Viewable> createOrUpdate(@HeaderParam(HEADER_AUTHORIZATION_KEY) String token, String version, String name, String data) {
        log.debug("createOrUpdate:{}", data);
        Object result = null;

        result = curdService.createOrUpdte(name, data);

        log.debug("createOrUpdate result:{}", result);
        return RestResult.OK(result);
    }
}
