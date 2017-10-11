package org.food.safety.trace.entity;
// Generated 2017-10-11 10:35:01 by Hibernate Tools 5.2.5.Final


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
 * 菜单信息
 */
@Entity
@Table(name="Menu"
)
public class Menu extends org.food.safety.trace.dto.MenuView implements java.io.Serializable {


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
      * 图标
     */
     private String icon;
     /**
      * 路由
     */
     private String route;
     /**
      * 父级菜单
     */
     private String mpid;
     /**
      * 创建时间
     */
     private Date createTime;

    public Menu() {
    }

    public Menu(String organization, String name, String icon, String route, String mpid, Date createTime) {
       this.organization = organization;
       this.name = name;
       this.icon = icon;
       this.route = route;
       this.mpid = mpid;
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
     *      * 图标
     */

    
    @Column(name="icon", length=32)
    public String getIcon() {
        return this.icon;
    }
    
    public void setIcon(String icon) {
        this.icon = icon;
    }
    /**       
     *      * 路由
     */

    
    @Column(name="route", length=64)
    public String getRoute() {
        return this.route;
    }
    
    public void setRoute(String route) {
        this.route = route;
    }
    /**       
     *      * 父级菜单
     */

    
    @Column(name="mpid", length=128)
    public String getMpid() {
        return this.mpid;
    }
    
    public void setMpid(String mpid) {
        this.mpid = mpid;
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
      buffer.append("icon").append("='").append(getIcon()).append("' ");			
      buffer.append("route").append("='").append(getRoute()).append("' ");			
      buffer.append("mpid").append("='").append(getMpid()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }



}


