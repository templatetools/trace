package org.food.safety.trace.dto;

import lombok.Setter;
import lombok.ToString;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * Created by tom on 2017/8/28.
 */
@Setter
@ToString
@MappedSuperclass
public class MenuView implements SelectViewable {
    public static final String TARGET_NAME="Menu";

    public SelectItemView mpidSelectItem;
    @Transient
    public SelectItemView getMpidSelectItem() {
        return mpidSelectItem;
    }
}
