package org.food.safety.trace.service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.food.safety.trace.dto.OrganizationView;
import org.food.safety.trace.dto.Token;
import org.food.safety.trace.dto.Viewable;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.lang.reflect.InvocationTargetException;

/**
 * User: tom
 * Date: 2017/8/25
 */
@Service
@Getter
@Slf4j
public class OrganizationServiceImpl extends CURDServiceImpl {
    @Override
    public void createAfter(Token token, @NotNull String name, @NotNull Object entity) {
        super.createAfter(token, name, entity);
        try {
            if (null == BeanUtils.getProperty(entity, OrganizationView.FIELD_NAME)) {
                BeanUtils.setProperty(entity, OrganizationView.FIELD_NAME, BeanUtils.getProperty(entity, "id") + "");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
