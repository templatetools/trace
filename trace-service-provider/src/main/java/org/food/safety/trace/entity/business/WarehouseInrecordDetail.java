package org.food.safety.trace.entity.business;
// Generated 2017-11-14 14:51:05 by Hibernate Tools 5.2.5.Final


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 入库单条目
 */
@Entity
@Table(name="t_warehouse_inrecord_detail"
)
public class WarehouseInrecordDetail extends org.food.safety.trace.dto.WarehouseInrecordDetailView implements java.io.Serializable {


     /**
      * id
     */
     private String id;
     /**
      * 组织
     */
     private String organization;
     /**
      * 入库单号
     */
     private String inWarehouseCode;
     /**
      * 商品
     */
     private String itemCode;
     /**
      * 条码
     */
     private String barCode;
     /**
      * 商品名称
     */
     private String itemName;
     /**
      * 规格
     */
     private String itemStandard;
     /**
      * 销售单位
     */
     private String packageUnit;
     /**
      * 生产商
     */
     private String manufacturerName;
     /**
      * 生产商
     */
     private String manufacturerCode;
     /**
      * 零散比
     */
     private Integer itemBulk;
     /**
      * 进价
     */
     private Double inputPrice;
     /**
      * 剂型
     */
     private String drugForm;
     /**
      * 类型
     */
     private String itemStyle;
     /**
      * 售价
     */
     private Double sellPrice;
     /**
      * 数量
     */
     private Integer inputCount;
     /**
      * 批号
     */
     private String batchNumber;
     /**
      * 保质期
     */
     private Integer safeDay;
     /**
      * 库存上线
     */
     private Integer wareUpLimit;
     /**
      * 库存下线
     */
     private Integer wareDownLimit;
     /**
      * 金额
     */
     private Double inputCost;
     /**
      * 生产日期
     */
     private Date produceDate;
     /**
      * 进货日期
     */
     private Date inputDate;
     /**
      * 发货日期
     */
     private Date outDateTime;
     /**
      * 登记日期
     */
     private Date createDate;
     /**
      * 创建人
     */
     private String createUserId;
     /**
      * 更新时间
     */
     private Date updateDate;
     /**
      * 更新人
     */
     private String updateUserId;
     /**
      * 备注
     */
     private String remark;
     /**
      * 备注
     */
     private String status;

    public WarehouseInrecordDetail() {
    }

    public WarehouseInrecordDetail(String organization, String inWarehouseCode, String itemCode, String barCode, String itemName, String itemStandard, String packageUnit, String manufacturerName, String manufacturerCode, Integer itemBulk, Double inputPrice, String drugForm, String itemStyle, Double sellPrice, Integer inputCount, String batchNumber, Integer safeDay, Integer wareUpLimit, Integer wareDownLimit, Double inputCost, Date produceDate, Date inputDate, Date outDateTime, Date createDate, String createUserId, Date updateDate, String updateUserId, String remark, String status) {
       this.organization = organization;
       this.inWarehouseCode = inWarehouseCode;
       this.itemCode = itemCode;
       this.barCode = barCode;
       this.itemName = itemName;
       this.itemStandard = itemStandard;
       this.packageUnit = packageUnit;
       this.manufacturerName = manufacturerName;
       this.manufacturerCode = manufacturerCode;
       this.itemBulk = itemBulk;
       this.inputPrice = inputPrice;
       this.drugForm = drugForm;
       this.itemStyle = itemStyle;
       this.sellPrice = sellPrice;
       this.inputCount = inputCount;
       this.batchNumber = batchNumber;
       this.safeDay = safeDay;
       this.wareUpLimit = wareUpLimit;
       this.wareDownLimit = wareDownLimit;
       this.inputCost = inputCost;
       this.produceDate = produceDate;
       this.inputDate = inputDate;
       this.outDateTime = outDateTime;
       this.createDate = createDate;
       this.createUserId = createUserId;
       this.updateDate = updateDate;
       this.updateUserId = updateUserId;
       this.remark = remark;
       this.status = status;
    }
   
    /**       
     *      * id
     */
     @GenericGenerator(name="generator", strategy="uuid.hex")@Id @GeneratedValue(generator="generator")

    
    @Column(name="id", nullable=false, updatable=false, length=128)
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    /**       
     *      * 组织
     */

    
    @Column(name="organization", length=128)
    public String getOrganization() {
        return this.organization;
    }
    
