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
public class BusinessView extends OrganizationView {
    public final static String SERIAL_NUMBER = "SerialNumber";
    public final static String SERIAL_NUMBER_NUM = "serialNum";

    public final static String APP_CONFIG = "AppConfig";
    public final static String APP_CONFIG_CONFIG_VALUE = "configValue";
}
