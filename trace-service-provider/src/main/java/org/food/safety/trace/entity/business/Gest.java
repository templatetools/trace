package org.food.safety.trace.entity.business;
// Generated 2017-11-2 15:23:30 by Hibernate Tools 5.2.5.Final


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
 * 商品服务
 */
@Entity
@Table(name="t_gest"
)
public class Gest extends org.food.safety.trace.dto.GestView implements java.io.Serializable {


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
      * 会员姓名
     */
     private String name;
     /**
      * 性别
     */
     private String gestSex;
     /**
      * 生日
     */
     private Date gestBirthday;
     /**
      * 会员电话
     */
     private String mobilePhone;
     /**
      * 固定电话
     */
     private String telPhone;
     /**
      * 联系邮箱
     */
     private String email;
     /**
      * 会员等级
     */
     private String gestStyle;
     /**
      * 会员卡号
     */
     private String vipNo;
     /**
      * 联系地址
     */
     private String address;
     /**
      * 会员状态
     */
     private String status;
     /**
      * 账户金额
     */
     private Double vipAccount;
     /**
      * 预付金
     */
     private Double prepayMoney;
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
      * 积分
     */
     private String rewardPoint;
     /**
      * 停用日期
     */
     private Date loseRightDate;
     /**
      * 会员类型
     */
     private String isVip;
     /**
      * 支付状态
     */
     private String paidStatus;
     /**
      * 最后消费日期
     */
     private Date lastPaidTime;

    public Gest() {
    }

    public Gest(String organization, String code, String name, String gestSex, Date gestBirthday, String mobilePhone, String telPhone, String email, String gestStyle, String vipNo, String address, String status, Double vipAccount, Double prepayMoney, String remark, Date createDate, String createUserId, Date updateDate, String updateUserId, String rewardPoint, Date loseRightDate, String isVip, String paidStatus, Date lastPaidTime) {
       this.organization = organization;
       this.code = code;
       this.name = name;
       this.gestSex = gestSex;
       this.gestBirthday = gestBirthday;
       this.mobilePhone = mobilePhone;
       this.telPhone = telPhone;
       this.email = email;
       this.gestStyle = gestStyle;
       this.vipNo = vipNo;
       this.address = address;
       this.status = status;
       this.vipAccount = vipAccount;
       this.prepayMoney = prepayMoney;
       this.remark = remark;
       this.createDate = createDate;
       this.createUserId = createUserId;
       this.updateDate = updateDate;
       this.updateUserId = updateUserId;
       this.rewardPoint = rewardPoint;
       this.loseRightDate = loseRightDate;
       this.isVip = isVip;
       this.paidStatus = paidStatus;
       this.lastPaidTime = lastPaidTime;
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

    
    @Column(name="gest_code", insertable=false, updatable=false, length=32)
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    /**       
     *      * 会员姓名
     */

    
    @Column(name="gest_name", length=96)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    /**       
     *      * 性别
     */

    
    @Column(name="gest_sex", length=32)
    public String getGestSex() {
        return this.gestSex;
    }
    
    public void setGestSex(String gestSex) {
        this.gestSex = gestSex;
    }
    /**       
     *      * 生日
     */

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="gest_birthday", insertable=false, updatable=false)
    public Date getGestBirthday() {
        return this.gestBirthday;
    }
    
