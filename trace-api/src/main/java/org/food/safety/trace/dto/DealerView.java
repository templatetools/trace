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
public class DealerView extends BusinessView {
    public SelectItemView companyTypeSelectItem;
    @Transient
    public SelectItemView getCompanyTypeSelectItem() {
        return companyTypeSelectItem;
    }
}
