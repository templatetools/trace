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
 * 应用配置
 */
@Entity
@Table(name="t_app_config"
)
public class AppConfig extends org.food.safety.trace.dto.BusinessView implements java.io.Serializable {


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
      * 值
     */
     private String configValue;
     /**
      * 描述
     */
     private String description;
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

    public AppConfig() {
    }

    public AppConfig(String organization, String name, String configValue, String description, Date createDate, String createUserId, Date updateDate, String updateUserId, String status) {
       this.organization = organization;
       this.name = name;
       this.configValue = configValue;
       this.description = description;
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

    
    @Column(name="config_name", length=256)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    /**       
     *      * 值
     */

    
    @Column(name="config_value", length=512)
    public String getConfigValue() {
        return this.configValue;
    }
    
    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }
    /**       
     *      * 描述
     */

    
    @Column(name="description", length=512)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
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
      buffer.append("name").append("='").append(getName()).append("' ");			
      buffer.append("configValue").append("='").append(getConfigValue()).append("' ");			
      buffer.append("description").append("='").append(getDescription()).append("' ");			
      buffer.append("createUserId").append("='").append(getCreateUserId()).append("' ");			
      buffer.append("updateUserId").append("='").append(getUpdateUserId()).append("' ");			
      buffer.append("status").append("='").append(getStatus()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }



}


