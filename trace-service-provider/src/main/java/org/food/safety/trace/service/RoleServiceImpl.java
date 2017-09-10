package org.food.safety.trace.service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.food.safety.trace.dto.SelectItemView;
import org.food.safety.trace.entity.ListView;
import org.food.safety.trace.entity.Reference;
import org.food.safety.trace.repository.ReferenceDao;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
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
        ReferenceDao referenceDao = getReferenceDao();

        List<ListView> columns = viewList(name);
        for (ListView view : columns) {
            if (StringUtils.isNotEmpty(view.getRefType())) {

                for (Object d : data) {
                    try {
                        List<Reference> references = referenceDao.findBySourceId(PropertyUtils.getProperty(d, "id") + "");

                        List<SelectItemView> selectItemViews = new ArrayList<>();

                        for (Reference reference : references) {
                            SelectItemView selectItemView = new SelectItemView();
                            selectItemView.setKey(reference.getTargetId());

                            Object target = this.detail(reference.getTargetName(), reference.getTargetId());

                            selectItemView.setLabel(PropertyUtils.getProperty(target, "name") + "");
                            selectItemViews.add(selectItemView);
                        }

                        PropertyUtils.setProperty(d, view.getName() + "List", selectItemViews);
                    } catch (Exception e) {
                        log.debug("set list:{}", view.getName(), e);
                    }
                }
            }
        }
    }
}
