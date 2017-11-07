package org.food.safety.trace.entity.business;
// Generated 2017-11-7 14:27:05 by Hibernate Tools 5.2.5.Final


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
 * 入库管理
 */
@Entity
@Table(name="t_warehouse_inrecord"
)
public class WarehouseInrecord extends org.food.safety.trace.dto.WarehouseInrecordView implements java.io.Serializable {


     /**
      * id
     */
     private String id;
     /**
      * 组织
     */
     private String organization;
     /**
      * 编号
     */
     private String code;
     /**
      * 入库仓库
     */
     private String warehouseId;
     /**
      * 仓库名称
     */
     private String inWarehouse;
     /**
      * 入库人
     */
     private String inWarehouseMan;
     /**
      * 总金额
     */
     private Double inWarehouseTotalCost;
     /**
      * 总项
     */
     private Integer totalCount;
     /**
      * 制单时间
     */
     private Date inWarehouseDate;
     /**
      * 经销商
     */
     private String dealerCode;
     /**
      * 经销商名称
     */
     private String dealerName;
     /**
      * 备注
     */
     private String remark;
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
      * 审核时间
     */
     private Date checkDate;
     /**
      * 审核人
     */
     private String checkMan;
     /**
      * 移库名称
     */
     private String toWarehouseName;
     /**
      * 移库编号
     */
     private String toWarehouseCode;
     /**
      * 建议
     */
     private String inReason;
     /**
      * 入库条目
     */
     private String inContent;
     /**
      * 支付状态
     */
     private String paidStatus;
     /**
      * 单据状态
     */
     private String status;

    public WarehouseInrecord() {
    }

	
    public WarehouseInrecord(String code) {
        this.code = code;
    }
    public WarehouseInrecord(String organization, String code, String warehouseId, String inWarehouse, String inWarehouseMan, Double inWarehouseTotalCost, Integer totalCount, Date inWarehouseDate, String dealerCode, String dealerName, String remark, Date createDate, String createUserId, Date updateDate, String updateUserId, Date checkDate, String checkMan, String toWarehouseName, String toWarehouseCode, String inReason, String inContent, String paidStatus, String status) {
       this.organization = organization;
       this.code = code;
       this.warehouseId = warehouseId;
       this.inWarehouse = inWarehouse;
       this.inWarehouseMan = inWarehouseMan;
       this.inWarehouseTotalCost = inWarehouseTotalCost;
       this.totalCount = totalCount;
       this.inWarehouseDate = inWarehouseDate;
       this.dealerCode = dealerCode;
       this.dealerName = dealerName;
       this.remark = remark;
       this.createDate = createDate;
       this.createUserId = createUserId;
       this.updateDate = updateDate;
       this.updateUserId = updateUserId;
       this.checkDate = checkDate;
       this.checkMan = checkMan;
       this.toWarehouseName = toWarehouseName;
       this.toWarehouseCode = toWarehouseCode;
       this.inReason = inReason;
       this.inContent = inContent;
       this.paidStatus = paidStatus;
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
     *      * 编号
     */

    
    @Column(name="in_warehouse_code", nullable=false, updatable=false, length=48)
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    /**       
     *      * 入库仓库
     */

    
    @Column(name="warehouse_id", length=64)
    public String getWarehouseId() {
        return this.warehouseId;
    }
    
    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }
    /**       
     *      * 仓库名称
     */

    
    @Column(name="in_warehouse", length=48)
    public String getInWarehouse() {
        return this.inWarehouse;
    }
    
    public void setInWarehouse(String inWarehouse) {
        this.inWarehouse = inWarehouse;
    }
    /**       
     *      * 入库人
     */

    
    @Column(name="in_warehouse_man", insertable=false, updatable=false, length=48)
    public String getInWarehouseMan() {
        return this.inWarehouseMan;
    }
    
    public void setInWarehouseMan(String inWarehouseMan) {
        this.inWarehouseMan = inWarehouseMan;
    }
    /**       
     *      * 总金额
     */

    
    @Column(name="in_warehouse_total_cost")
    public Double getInWarehouseTotalCost() {
        return this.inWarehouseTotalCost;
    }
    
