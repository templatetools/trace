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
public class DictTypeDetailView extends BusinessView {
    public static final String TARGET_NAME="DictTypeDetail";

    public SelectItemView dictTypeIdSelectItem;
    @Transient
    public SelectItemView getDictTypeIdSelectItem() {
        return dictTypeIdSelectItem;
    }
}
