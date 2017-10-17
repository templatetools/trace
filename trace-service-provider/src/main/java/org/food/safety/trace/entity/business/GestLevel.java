package org.food.safety.trace.entity.business;
// Generated 2017-10-17 15:12:50 by Hibernate Tools 5.2.5.Final


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
 * 会员级别
 */
@Entity
@Table(name="t_gest_level"
)
public class GestLevel extends org.food.safety.trace.dto.BusinessView implements java.io.Serializable {


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
      * 名称
     */
     private String name;
     /**
      * 可积分
     */
     private String isCredit;
     /**
      * 可折扣
     */
     private String isDiscount;
     /**
      * 折扣
     */
     private String discountRate;
     /**
      * 备注
     */
     private String remark;
     /**
      * 创建时间
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
      * 状态
     */
     private String status;

    public GestLevel() {
    }

    public GestLevel(String organization, String code, String name, String isCredit, String isDiscount, String discountRate, String remark, Date createDate, String createUserId, Date updateDate, String updateUserId, String status) {
       this.organization = organization;
       this.code = code;
       this.name = name;
       this.isCredit = isCredit;
       this.isDiscount = isDiscount;
       this.discountRate = discountRate;
       this.remark = remark;
       this.createDate = createDate;
       this.createUserId = createUserId;
       this.updateDate = updateDate;
       this.updateUserId = updateUserId;
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

    
    @Column(name="level_code", insertable=false, updatable=false, length=128)
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    /**       
     *      * 名称
     */

    
    @Column(name="level_name", length=32)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    /**       
     *      * 可积分
     */

    
    @Column(name="is_credit", insertable=false, updatable=false, length=5)
    public String getIsCredit() {
        return this.isCredit;
    }
    
    public void setIsCredit(String isCredit) {
        this.isCredit = isCredit;
    }
    /**       
     *      * 可折扣
     */

    
    @Column(name="is_discount", insertable=false, updatable=false, length=5)
    public String getIsDiscount() {
        return this.isDiscount;
    }
    
    public void setIsDiscount(String isDiscount) {
        this.isDiscount = isDiscount;
    }
    /**       
     *      * 折扣
     */

    
    @Column(name="discount_rate", length=32)
    public String getDiscountRate() {
        return this.discountRate;
    }
    
    public void setDiscountRate(String discountRate) {
        this.discountRate = discountRate;
    }
    /**       
     *      * 备注
     */

    
    @Column(name="remark", length=96)
    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    /**       
     *      * 创建时间
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

    
    @Column(name="update_user_id", insertable=false, updatable=false, length=128)
    public String getUpdateUserId() {
        return this.updateUserId;
    }
    
    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }
    /**       
     *      * 状态
     */

    
    @Column(name="status", insertable=false, updatable=false, length=128)
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
      buffer.append("name").append("='").append(getName()).append("' ");			
      buffer.append("isCredit").append("='").append(getIsCredit()).append("' ");			
      buffer.append("isDiscount").append("='").append(getIsDiscount()).append("' ");			
      buffer.append("discountRate").append("='").append(getDiscountRate()).append("' ");			
      buffer.append("remark").append("='").append(getRemark()).append("' ");			
      buffer.append("createUserId").append("='").append(getCreateUserId()).append("' ");			
      buffer.append("updateUserId").append("='").append(getUpdateUserId()).append("' ");			
      buffer.append("status").append("='").append(getStatus()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }



}


