package org.food.safety.trace.entity;
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
 * 角色信息
 */
@Entity
@Table(name="Role"
)
public class Role extends org.food.safety.trace.dto.RoleView implements java.io.Serializable {


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
      * 菜单
     */
     private String menus;
     /**
      * 创建时间
     */
     private Date createTime;

    public Role() {
    }

    public Role(String organization, String name, String menus, Date createTime) {
       this.organization = organization;
       this.name = name;
       this.menus = menus;
       this.createTime = createTime;
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

    
    @Column(name="name", length=16)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    /**       
     *      * 菜单
     */

    
    @Column(name="menus", length=512)
    public String getMenus() {
        return this.menus;
    }
    
    public void setMenus(String menus) {
        this.menus = menus;
    }
    /**       
     *      * 创建时间
     */

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="createTime", nullable=false, insertable=false, updatable=false)
    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
      buffer.append("menus").append("='").append(getMenus()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }



}


