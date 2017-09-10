package org.food.safety.trace.dto;

import lombok.Setter;
import lombok.ToString;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.util.List;
import java.util.Map;

/**
 * Created by tom on 2017/8/28.
 */
@Setter
@ToString
@MappedSuperclass
public class RoleView implements Viewable {
    public List<SelectItemView> menusList;
    @Transient
    public List<SelectItemView> getMenusList() {
        return menusList;
    }
}
