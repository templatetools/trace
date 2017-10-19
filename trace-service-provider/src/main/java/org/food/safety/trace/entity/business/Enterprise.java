package org.food.safety.trace.entity.business;
// Generated 2017-10-19 10:03:42 by Hibernate Tools 5.2.5.Final


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
 * 医院信息
 */
@Entity
@Table(name="t_enterprise"
)
public class Enterprise extends org.food.safety.trace.dto.BusinessView implements java.io.Serializable {


     /**
      * id
     */
     private String id;
     /**
      * 组织
     */
     private String organization;
     /**
      * 名称
     */
     private String name;
     /**
      * 简称
     */
     private String shortName;
     /**
      * 编号
     */
     private String code;
     /**
      * 负责人
     */
     private String responseMan;
     /**
      * 地址
     */
     private String address;
     /**
      * 电话
     */
     private String telPhone;
     /**
      * 备注
     */
     private String remark;
     /**
      * 传真
     */
     private String fax;
     /**
      * 邮箱号
     */
     private String emailNo;
     /**
      * 邮件
     */
     private String email;
     /**
      * 邮编
     */
     private String areaCode;
     /**
      * 组织编码
     */
     private String serialNumber;
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

    public Enterprise() {
    }

    public Enterprise(String organization, String name, String shortName, String code, String responseMan, String address, String telPhone, String remark, String fax, String emailNo, String email, String areaCode, String serialNumber, Date createDate, String createUserId, Date updateDate, String updateUserId, String status) {
       this.organization = organization;
       this.name = name;
       this.shortName = shortName;
       this.code = code;
       this.responseMan = responseMan;
       this.address = address;
       this.telPhone = telPhone;
       this.remark = remark;
       this.fax = fax;
       this.emailNo = emailNo;
       this.email = email;
       this.areaCode = areaCode;
       this.serialNumber = serialNumber;
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
     *      * 名称
     */

    
    @Column(name="full_name", length=32)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    /**       
     *      * 简称
     */

    
    @Column(name="short_name", length=32)
    public String getShortName() {
        return this.shortName;
    }
    
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    /**       
     *      * 编号
     */

    
    @Column(name="ent_no", insertable=false, updatable=false, length=128)
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    /**       
     *      * 负责人
     */

    
    @Column(name="response_man", length=32)
    public String getResponseMan() {
        return this.responseMan;
    }
    
    public void setResponseMan(String responseMan) {
        this.responseMan = responseMan;
    }
    /**       
     *      * 地址
     */

    
    @Column(name="address", length=32)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    /**       
     *      * 电话
     */

    
    @Column(name="tel_phone", length=32)
    public String getTelPhone() {
        return this.telPhone;
    }
    
    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
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
     *      * 传真
     */

    
    @Column(name="fax", insertable=false, updatable=false, length=32)
    public String getFax() {
        return this.fax;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }
    /**       
     *      * 邮箱号
     */

    
    @Column(name="email_no", insertable=false, updatable=false, length=32)
    public String getEmailNo() {
        return this.emailNo;
    }
    
    public void setEmailNo(String emailNo) {
        this.emailNo = emailNo;
    }
    /**       
     *      * 邮件
     */

    
    @Column(name="e_mail", insertable=false, updatable=false, length=32)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    /**       
     *      * 邮编
     */

    
    @Column(name="area_code", insertable=false, updatable=false, length=32)
    public String getAreaCode() {
        return this.areaCode;
    }
    
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
    /**       
     *      * 组织编码
     */

    
    @Column(name="serial_number", insertable=false, updatable=false, length=32)
    public String getSerialNumber() {
        return this.serialNumber;
    }
    
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
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
      buffer.append("name").append("='").append(getName()).append("' ");			
      buffer.append("shortName").append("='").append(getShortName()).append("' ");			
      buffer.append("code").append("='").append(getCode()).append("' ");			
      buffer.append("responseMan").append("='").append(getResponseMan()).append("' ");			
      buffer.append("address").append("='").append(getAddress()).append("' ");			
      buffer.append("telPhone").append("='").append(getTelPhone()).append("' ");			
      buffer.append("remark").append("='").append(getRemark()).append("' ");			
      buffer.append("fax").append("='").append(getFax()).append("' ");			
      buffer.append("emailNo").append("='").append(getEmailNo()).append("' ");			
      buffer.append("email").append("='").append(getEmail()).append("' ");			
      buffer.append("areaCode").append("='").append(getAreaCode()).append("' ");			
      buffer.append("serialNumber").append("='").append(getSerialNumber()).append("' ");			
      buffer.append("createUserId").append("='").append(getCreateUserId()).append("' ");			
      buffer.append("updateUserId").append("='").append(getUpdateUserId()).append("' ");			
      buffer.append("status").append("='").append(getStatus()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }



}


