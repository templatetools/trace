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
public class WarehouseInrecordDetailView extends BusinessView {
    public static final String TARGET_NAME = "WarehouseInrecordDetail";

//    public SelectItemView warehouseIdSelectItem;
//    @Transient
//    public SelectItemView getWarehouseIdSelectItem() {
//        return warehouseIdSelectItem;
//    }
//
//    public SelectItemView dealerCodeSelectItem;
//    @Transient
//    public SelectItemView getDealerCodeSelectItem() {
//        return dealerCodeSelectItem;
//    }
//
//    public SelectItemView paidStatusSelectItem;
//    @Transient
//    public SelectItemView getPaidStatusSelectItem() {
//        return paidStatusSelectItem;
//    }
//
//    public SelectItemView statusSelectItem;
//    @Transient
//    public SelectItemView getStatusSelectItem() {
//        return statusSelectItem;
//    }

}
