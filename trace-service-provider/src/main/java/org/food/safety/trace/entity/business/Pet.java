package org.food.safety.trace.entity.business;
// Generated 2017-11-3 9:46:45 by Hibernate Tools 5.2.5.Final


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
@Table(name="t_pet"
)
public class Pet extends org.food.safety.trace.dto.PetView implements java.io.Serializable {


     /**
      * id
     */
     private String id;
     /**
      * 组织
     */
     private String organization;
     /**
      * 会员信息
     */
     private String gestId;
     /**
      * 编号
     */
     private String code;
     /**
      * 宠物昵称
     */
     private String name;
     /**
      * 性别
     */
     private String petSex;
     /**
      * 出生日期
     */
     private Date petBirthday;
     /**
      * 宠物年龄
     */
     private Float age;
     /**
      * 绝育状态
     */
     private String birthStatus;
     /**
      * 宠物颜色
     */
     private String petSkinColor;
     /**
      * 宠物品种
     */
     private String petRace;
     /**
      * 宠物种类
     */
     private String petBreed;
     /**
      * 宠物状态
     */
     private String status;
     /**
      * 宠物病例号
     */
     private String sickFileCode;
     /**
      * 体重
     */
     private Float petWeight;
     /**
      * 宠物牌号
     */
     private String dogBandId;
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
      * 身高
     */
     private Integer petHeight;
     /**
      * 肩宽
     */
     private Integer petSwidth;
     /**
      * 体长
     */
     private Integer petBodyLong;
     /**
      * 宠物头
     */
     private String petHead;
     /**
      * 宠物头id
     */
     private String petHeadId;
     /**
      * 医疗类型
     */
     private String mdicTypeName;
     /**
      * 会员编号
     */
     private String gestCode;
     /**
      * 会员名称
     */
     private String gestName;

    public Pet() {
    }

    public Pet(String organization, String gestId, String code, String name, String petSex, Date petBirthday, Float age, String birthStatus, String petSkinColor, String petRace, String petBreed, String status, String sickFileCode, Float petWeight, String dogBandId, String remark, Date createDate, String createUserId, Date updateDate, String updateUserId, Integer petHeight, Integer petSwidth, Integer petBodyLong, String petHead, String petHeadId, String mdicTypeName, String gestCode, String gestName) {
       this.organization = organization;
       this.gestId = gestId;
       this.code = code;
       this.name = name;
       this.petSex = petSex;
       this.petBirthday = petBirthday;
       this.age = age;
       this.birthStatus = birthStatus;
       this.petSkinColor = petSkinColor;
       this.petRace = petRace;
       this.petBreed = petBreed;
       this.status = status;
       this.sickFileCode = sickFileCode;
       this.petWeight = petWeight;
       this.dogBandId = dogBandId;
       this.remark = remark;
       this.createDate = createDate;
       this.createUserId = createUserId;
       this.updateDate = updateDate;
       this.updateUserId = updateUserId;
       this.petHeight = petHeight;
       this.petSwidth = petSwidth;
       this.petBodyLong = petBodyLong;
       this.petHead = petHead;
       this.petHeadId = petHeadId;
       this.mdicTypeName = mdicTypeName;
       this.gestCode = gestCode;
       this.gestName = gestName;
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
     *      * 会员信息
     */

    
    @Column(name="gest_id", length=128)
    public String getGestId() {
        return this.gestId;
    }
    
    public void setGestId(String gestId) {
        this.gestId = gestId;
    }
    /**       
     *      * 编号
     */

    
    @Column(name="pet_code", insertable=false, updatable=false, length=32)
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    /**       
     *      * 宠物昵称
     */

    
    @Column(name="pet_name", length=96)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    /**       
     *      * 性别
     */

    
    @Column(name="pet_sex", length=32)
    public String getPetSex() {
        return this.petSex;
    }
    
    public void setPetSex(String petSex) {
        this.petSex = petSex;
    }
    /**       
     *      * 出生日期
     */

    
    @Column(name="pet_birthday")
    public Date getPetBirthday() {
        return this.petBirthday;
    }
    
    public void setPetBirthday(Date petBirthday) {
        this.petBirthday = petBirthday;
    }
    /**       
     *      * 宠物年龄
     */

    
    @Column(name="age", insertable=false)
    public Float getAge() {
        return this.age;
    }
    
    public void setAge(Float age) {
        this.age = age;
    }
    /**       
     *      * 绝育状态
     */

    
    @Column(name="birth_status", length=32)
    public String getBirthStatus() {
        return this.birthStatus;
    }
    
    public void setBirthStatus(String birthStatus) {
        this.birthStatus = birthStatus;
    }
    /**       
     *      * 宠物颜色
     */

    
    @Column(name="pet_skin_color", length=32)
    public String getPetSkinColor() {
        return this.petSkinColor;
    }
    
    public void setPetSkinColor(String petSkinColor) {
        this.petSkinColor = petSkinColor;
    }
    /**       
     *      * 宠物品种
     */

    
    @Column(name="pet_race", length=48)
    public String getPetRace() {
        return this.petRace;
    }
    
    public void setPetRace(String petRace) {
        this.petRace = petRace;
    }
    /**       
     *      * 宠物种类
     */

    
    @Column(name="pet_breed", length=48)
    public String getPetBreed() {
        return this.petBreed;
    }
    
    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }
    /**       
     *      * 宠物状态
     */

    
    @Column(name="status", length=32)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    /**       
     *      * 宠物病例号
     */

    
    @Column(name="sick_file_code", updatable=false, length=48)
    public String getSickFileCode() {
        return this.sickFileCode;
    }
    
