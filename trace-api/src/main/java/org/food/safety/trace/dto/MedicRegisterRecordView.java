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

    public SelectItemView assistantDoctorIdSelectItem;

    @Transient
    public SelectItemView getAssistantDoctorIdSelectItem() {
        return assistantDoctorIdSelectItem;
    }
    public SelectItemView doctorIdSelectItem;

    @Transient
    public SelectItemView getDoctorIdSelectItem() {
        return doctorIdSelectItem;
    }
    public SelectItemView paidStatusSelectItem;

    @Transient
    public SelectItemView getPaidStatusSelectItem() {
        return paidStatusSelectItem;
    }



}
