package org.food.safety.trace.entity.business;
// Generated 2017-10-17 14:05:43 by Hibernate Tools 5.2.5.Final


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
 * 经销商与生产商
 */
@Entity
@Table(name="t_dealer"
)
public class Dealer extends org.food.safety.trace.dto.DealerView implements java.io.Serializable {


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
      * 类型
     */
     private String companyType;
     /**
      * 名称
     */
     private String name;
     /**
      * 联系人
     */
     private String contractMan;
     /**
      * 手机
     */
     private String mobilePhone;
     /**
      * 电话
     */
     private String telPhone;
     /**
      * 备注
     */
     private String remark;
     /**
      * 邮件
     */
     private String email;
     /**
      * 地址
     */
     private String dealerAddress;
     /**
      * 传真
     */
     private String fax;
     /**
      * 网址
     */
     private String website;
     /**
      * 税号
     */
     private String taxNo;
     /**
      * 开户行
     */
     private String bankName;
     /**
      * 账号名称
     */
     private String dealerBankName;
     /**
      * 账号
     */
     private String accountNo;
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

    public Dealer() {
    }

    public Dealer(String organization, String code, String companyType, String name, String contractMan, String mobilePhone, String telPhone, String remark, String email, String dealerAddress, String fax, String website, String taxNo, String bankName, String dealerBankName, String accountNo, Date createDate, String createUserId, Date updateDate, String updateUserId, String status) {
       this.organization = organization;
       this.code = code;
       this.companyType = companyType;
       this.name = name;
       this.contractMan = contractMan;
       this.mobilePhone = mobilePhone;
       this.telPhone = telPhone;
       this.remark = remark;
       this.email = email;
       this.dealerAddress = dealerAddress;
       this.fax = fax;
       this.website = website;
       this.taxNo = taxNo;
       this.bankName = bankName;
       this.dealerBankName = dealerBankName;
       this.accountNo = accountNo;
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

    
    @Column(name="code", insertable=false, updatable=false, length=128)
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    /**       
     *      * 类型
     */

    
    @Column(name="company_type", length=1)
    public String getCompanyType() {
        return this.companyType;
    }
    
    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }
    /**       
     *      * 名称
     */

    
    @Column(name="name", length=128)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    /**       
     *      * 联系人
     */

    
    @Column(name="contract_man", length=8)
    public String getContractMan() {
        return this.contractMan;
    }
    
    public void setContractMan(String contractMan) {
        this.contractMan = contractMan;
    }
    /**       
     *      * 手机
     */

    
    @Column(name="mobile_phone", length=11)
    public String getMobilePhone() {
        return this.mobilePhone;
    }
    
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    /**       
     *      * 电话
     */

    
    @Column(name="tel_phone", length=64)
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
     *      * 邮件
     */

    
    @Column(name="email", insertable=false, updatable=false, length=128)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    /**       
     *      * 地址
     */

    
    @Column(name="dealer_address", insertable=false, updatable=false, length=128)
    public String getDealerAddress() {
        return this.dealerAddress;
    }
    
    public void setDealerAddress(String dealerAddress) {
        this.dealerAddress = dealerAddress;
    }
    /**       
     *      * 传真
     */

    
    @Column(name="fax", insertable=false, updatable=false, length=128)
    public String getFax() {
        return this.fax;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }
    /**       
     *      * 网址
     */

    
    @Column(name="website", insertable=false, updatable=false, length=128)
    public String getWebsite() {
        return this.website;
    }
    
    public void setWebsite(String website) {
        this.website = website;
    }
    /**       
     *      * 税号
     */

    
    @Column(name="tax_no", insertable=false, updatable=false, length=128)
    public String getTaxNo() {
        return this.taxNo;
    }
    
    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }
    /**       
     *      * 开户行
     */

    
    @Column(name="bank_name", insertable=false, updatable=false, length=128)
    public String getBankName() {
        return this.bankName;
    }
    
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    /**       
     *      * 账号名称
     */

    
    @Column(name="dealer_bank_name", insertable=false, updatable=false, length=128)
    public String getDealerBankName() {
        return this.dealerBankName;
    }
    
    public void setDealerBankName(String dealerBankName) {
        this.dealerBankName = dealerBankName;
    }
    /**       
     *      * 账号
     */

    
    @Column(name="account_no", insertable=false, updatable=false, length=128)
    public String getAccountNo() {
        return this.accountNo;
    }
    
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
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
      buffer.append("companyType").append("='").append(getCompanyType()).append("' ");			
      buffer.append("name").append("='").append(getName()).append("' ");			
      buffer.append("contractMan").append("='").append(getContractMan()).append("' ");			
      buffer.append("mobilePhone").append("='").append(getMobilePhone()).append("' ");			
      buffer.append("telPhone").append("='").append(getTelPhone()).append("' ");			
      buffer.append("remark").append("='").append(getRemark()).append("' ");			
      buffer.append("email").append("='").append(getEmail()).append("' ");			
      buffer.append("dealerAddress").append("='").append(getDealerAddress()).append("' ");			
      buffer.append("fax").append("='").append(getFax()).append("' ");			
      buffer.append("website").append("='").append(getWebsite()).append("' ");			
      buffer.append("taxNo").append("='").append(getTaxNo()).append("' ");			
      buffer.append("bankName").append("='").append(getBankName()).append("' ");			
      buffer.append("dealerBankName").append("='").append(getDealerBankName()).append("' ");			
      buffer.append("accountNo").append("='").append(getAccountNo()).append("' ");			
      buffer.append("createUserId").append("='").append(getCreateUserId()).append("' ");			
      buffer.append("updateUserId").append("='").append(getUpdateUserId()).append("' ");			
      buffer.append("status").append("='").append(getStatus()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }



}


