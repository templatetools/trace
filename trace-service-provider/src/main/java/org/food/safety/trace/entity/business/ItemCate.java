package org.food.safety.trace.entity.business;
// Generated 2017-10-17 18:20:21 by Hibernate Tools 5.2.5.Final


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
 * 商品类别
 */
@Entity
@Table(name="t_item_cate"
)
public class ItemCate extends org.food.safety.trace.dto.ItemCateView implements java.io.Serializable {


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
      * 上级类别
     */
     private String parentId;
     /**
      * 名称
     */
     private String name;
     /**
      * 业务类别
     */
     private String busiTypeId;
     /**
      * 零售预期毛利
     */
     private Double singleProfit;
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

    public ItemCate() {
    }

    public ItemCate(String organization, String code, String parentId, String name, String busiTypeId, Double singleProfit, Date createDate, String createUserId, Date updateDate, String updateUserId, String status) {
       this.organization = organization;
       this.code = code;
       this.parentId = parentId;
       this.name = name;
       this.busiTypeId = busiTypeId;
       this.singleProfit = singleProfit;
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

    
    @Column(name="cate_no", insertable=false, updatable=false, length=128)
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    /**       
     *      * 上级类别
     */

    
    @Column(name="parent_id", insertable=false, updatable=false, length=128)
    public String getParentId() {
        return this.parentId;
    }
    
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    /**       
     *      * 名称
     */

    
    @Column(name="cate_name", length=8)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    /**       
     *      * 业务类别
     */

    
    @Column(name="busi_type_id", length=128)
    public String getBusiTypeId() {
        return this.busiTypeId;
    }
    
    public void setBusiTypeId(String busiTypeId) {
        this.busiTypeId = busiTypeId;
    }
    /**       
     *      * 零售预期毛利
     */

    
    @Column(name="single_profit", insertable=false, updatable=false, length=128)
    public Double getSingleProfit() {
        return this.singleProfit;
    }
    
    public void setSingleProfit(Double singleProfit) {
        this.singleProfit = singleProfit;
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
      buffer.append("parentId").append("='").append(getParentId()).append("' ");			
      buffer.append("name").append("='").append(getName()).append("' ");			
      buffer.append("busiTypeId").append("='").append(getBusiTypeId()).append("' ");			
      buffer.append("singleProfit").append("='").append(getSingleProfit()).append("' ");			
      buffer.append("createUserId").append("='").append(getCreateUserId()).append("' ");			
      buffer.append("updateUserId").append("='").append(getUpdateUserId()).append("' ");			
      buffer.append("status").append("='").append(getStatus()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }



}


