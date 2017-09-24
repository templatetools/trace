package org.food.safety.trace.extension;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.NewCookie;
import java.io.IOException;
import java.time.Instant;

/**
 * URL地址检查
 *
 * @author tom
 */
public class TimerFilter implements ContainerRequestFilter, ContainerResponseFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimerFilter.class);

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        requestContext.setProperty("timer", Instant.now().toEpochMilli());
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        Object timer = requestContext.getProperty("timer");

        if (timer != null) {
            Long beginTimer = Long.parseLong(timer.toString());
            Long endTimer = Instant.now().toEpochMilli();
            Long elapsedTime = endTimer - beginTimer;
            LOGGER.debug("{}，请求耗时: {} ms", requestContext.getUriInfo().getPath(), elapsedTime);
        }
    }
}
