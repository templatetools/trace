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
 * 挂号服务
 */
@Entity
@Table(name="t_medic_register_record"
)
public class MedicRegisterRecord extends org.food.safety.trace.dto.MedicRegisterRecordView implements java.io.Serializable {


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
      * 会员名称
     */
     private String gestName;
     /**
      * 病例号
     */
     private String sickFileCode;
     /**
      * 宠物
     */
     private String petId;
     /**
      * 宠物名称
     */
     private String petName;
     /**
      * 挂号类型
     */
     private String itemCode;
     /**
      * 挂号费
     */
     private Double registerPrice;
     /**
      * 挂号名称
     */
     private String itemName;
     /**
      * 医生
     */
     private String doctorId;
     /**
      * 医生名称
     */
     private String doctor;
     /**
      * 助理
     */
     private String assistantDoctorId;
     /**
      * 助理名称
     */
     private String assistantDoctorName;
     /**
      * 登记人
     */
     private String operatorMan;
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
      * 挂号类型
     */
     private String registerStyle;
     /**
      * 支付时间
     */
     private Date paidTime;
     /**
      * 宠物状态
     */
     private String paidStatus;
     /**
      * 暂停原因
     */
     private String pauseSeason;
     /**
      * 状态
     */
     private String status;

    public MedicRegisterRecord() {
    }

	
    public MedicRegisterRecord(String code) {
        this.code = code;
    }
    public MedicRegisterRecord(String organization, String code, String gestName, String sickFileCode, String petId, String petName, String itemCode, Double registerPrice, String itemName, String doctorId, String doctor, String assistantDoctorId, String assistantDoctorName, String operatorMan, Date createDate, String createUserId, Date updateDate, String updateUserId, String registerStyle, Date paidTime, String paidStatus, String pauseSeason, String status) {
       this.organization = organization;
       this.code = code;
       this.gestName = gestName;
       this.sickFileCode = sickFileCode;
       this.petId = petId;
       this.petName = petName;
       this.itemCode = itemCode;
       this.registerPrice = registerPrice;
       this.itemName = itemName;
       this.doctorId = doctorId;
       this.doctor = doctor;
       this.assistantDoctorId = assistantDoctorId;
       this.assistantDoctorName = assistantDoctorName;
       this.operatorMan = operatorMan;
       this.createDate = createDate;
       this.createUserId = createUserId;
       this.updateDate = updateDate;
       this.updateUserId = updateUserId;
       this.registerStyle = registerStyle;
       this.paidTime = paidTime;
       this.paidStatus = paidStatus;
       this.pauseSeason = pauseSeason;
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

    
    @Column(name="register_no", nullable=false, updatable=false, length=48)
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    /**       
     *      * 会员名称
     */

    
    @Column(name="gest_name", length=48)
    public String getGestName() {
        return this.gestName;
    }
    
    public void setGestName(String gestName) {
        this.gestName = gestName;
    }
    /**       
     *      * 病例号
     */

    
    @Column(name="sick_file_code", length=48)
    public String getSickFileCode() {
        return this.sickFileCode;
    }
    
    public void setSickFileCode(String sickFileCode) {
        this.sickFileCode = sickFileCode;
    }
    /**       
     *      * 宠物
     */

    
    @Column(name="pet_id", length=36)
    public String getPetId() {
        return this.petId;
    }
    
    public void setPetId(String petId) {
        this.petId = petId;
    }
    /**       
     *      * 宠物名称
     */

    
    @Column(name="pet_name", length=48)
    public String getPetName() {
        return this.petName;
    }
    
    public void setPetName(String petName) {
        this.petName = petName;
    }
    /**       
     *      * 挂号类型
     */

    
    @Column(name="item_code", length=48)
    public String getItemCode() {
        return this.itemCode;
    }
    
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
    /**       
     *      * 挂号费
     */

    
    @Column(name="register_price")
    public Double getRegisterPrice() {
        return this.registerPrice;
    }
    
    public void setRegisterPrice(Double registerPrice) {
        this.registerPrice = registerPrice;
    }
    /**       
     *      * 挂号名称
     */

    
    @Column(name="item_name", length=96)
    public String getItemName() {
        return this.itemName;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    /**       
     *      * 医生
     */

    
    @Column(name="doctor_id", length=36)
    public String getDoctorId() {
        return this.doctorId;
    }
    
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
    /**       
     *      * 医生名称
     */

    
    @Column(name="doctor", length=48)
    public String getDoctor() {
        return this.doctor;
    }
    
    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
    /**       
     *      * 助理
     */

    
    @Column(name="assistant_doctor_id", length=36)
    public String getAssistantDoctorId() {
        return this.assistantDoctorId;
    }
    
    public void setAssistantDoctorId(String assistantDoctorId) {
        this.assistantDoctorId = assistantDoctorId;
    }
    /**       
     *      * 助理名称
     */

    
    @Column(name="assistant_doctor_name", length=48)
    public String getAssistantDoctorName() {
        return this.assistantDoctorName;
    }
    
    public void setAssistantDoctorName(String assistantDoctorName) {
        this.assistantDoctorName = assistantDoctorName;
    }
    /**       
     *      * 登记人
     */

    
    @Column(name="operator_man", insertable=false, updatable=false, length=48)
    public String getOperatorMan() {
        return this.operatorMan;
    }
    
    public void setOperatorMan(String operatorMan) {
        this.operatorMan = operatorMan;
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
     *      * 挂号类型
     */

    
    @Column(name="register_style", insertable=false, updatable=false, length=48)
    public String getRegisterStyle() {
        return this.registerStyle;
    }
    
    public void setRegisterStyle(String registerStyle) {
        this.registerStyle = registerStyle;
    }
    /**       
     *      * 支付时间
     */

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="paid_time", insertable=false)
    public Date getPaidTime() {
        return this.paidTime;
    }
    
    public void setPaidTime(Date paidTime) {
        this.paidTime = paidTime;
    }
    /**       
     *      * 宠物状态
     */

    
    @Column(name="paid_status", insertable=false, length=32)
    public String getPaidStatus() {
        return this.paidStatus;
    }
    
    public void setPaidStatus(String paidStatus) {
        this.paidStatus = paidStatus;
    }
    /**       
     *      * 暂停原因
     */

    
    @Column(name="pause_reason", insertable=false, length=48)
    public String getPauseSeason() {
        return this.pauseSeason;
    }
    
    public void setPauseSeason(String pauseSeason) {
        this.pauseSeason = pauseSeason;
    }
    /**       
     *      * 状态
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
      buffer.append("code").append("='").append(getCode()).append("' ");			
      buffer.append("gestName").append("='").append(getGestName()).append("' ");			
      buffer.append("sickFileCode").append("='").append(getSickFileCode()).append("' ");			
      buffer.append("petId").append("='").append(getPetId()).append("' ");			
      buffer.append("petName").append("='").append(getPetName()).append("' ");			
      buffer.append("itemCode").append("='").append(getItemCode()).append("' ");			
      buffer.append("registerPrice").append("='").append(getRegisterPrice()).append("' ");			
      buffer.append("itemName").append("='").append(getItemName()).append("' ");			
      buffer.append("doctorId").append("='").append(getDoctorId()).append("' ");			
      buffer.append("doctor").append("='").append(getDoctor()).append("' ");			
      buffer.append("assistantDoctorId").append("='").append(getAssistantDoctorId()).append("' ");			
      buffer.append("assistantDoctorName").append("='").append(getAssistantDoctorName()).append("' ");			
      buffer.append("operatorMan").append("='").append(getOperatorMan()).append("' ");			
      buffer.append("createUserId").append("='").append(getCreateUserId()).append("' ");			
      buffer.append("updateUserId").append("='").append(getUpdateUserId()).append("' ");			
      buffer.append("paidStatus").append("='").append(getPaidStatus()).append("' ");			
      buffer.append("pauseSeason").append("='").append(getPauseSeason()).append("' ");			
      buffer.append("status").append("='").append(getStatus()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }



}


