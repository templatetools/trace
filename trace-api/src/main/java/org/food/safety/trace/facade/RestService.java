package org.food.safety.trace.facade;

import io.swagger.annotations.ApiOperation;
import org.food.safety.trace.dto.ListFilter;
import org.food.safety.trace.dto.RestResult;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

/**
 * Created by X on 2017/4/17.
 */
public interface RestService {
    String HEADER_AUTHORIZATION_KEY = "authorization";

    @POST
    @Path("/{version}/{name}/list")
    @ApiOperation("列表")
    RestResult<List> list(@HeaderParam(HEADER_AUTHORIZATION_KEY) String token, @PathParam("version") String version, @PathParam("name") String name, ListFilter listFilter);

    @POST
    @Path("/{version}/{name}")
    @ApiOperation("添加/修改")
    RestResult<Object> createOrUpdate(@HeaderParam(HEADER_AUTHORIZATION_KEY) String token, @PathParam("version") String version, @PathParam("name") String name, String data);
}
