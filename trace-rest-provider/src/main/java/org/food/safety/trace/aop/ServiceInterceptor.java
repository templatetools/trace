package org.food.safety.trace.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.food.safety.trace.facade.RestService;
import org.food.safety.trace.service.CURDService;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

import static org.food.safety.trace.util.StringUitls.captureName;

/**
 * 动态服务注册 切面
 * Created by tom on 16/6/28.
 */
@Component
@Order(1)
@Aspect
@Slf4j
public class ServiceInterceptor {
    @Autowired
    private ApplicationContext applicationContext;

    @Pointcut("execution(* org.food.safety.trace.facade.RestService+.*(..))")
    private void anyMethod() {
    }//定义一个切入点

    @Before(value = "anyMethod() && args(token,version,name,..)", argNames = "point, token,version,name")
    public void doAccessCheck(JoinPoint point, String token,String version,String name) {
        log.debug("proxy service :{}", name);

        try {
            RestService restService = (RestService) point.getTarget();

            CURDService curdService = (CURDService) applicationContext.getBean(captureName(name) + "ServiceImpl");

            if (null != curdService) {
                restService.setService(curdService);
            }
        }catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException){
            log.info("{}, 无扩展服务!", name);
        } catch (Exception e) {
            log.warn("动态服务注册失败!", e);
        }
    }
}