    public void setSickFileCode(String sickFileCode) {
        this.sickFileCode = sickFileCode;
    }
    /**       
     *      * 体重
     */

    
    @Column(name="pet_weight")
    public Float getPetWeight() {
        return this.petWeight;
    }
    
    public void setPetWeight(Float petWeight) {
        this.petWeight = petWeight;
    }
    /**       
     *      * 宠物牌号
     */

    
    @Column(name="dog_band_id", length=36)
    public String getDogBandId() {
        return this.dogBandId;
    }
    
    public void setDogBandId(String dogBandId) {
        this.dogBandId = dogBandId;
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
     *      * 身高
     */

    
    @Column(name="pet_height", insertable=false, updatable=false, length=11)
    public Integer getPetHeight() {
        return this.petHeight;
    }
    
    public void setPetHeight(Integer petHeight) {
        this.petHeight = petHeight;
    }
    /**       
     *      * 肩宽
     */

    
    @Column(name="pet_swidth", insertable=false, updatable=false, length=11)
    public Integer getPetSwidth() {
        return this.petSwidth;
    }
    
    public void setPetSwidth(Integer petSwidth) {
        this.petSwidth = petSwidth;
    }
    /**       
     *      * 体长
     */

    
    @Column(name="pet_body_long", insertable=false, updatable=false, length=11)
    public Integer getPetBodyLong() {
        return this.petBodyLong;
    }
    
    public void setPetBodyLong(Integer petBodyLong) {
        this.petBodyLong = petBodyLong;
    }
    /**       
     *      * 宠物头
     */

    
    @Column(name="pet_head", insertable=false, updatable=false, length=32)
    public String getPetHead() {
        return this.petHead;
    }
    
    public void setPetHead(String petHead) {
        this.petHead = petHead;
    }
    /**       
     *      * 宠物头id
     */

    
    @Column(name="pet_head_id", insertable=false, updatable=false, length=32)
    public String getPetHeadId() {
        return this.petHeadId;
    }
    
    public void setPetHeadId(String petHeadId) {
        this.petHeadId = petHeadId;
    }
    /**       
     *      * 医疗类型
     */

    
    @Column(name="mdic_type_name", insertable=false, updatable=false, length=48)
    public String getMdicTypeName() {
        return this.mdicTypeName;
    }
    
    public void setMdicTypeName(String mdicTypeName) {
        this.mdicTypeName = mdicTypeName;
    }
    /**       
     *      * 会员编号
     */

    
    @Column(name="gest_code", insertable=false, updatable=false, length=48)
    public String getGestCode() {
        return this.gestCode;
    }
    
    public void setGestCode(String gestCode) {
        this.gestCode = gestCode;
    }
    /**       
     *      * 会员名称
     */

    
    @Column(name="gest_name", insertable=false, updatable=false, length=48)
    public String getGestName() {
        return this.gestName;
    }
    
    public void setGestName(String gestName) {
        this.gestName = gestName;
    }

    /**
     * toString
     * @return String
     */
     public String toString() {
	  StringBuffer buffer = new StringBuffer();

      buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
      buffer.append("organization").append("='").append(getOrganization()).append("' ");			
      buffer.append("gestId").append("='").append(getGestId()).append("' ");			
      buffer.append("code").append("='").append(getCode()).append("' ");			
      buffer.append("name").append("='").append(getName()).append("' ");			
      buffer.append("petSex").append("='").append(getPetSex()).append("' ");			
      buffer.append("petBirthday").append("='").append(getPetBirthday()).append("' ");			
      buffer.append("age").append("='").append(getAge()).append("' ");			
      buffer.append("birthStatus").append("='").append(getBirthStatus()).append("' ");			
      buffer.append("petSkinColor").append("='").append(getPetSkinColor()).append("' ");			
      buffer.append("petRace").append("='").append(getPetRace()).append("' ");			
      buffer.append("petBreed").append("='").append(getPetBreed()).append("' ");			
      buffer.append("status").append("='").append(getStatus()).append("' ");			
      buffer.append("sickFileCode").append("='").append(getSickFileCode()).append("' ");			
      buffer.append("petWeight").append("='").append(getPetWeight()).append("' ");			
      buffer.append("dogBandId").append("='").append(getDogBandId()).append("' ");			
      buffer.append("remark").append("='").append(getRemark()).append("' ");			
      buffer.append("createUserId").append("='").append(getCreateUserId()).append("' ");			
      buffer.append("updateUserId").append("='").append(getUpdateUserId()).append("' ");			
      buffer.append("petHeight").append("='").append(getPetHeight()).append("' ");			
      buffer.append("petSwidth").append("='").append(getPetSwidth()).append("' ");			
      buffer.append("petBodyLong").append("='").append(getPetBodyLong()).append("' ");			
      buffer.append("petHead").append("='").append(getPetHead()).append("' ");			
      buffer.append("petHeadId").append("='").append(getPetHeadId()).append("' ");			
      buffer.append("mdicTypeName").append("='").append(getMdicTypeName()).append("' ");			
      buffer.append("gestCode").append("='").append(getGestCode()).append("' ");			
      buffer.append("gestName").append("='").append(getGestName()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }



}


