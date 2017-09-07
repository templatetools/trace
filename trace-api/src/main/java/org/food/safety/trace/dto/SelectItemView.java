package org.food.safety.trace.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created by tom on 2017/8/28.
 */
@Getter
@Setter
@ToString
public class SelectItemView implements Viewable {
    private String key;
    private String label;
}
