package org.food.safety.trace.facade;

import com.alibaba.dubbo.config.annotation.Service;
import io.swagger.jersey.listing.ApiListingResourceJSON;

/**
 * Created by tom on 2017/5/5.
 */
@Service(protocol = "rest")
public class DubboxSwaggerServiceImpl extends ApiListingResourceJSON implements DubboxSwaggerService {

}