    public void setGestBirthday(Date gestBirthday) {
        this.gestBirthday = gestBirthday;
    }
    /**       
     *      * 会员电话
     */

    
    @Column(name="mobile_phone", length=48)
    public String getMobilePhone() {
        return this.mobilePhone;
    }
    
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    /**       
     *      * 固定电话
     */

    
    @Column(name="tel_phone", length=48)
    public String getTelPhone() {
        return this.telPhone;
    }
    
    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }
    /**       
     *      * 联系邮箱
     */

    
    @Column(name="email", length=48)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    /**       
     *      * 会员等级
     */

    
    @Column(name="gest_style", length=48)
    public String getGestStyle() {
        return this.gestStyle;
    }
    
    public void setGestStyle(String gestStyle) {
        this.gestStyle = gestStyle;
    }
    /**       
     *      * 会员卡号
     */

    
    @Column(name="vip_no", length=48)
    public String getVipNo() {
        return this.vipNo;
    }
    
    public void setVipNo(String vipNo) {
        this.vipNo = vipNo;
    }
    /**       
     *      * 联系地址
     */

    
    @Column(name="gest_address", length=96)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    /**       
     *      * 会员状态
     */

    
    @Column(name="status", length=128)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    /**       
     *      * 账户金额
     */

    
    @Column(name="vip_account")
    public Double getVipAccount() {
        return this.vipAccount;
    }
    
    public void setVipAccount(Double vipAccount) {
        this.vipAccount = vipAccount;
    }
    /**       
     *      * 预付金
     */

    
    @Column(name="prepay_money", insertable=false, updatable=false)
    public Double getPrepayMoney() {
        return this.prepayMoney;
    }
    
    public void setPrepayMoney(Double prepayMoney) {
        this.prepayMoney = prepayMoney;
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

    
    @Column(name="update_user_id", insertable=false, updatable=false, length=128)
    public String getUpdateUserId() {
        return this.updateUserId;
    }
    
    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }
    /**       
     *      * 积分
     */

    
    @Column(name="reward_point", insertable=false, updatable=false, length=48)
    public String getRewardPoint() {
        return this.rewardPoint;
    }
    
    public void setRewardPoint(String rewardPoint) {
        this.rewardPoint = rewardPoint;
    }
    /**       
     *      * 停用日期
     */

    
    @Column(name="lose_right_date", insertable=false, updatable=false)
    public Date getLoseRightDate() {
        return this.loseRightDate;
    }
    
    public void setLoseRightDate(Date loseRightDate) {
        this.loseRightDate = loseRightDate;
    }
    /**       
     *      * 会员类型
     */

    
    @Column(name="is_vip", insertable=false, updatable=false, length=48)
    public String getIsVip() {
        return this.isVip;
    }
    
    public void setIsVip(String isVip) {
        this.isVip = isVip;
    }
    /**       
     *      * 支付状态
     */

    
    @Column(name="paid_status", insertable=false, updatable=false, length=48)
    public String getPaidStatus() {
        return this.paidStatus;
    }
    
    public void setPaidStatus(String paidStatus) {
        this.paidStatus = paidStatus;
    }
    /**       
     *      * 最后消费日期
     */

    
    @Column(name="last_paid_time", insertable=false, updatable=false)
    public Date getLastPaidTime() {
        return this.lastPaidTime;
    }
    
    public void setLastPaidTime(Date lastPaidTime) {
        this.lastPaidTime = lastPaidTime;
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
      buffer.append("gestSex").append("='").append(getGestSex()).append("' ");			
      buffer.append("gestBirthday").append("='").append(getGestBirthday()).append("' ");			
      buffer.append("mobilePhone").append("='").append(getMobilePhone()).append("' ");			
      buffer.append("telPhone").append("='").append(getTelPhone()).append("' ");			
      buffer.append("email").append("='").append(getEmail()).append("' ");			
      buffer.append("gestStyle").append("='").append(getGestStyle()).append("' ");			
      buffer.append("vipNo").append("='").append(getVipNo()).append("' ");			
      buffer.append("address").append("='").append(getAddress()).append("' ");			
      buffer.append("status").append("='").append(getStatus()).append("' ");			
      buffer.append("vipAccount").append("='").append(getVipAccount()).append("' ");			
      buffer.append("prepayMoney").append("='").append(getPrepayMoney()).append("' ");			
      buffer.append("remark").append("='").append(getRemark()).append("' ");			
      buffer.append("createUserId").append("='").append(getCreateUserId()).append("' ");			
      buffer.append("updateUserId").append("='").append(getUpdateUserId()).append("' ");			
      buffer.append("rewardPoint").append("='").append(getRewardPoint()).append("' ");			
      buffer.append("loseRightDate").append("='").append(getLoseRightDate()).append("' ");			
      buffer.append("isVip").append("='").append(getIsVip()).append("' ");			
      buffer.append("paidStatus").append("='").append(getPaidStatus()).append("' ");			
      buffer.append("lastPaidTime").append("='").append(getLastPaidTime()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }



}


