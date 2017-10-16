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
public class ItemCateView extends BusinessView {
    public static final String TARGET_NAME="ItemCate";

    public SelectItemView busiTypeIdSelectItem;
    @Transient
    public SelectItemView getBusiTypeIdSelectItem() {
        return busiTypeIdSelectItem;
    }
}
