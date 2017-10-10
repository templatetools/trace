package org.food.safety.trace.dto;

import lombok.Setter;
import lombok.ToString;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.util.List;

/**
 * Created by tom on 2017/8/28.
 */
@Setter
@ToString
@MappedSuperclass
public class OrganizationView implements SelectViewable {
    public static final String FIELD_NAME="organization";

    public SelectItemView organizationSelectItem;
    @Transient
    public SelectItemView getOrganizationSelectItem() {
        return organizationSelectItem;
    }
}
