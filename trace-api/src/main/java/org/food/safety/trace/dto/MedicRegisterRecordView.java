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
public class MedicRegisterRecordView extends BusinessView {
    public static final String TARGET_NAME = "MedicRegisterRecord";
    public SelectItemView petIdSelectItem;

    @Transient
    public SelectItemView getPetIdSelectItem() {
        return petIdSelectItem;
    }

    public SelectItemView itemCodeSelectItem;

    @Transient
    public SelectItemView getItemCodeSelectItem() {
        return itemCodeSelectItem;
    }
//
//    public SelectItemView statusSelectItem;
//
//    @Transient
//    public SelectItemView getStatusSelectItem() {
//        return statusSelectItem;
//    }
//
//    public SelectItemView birthStatusSelectItem;
//
//    @Transient
//    public SelectItemView getBirthStatusSelectItem() {
//        return birthStatusSelectItem;
//    }
//
//    public SelectItemView petSkinColorSelectItem;
//
//    @Transient
//    public SelectItemView getPetSkinColorSelectItem() {
//        return petSkinColorSelectItem;
//    }
//
//    public SelectItemView petRaceSelectItem;
//
//    @Transient
//    public SelectItemView getPetRaceSelectItem() {
//        return petRaceSelectItem;
//    }
//
//    public SelectItemView petBreedSelectItem;
//
//    @Transient
//    public SelectItemView getPetBreedSelectItem() {
//        return petBreedSelectItem;
//    }


}
