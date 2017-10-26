package org.food.safety.trace.entity.business;
// Generated 2017-10-26 18:42:43 by Hibernate Tools 5.2.5.Final


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
 * 系统字典
 */
@Entity
@Table(name="t_dict_type_detail"
)
public class DictTypeDetail extends org.food.safety.trace.dto.DictTypeDetailView implements java.io.Serializable {


     /**
      * id
     */
     private String id;
     /**
      * 组织
     */
     private String organization;
     /**
      * 字典类别
     */
     private String dictTypeId;
     /**
      * 编号
     */
     private String code;
     /**
      * 名称
     */
     private String name;
     /**
      * 名称(英文)
     */
     private String nameEn;
     /**
      * 备注
     */
     private String comments;
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

    public DictTypeDetail() {
    }

	
    public DictTypeDetail(String code) {
        this.code = code;
    }
    public DictTypeDetail(String organization, String dictTypeId, String code, String name, String nameEn, String comments, Date createDate, String createUserId, Date updateDate, String updateUserId, String status) {
       this.organization = organization;
       this.dictTypeId = dictTypeId;
       this.code = code;
       this.name = name;
       this.nameEn = nameEn;
       this.comments = comments;
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
     *      * 字典类别
     */

    
    @Column(name="dict_type_id", length=128)
    public String getDictTypeId() {
        return this.dictTypeId;
    }
    
    public void setDictTypeId(String dictTypeId) {
        this.dictTypeId = dictTypeId;
    }
    /**       
     *      * 编号
     */

    
    @Column(name="dict_detail_code", nullable=false, updatable=false, length=128)
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    /**       
     *      * 名称
     */

    
    @Column(name="value_name_cn", length=32)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    /**       
     *      * 名称(英文)
     */

    
    @Column(name="value_name_en", length=32)
    public String getNameEn() {
        return this.nameEn;
    }
    
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }
    /**       
     *      * 备注
     */

    
    @Column(name="comments", length=32)
    public String getComments() {
        return this.comments;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
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
      buffer.append("dictTypeId").append("='").append(getDictTypeId()).append("' ");			
      buffer.append("code").append("='").append(getCode()).append("' ");			
      buffer.append("name").append("='").append(getName()).append("' ");			
      buffer.append("nameEn").append("='").append(getNameEn()).append("' ");			
      buffer.append("comments").append("='").append(getComments()).append("' ");			
      buffer.append("createUserId").append("='").append(getCreateUserId()).append("' ");			
      buffer.append("updateUserId").append("='").append(getUpdateUserId()).append("' ");			
      buffer.append("status").append("='").append(getStatus()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }



}


