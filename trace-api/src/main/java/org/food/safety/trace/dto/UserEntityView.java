package org.food.safety.trace.dto;

import lombok.Setter;
import lombok.ToString;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.util.List;

/**
 * Created by tom on 2017/8/28.
 */
@Setter
@ToString
@MappedSuperclass
public class UserEntityView implements SelectViewable {
    public List<SelectItemView> rolesList;
    @Transient
    public List<SelectItemView> getRolesList() {
        return rolesList;
    }
}
