package org.food.safety.trace.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: tom
 * Date: 2017/4/19
 * Time: 14:33
 * {fieldName:'dictTypeId',operator:'EQ',type:'ref',value:{type:'UserDict',fieldName:'name',operator:'EQ',value:'物品单位'}}
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@ApiModel("搜索过滤条件")
@Setter
@Getter
public class SearchFilter implements Serializable {
    public static final String FILTER_TYPE_REF = "REF";
    @ApiModelProperty("属性名称")
    public String fieldName;

    @ApiModelProperty("搜索内容")
    public Object value;

    @ApiModelProperty("搜索条件 EQ, LIKE, GT, LT, GTE, LTE")
    public SearchFilter.Operator operator;

    private String type;
    private String refField;

    public SearchFilter() {
    }

    public SearchFilter(String fieldName, SearchFilter.Operator operator, Object value) {
        this.fieldName = fieldName;
        this.value = value;
        this.operator = operator;
    }


    public SearchFilter(String fieldName, String operator, Object value) {
        this.fieldName = fieldName;
        this.value = value;
        this.operator = SearchFilter.Operator.valueOf(operator);
    }

    public void setOperator(String operator) {
        this.operator = SearchFilter.Operator.valueOf(operator);
    }

    public static enum Operator {
        EQ,
        LIKE,
        GT,
        LT,
        GTE,
        LTE,
        NOT_EQ;

        private Operator() {
        }
    }
}
