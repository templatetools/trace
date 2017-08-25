package org.food.safety.trace.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import io.swagger.annotations.Api;
import lombok.Getter;
import org.food.safety.trace.dto.ListFilter;
import org.food.safety.trace.dto.RestResult;
import org.food.safety.trace.service.CURDService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
public class RestServiceImpl implements RestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestServiceImpl.class);

    @Autowired
    private CURDService curdService;

    @Override
    public RestResult<List> list(@HeaderParam(HEADER_AUTHORIZATION_KEY) String token, String version, String name, ListFilter listFilter) {
        LOGGER.debug("listFilter:{}", listFilter);
        List list = curdService.list(name, listFilter);
        LOGGER.debug("list result:{}", list);
        return RestResult.OK(list);
    }
}
