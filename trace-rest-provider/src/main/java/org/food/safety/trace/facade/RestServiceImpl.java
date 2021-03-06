package org.food.safety.trace.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.MethodUtils;
import org.food.safety.trace.dto.*;
import org.food.safety.trace.service.CURDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * Created by X on 2017/8/25.
 */
@Service(protocol = "rest")
@Path("rest")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Api(value = "rest", description = "dbrest接口")
@Getter
@Setter
@Slf4j
public class RestServiceImpl implements RestService {
    @Autowired
    private CURDService curdService;

    @Override
    public void setService(CURDService curdService) {
        this.curdService = curdService;
    }

    @Override
    public RestResult<List> list(@HeaderParam(HEADER_AUTHORIZATION_KEY) String token, String version, String name, ListFilter listFilter) {
        log.debug("listFilter:{}", listFilter);
        List list = curdService.list(new Token(token),name, listFilter);
        log.debug("list result:{}", list);
        return RestResult.OK(list);
    }

    @Override
    public RestResult<Object> method(@HeaderParam(HEADER_AUTHORIZATION_KEY) String token, String version, String name, String method, Map data) {
        log.debug("exec {} :{}", method, data);
        Object result = null;

        try {
            data.put(TOKEN, token);
            result = MethodUtils.invokeMethod(this.getCurdService(), method, data);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e.getMessage(),e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e.getMessage(),e);
        } catch (InvocationTargetException e) {
            if (e.getTargetException() instanceof RuntimeException){
                RuntimeException re = (RuntimeException) e.getTargetException();
                throw re;
            }else {
                throw new RuntimeException(e.getTargetException().getMessage(), e.getTargetException());
            }
        }

        return RestResult.OK(result);
    }

    @Override
    public RestResult<List> viewList(@HeaderParam(HEADER_AUTHORIZATION_KEY) String token, String version, String name) {
        log.debug("viewList:{}", name);
        List list = curdService.viewList(name);
        log.debug("viewList result:{}", list);
        return RestResult.OK(list);
    }

    @Override
    public RestResult<Page<Viewable>> page(@HeaderParam(HEADER_AUTHORIZATION_KEY) String token, String version, String name, PageSearch pageSearch) {
        log.debug("pageSearch:{}", pageSearch);
        Page page = curdService.page(new Token(token),name, pageSearch);
        log.debug("pageSearch result:{}", page);
        return RestResult.OK(page);
    }

    @Override
    public RestResult<Viewable> detail(@HeaderParam(HEADER_AUTHORIZATION_KEY) String token, String version, String name,@ApiParam("id") String id) {
        log.debug("detail:{}", id);
        Object result = null;

        result = curdService.detail(new Token(token),name, id);

        log.debug("detail result:{}", result);
        return RestResult.OK(result);
    }

    @Override
    public RestResult<String> delete(@HeaderParam(HEADER_AUTHORIZATION_KEY) String token, String version, String name, @ApiParam("id") String id) {
        log.debug("delete:{}", id);
        Object result = null;

        result = curdService.delete(new Token(token),name, id);

        log.debug("delete result:{}", result);
        return RestResult.OK(result);
    }

    @Override
    public RestResult<Viewable> createOrUpdate(@HeaderParam(HEADER_AUTHORIZATION_KEY) String token, String version, String name, String data) {
        log.debug("createOrUpdate:{}", data);
        Object result = null;

        result = curdService.createOrUpdte(new Token(token),name, data);

        log.debug("createOrUpdate result:{}", result);
        return RestResult.OK(result);
    }
}
