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
public class PetView extends BusinessView {
    public static final String TARGET_NAME = "Gest";

    public SelectItemView gestIdSelectItem;

    @Transient
    public SelectItemView getGestIdSelectItem() {
        return gestIdSelectItem;
    }

    public SelectItemView petSexSelectItem;

    @Transient
    public SelectItemView getPetSexSelectItem() {
        return petSexSelectItem;
    }

    public SelectItemView statusSelectItem;

    @Transient
    public SelectItemView getStatusSelectItem() {
        return statusSelectItem;
    }

    public SelectItemView birthStatusSelectItem;

    @Transient
    public SelectItemView getBirthStatusSelectItem() {
        return birthStatusSelectItem;
    }

    public SelectItemView petSkinColorSelectItem;

    @Transient
    public SelectItemView getPetSkinColorSelectItem() {
        return petSkinColorSelectItem;
    }

    public SelectItemView petRaceSelectItem;

    @Transient
    public SelectItemView getPetRaceSelectItem() {
        return petRaceSelectItem;
    }

    public SelectItemView petBreedSelectItem;

    @Transient
    public SelectItemView getPetBreedSelectItem() {
        return petBreedSelectItem;
    }


}
