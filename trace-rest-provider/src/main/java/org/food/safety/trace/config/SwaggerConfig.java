package org.food.safety.trace.config;

import io.swagger.jaxrs.config.BeanConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by X on 2017/4/11.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public BeanConfig beanConfig() {
        BeanConfig beanConfig = new BeanConfig();

        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setResourcePackage("org.food.safety.trace.facade");
        beanConfig.setVersion("1.0");
        beanConfig.setHost("127.0.0.1:7890");
        beanConfig.setBasePath("/trace/api");
        beanConfig.setTitle(" Api");
        beanConfig.setDescription(" Api");
        beanConfig.setScan(true);

        return beanConfig;
    }

}
