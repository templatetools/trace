package org.food.safety.trace.facade;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.food.safety.trace.dto.ListFilter;
import org.food.safety.trace.dto.PageSearch;
import org.food.safety.trace.dto.RestResult;
import org.food.safety.trace.dto.Viewable;
import org.springframework.data.domain.Page;

import javax.ws.rs.*;
import java.io.Serializable;
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
    RestResult<Viewable> createOrUpdate(@HeaderParam(HEADER_AUTHORIZATION_KEY) String token, @PathParam("version") String version, @PathParam("name") String name, String data);

    @POST
    @Path("/{version}/{name}/page")
    @ApiOperation("分页")
    RestResult<Page<Viewable>> page(@HeaderParam(HEADER_AUTHORIZATION_KEY) String token, @PathParam("version") String version, @PathParam("name") String name,PageSearch pageSearch);

    @GET
    @Path("/{version}/{name}/{id}")
    @ApiOperation("详细信息")
    RestResult<Viewable> detail(@HeaderParam(HEADER_AUTHORIZATION_KEY) String token, @PathParam("version") String version, @PathParam("name") String name,@ApiParam("id") @PathParam("id") String id);

    @DELETE
    @Path("/{version}/{name}/{id}")
    @ApiOperation("删除")
    RestResult<String> delete(@HeaderParam(HEADER_AUTHORIZATION_KEY) String token, @PathParam("version") String version, @PathParam("name") String name,@ApiParam("id") @PathParam("id") String id);
}
