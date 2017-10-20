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
public class GestView extends BusinessView {
    public static final String TARGET_NAME="Gest";

    public SelectItemView gestSexSelectItem;
    @Transient
    public SelectItemView getGestSexSelectItem() {
        return gestSexSelectItem;
    }

    public SelectItemView gestStyleSelectItem;
    @Transient
    public SelectItemView getGestStyleSelectItem() {
        return gestStyleSelectItem;
    }

    public SelectItemView statusSelectItem;
    @Transient
    public SelectItemView getStatusSelectItem() {
        return statusSelectItem;
    }

    public SelectItemView isVipSelectItem;
    @Transient
    public SelectItemView getIsVipSelectItem() {
        return isVipSelectItem;
    }






}