    public void setOrganization(String organization) {
        this.organization = organization;
    }
    /**       
     *      * 入库单号
     */

    
    @Column(name="in_warehouse_code", length=48)
    public String getInWarehouseCode() {
        return this.inWarehouseCode;
    }
    
    public void setInWarehouseCode(String inWarehouseCode) {
        this.inWarehouseCode = inWarehouseCode;
    }
    /**       
     *      * 商品
     */

    
    @Column(name="item_code", length=48)
    public String getItemCode() {
        return this.itemCode;
    }
    
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
    /**       
     *      * 条码
     */

    
    @Column(name="bar_code", length=48)
    public String getBarCode() {
        return this.barCode;
    }
    
    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
    /**       
     *      * 商品名称
     */

    
    @Column(name="item_name", length=96)
    public String getItemName() {
        return this.itemName;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    /**       
     *      * 规格
     */

    
    @Column(name="item_standard", length=48)
    public String getItemStandard() {
        return this.itemStandard;
    }
    
    public void setItemStandard(String itemStandard) {
        this.itemStandard = itemStandard;
    }
    /**       
     *      * 销售单位
     */

    
    @Column(name="package_unit", length=48)
    public String getPackageUnit() {
        return this.packageUnit;
    }
    
    public void setPackageUnit(String packageUnit) {
        this.packageUnit = packageUnit;
    }
    /**       
     *      * 生产商
     */

    
    @Column(name="manufacturer_name", length=128)
    public String getManufacturerName() {
        return this.manufacturerName;
    }
    
    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }
    /**       
     *      * 生产商
     */

    
    @Column(name="manufacturer_code", length=48)
    public String getManufacturerCode() {
        return this.manufacturerCode;
    }
    
    public void setManufacturerCode(String manufacturerCode) {
        this.manufacturerCode = manufacturerCode;
    }
    /**       
     *      * 零散比
     */

    
    @Column(name="item_bulk", length=11)
    public Integer getItemBulk() {
        return this.itemBulk;
    }
    
    public void setItemBulk(Integer itemBulk) {
        this.itemBulk = itemBulk;
    }
    /**       
     *      * 进价
     */

    
    @Column(name="input_price")
    public Double getInputPrice() {
        return this.inputPrice;
    }
    
    public void setInputPrice(Double inputPrice) {
        this.inputPrice = inputPrice;
    }
    /**       
     *      * 剂型
     */

    
    @Column(name="drug_form", length=48)
    public String getDrugForm() {
        return this.drugForm;
    }
    
    public void setDrugForm(String drugForm) {
        this.drugForm = drugForm;
    }
    /**       
     *      * 类型
     */

    
    @Column(name="item_style", length=48)
    public String getItemStyle() {
        return this.itemStyle;
    }
    