    public void setInWarehouseTotalCost(Double inWarehouseTotalCost) {
        this.inWarehouseTotalCost = inWarehouseTotalCost;
    }
    /**       
     *      * 总项
     */

    
    @Column(name="total_count")
    public Integer getTotalCount() {
        return this.totalCount;
    }
    
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
    /**       
     *      * 制单时间
     */

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="in_warehouse_date", nullable=false, insertable=false, updatable=false)
    public Date getInWarehouseDate() {
        return this.inWarehouseDate;
    }
    
    public void setInWarehouseDate(Date inWarehouseDate) {
        this.inWarehouseDate = inWarehouseDate;
    }
    /**       
     *      * 经销商
     */

    
    @Column(name="Dealer_Code", length=48)
    public String getDealerCode() {
        return this.dealerCode;
    }
    
    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
    }
    /**       
     *      * 经销商名称
     */

    
    @Column(name="Dealer_Name", length=128)
    public String getDealerName() {
        return this.dealerName;
    }
    
    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }
    /**       
     *      * 备注
     */

    
    @Column(name="remark")
    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
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
     *      * 审核时间
     */

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="check_date", nullable=false, insertable=false)
    public Date getCheckDate() {
        return this.checkDate;
    }
    
    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }
    /**       
     *      * 审核人
     */

    
    @Column(name="check_man", insertable=false, length=48)
    public String getCheckMan() {
        return this.checkMan;
    }
    
    public void setCheckMan(String checkMan) {
        this.checkMan = checkMan;
    }
    /**       
     *      * 移库名称
     */

    
    @Column(name="To_Warehouse_Name", insertable=false, length=48)
    public String getToWarehouseName() {
        return this.toWarehouseName;
    }
    
    public void setToWarehouseName(String toWarehouseName) {
        this.toWarehouseName = toWarehouseName;
    }
    /**       
     *      * 移库编号
     */

    
    @Column(name="To_Warehouse_Code", insertable=false, length=48)
    public String getToWarehouseCode() {
        return this.toWarehouseCode;
    }
    
    public void setToWarehouseCode(String toWarehouseCode) {
        this.toWarehouseCode = toWarehouseCode;
    }
    /**       
     *      * 建议
     */

    
    @Column(name="in_reason", insertable=false, updatable=false, length=96)
    public String getInReason() {
        return this.inReason;
    }
    
    public void setInReason(String inReason) {
        this.inReason = inReason;
    }
    /**       
     *      * 入库条目
     */

    
    @Column(name="in_content")
    public String getInContent() {
        return this.inContent;
    }
    
    public void setInContent(String inContent) {
        this.inContent = inContent;
    }
    /**       
     *      * 支付状态
     */

    
    @Column(name="paid_status", insertable=false, length=32)
    public String getPaidStatus() {
        return this.paidStatus;
    }
    
    public void setPaidStatus(String paidStatus) {
        this.paidStatus = paidStatus;
    }
    /**       
     *      * 单据状态
     */

    
    @Column(name="status", insertable=false, length=32)
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
      buffer.append("code").append("='").append(getCode()).append("' ");			
      buffer.append("warehouseId").append("='").append(getWarehouseId()).append("' ");			
      buffer.append("inWarehouse").append("='").append(getInWarehouse()).append("' ");			
      buffer.append("inWarehouseMan").append("='").append(getInWarehouseMan()).append("' ");			
      buffer.append("inWarehouseTotalCost").append("='").append(getInWarehouseTotalCost()).append("' ");			
      buffer.append("totalCount").append("='").append(getTotalCount()).append("' ");			
      buffer.append("dealerCode").append("='").append(getDealerCode()).append("' ");			
      buffer.append("dealerName").append("='").append(getDealerName()).append("' ");			
      buffer.append("remark").append("='").append(getRemark()).append("' ");			
      buffer.append("createUserId").append("='").append(getCreateUserId()).append("' ");			
      buffer.append("updateUserId").append("='").append(getUpdateUserId()).append("' ");			
      buffer.append("checkMan").append("='").append(getCheckMan()).append("' ");			
      buffer.append("toWarehouseName").append("='").append(getToWarehouseName()).append("' ");			
      buffer.append("toWarehouseCode").append("='").append(getToWarehouseCode()).append("' ");			
      buffer.append("inReason").append("='").append(getInReason()).append("' ");			
      buffer.append("inContent").append("='").append(getInContent()).append("' ");			
      buffer.append("paidStatus").append("='").append(getPaidStatus()).append("' ");			
      buffer.append("status").append("='").append(getStatus()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }



}


