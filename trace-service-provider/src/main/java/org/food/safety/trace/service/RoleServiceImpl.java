package org.food.safety.trace.service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.food.safety.trace.dto.SearchFilter;
import org.food.safety.trace.dto.SelectItemView;
import org.food.safety.trace.entity.ListView;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: tom
 * Date: 2017/8/25
 */
@Service
@Getter
@Slf4j
public class RoleServiceImpl extends CURDServiceImpl {
    @Override
    public void queryAfter(String name, @NotNull List data) {

        List<ListView> columns = viewList(name);
        for (ListView view: columns){
            if (StringUtils.isNotEmpty(view.getRefType())){
                for (Object d: data) {
                    List<SelectItemView> selectItemViews = new ArrayList<>();
                    SelectItemView selectItemView = new SelectItemView();
                    selectItemView.setKey("12");
                    selectItemView.setLabel("测试");
                    selectItemViews.add(selectItemView);

                    try {
                        PropertyUtils.setProperty(d, view.getName() + "List", selectItemViews);
                    } catch (Exception e) {
                        log.debug("set list:{}",view.getName(),e);
                    }
                }
            }
        }
    }
}