    public void setItemStyle(String itemStyle) {
        this.itemStyle = itemStyle;
    }
    /**       
     *      * 售价
     */

    
    @Column(name="sell_price")
    public Double getSellPrice() {
        return this.sellPrice;
    }
    
    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }
    /**       
     *      * 数量
     */

    
    @Column(name="input_count", length=11)
    public Integer getInputCount() {
        return this.inputCount;
    }
    
    public void setInputCount(Integer inputCount) {
        this.inputCount = inputCount;
    }
    /**       
     *      * 批号
     */

    
    @Column(name="batch_number", length=48)
    public String getBatchNumber() {
        return this.batchNumber;
    }
    
    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }
    /**       
     *      * 保质期
     */

    
    @Column(name="safe_day", length=11)
    public Integer getSafeDay() {
        return this.safeDay;
    }
    
    public void setSafeDay(Integer safeDay) {
        this.safeDay = safeDay;
    }
    /**       
     *      * 库存上线
     */

    
    @Column(name="ware_up_limit", length=11)
    public Integer getWareUpLimit() {
        return this.wareUpLimit;
    }
    
    public void setWareUpLimit(Integer wareUpLimit) {
        this.wareUpLimit = wareUpLimit;
    }
    /**       
     *      * 库存下线
     */

    
    @Column(name="ware_down_limit", length=11)
    public Integer getWareDownLimit() {
        return this.wareDownLimit;
    }
    
    public void setWareDownLimit(Integer wareDownLimit) {
        this.wareDownLimit = wareDownLimit;
    }
    /**       
     *      * 金额
     */

    
    @Column(name="input_cost")
    public Double getInputCost() {
        return this.inputCost;
    }
    
    public void setInputCost(Double inputCost) {
        this.inputCost = inputCost;
    }
    /**       
     *      * 生产日期
     */

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="produce_date", nullable=false, insertable=false, updatable=false)
    public Date getProduceDate() {
        return this.produceDate;
    }
    
    public void setProduceDate(Date produceDate) {
        this.produceDate = produceDate;
    }
    /**       
     *      * 进货日期
     */

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="input_date", nullable=false, insertable=false, updatable=false)
    public Date getInputDate() {
        return this.inputDate;
    }
    
    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }
    /**       
     *      * 发货日期
     */

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="out_date_time", nullable=false, insertable=false, updatable=false)
    public Date getOutDateTime() {
        return this.outDateTime;
    }
    
    public void setOutDateTime(Date outDateTime) {
        this.outDateTime = outDateTime;
    }
    /**       
     *      * 登记日期
     */

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date", nullable=false, insertable=false, updatable=false)
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    /**       
     *      * 创建人
     */

    
    @Column(name="create_user_id", insertable=false, updatable=false, length=128)
    public String getCreateUserId() {
        return this.createUserId;
    }
    
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }
    /**       
     *      * 更新时间
     */

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_date", nullable=false, insertable=false, updatable=false)
    public Date getUpdateDate() {
        return this.updateDate;
    }
    
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    /**       
     *      * 更新人
     */

    
    @Column(name="update_user_id", length=128)
    public String getUpdateUserId() {
        return this.updateUserId;
    }
    
    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }
    /**       
     *      * 备注
     */

    
    @Column(name="remark", insertable=false, updatable=false, length=96)
    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    /**       
     *      * 备注
     */

    
    @Column(name="status", insertable=false, updatable=false, length=32)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * toString
     * @return String
     */
     public String toString() {
	  StringBuffer buffer = new StringBuffer();

      buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
      buffer.append("organization").append("='").append(getOrganization()).append("' ");			
      buffer.append("inWarehouseCode").append("='").append(getInWarehouseCode()).append("' ");			
      buffer.append("itemCode").append("='").append(getItemCode()).append("' ");			
      buffer.append("barCode").append("='").append(getBarCode()).append("' ");			
      buffer.append("itemName").append("='").append(getItemName()).append("' ");			
      buffer.append("itemStandard").append("='").append(getItemStandard()).append("' ");			
      buffer.append("packageUnit").append("='").append(getPackageUnit()).append("' ");			
      buffer.append("manufacturerName").append("='").append(getManufacturerName()).append("' ");			
      buffer.append("manufacturerCode").append("='").append(getManufacturerCode()).append("' ");			
      buffer.append("itemBulk").append("='").append(getItemBulk()).append("' ");			
      buffer.append("inputPrice").append("='").append(getInputPrice()).append("' ");			
      buffer.append("drugForm").append("='").append(getDrugForm()).append("' ");			
      buffer.append("itemStyle").append("='").append(getItemStyle()).append("' ");			
      buffer.append("sellPrice").append("='").append(getSellPrice()).append("' ");			
      buffer.append("inputCount").append("='").append(getInputCount()).append("' ");			
      buffer.append("batchNumber").append("='").append(getBatchNumber()).append("' ");			
      buffer.append("safeDay").append("='").append(getSafeDay()).append("' ");			
      buffer.append("wareUpLimit").append("='").append(getWareUpLimit()).append("' ");			
      buffer.append("wareDownLimit").append("='").append(getWareDownLimit()).append("' ");			
      buffer.append("inputCost").append("='").append(getInputCost()).append("' ");			
      buffer.append("createUserId").append("='").append(getCreateUserId()).append("' ");			
      buffer.append("updateUserId").append("='").append(getUpdateUserId()).append("' ");			
      buffer.append("remark").append("='").append(getRemark()).append("' ");			
      buffer.append("status").append("='").append(getStatus()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }



}


