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
public class ItemTypeView extends BusinessView {
    public static final String TARGET_NAME="ItemType";

    public SelectItemView cateNoSelectItem;
    @Transient
    public SelectItemView getCateNoSelectItem() {
        return cateNoSelectItem;
    }
    public SelectItemView packageUnitSelectItem;
    @Transient
    public SelectItemView getPackageUnitSelectItem() {
        return packageUnitSelectItem;
    }

}
