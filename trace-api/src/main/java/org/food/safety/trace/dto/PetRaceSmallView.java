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
public class PetRaceSmallView extends OrganizationView {
    public static final String TARGET_NAME="PetRaceSmall";

    public SelectItemView petRaceIdSelectItem;
    @Transient
    public SelectItemView getPetRaceIdSelectItem() {
        return petRaceIdSelectItem;
    }
}
