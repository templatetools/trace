package org.food.safety.trace.entity;
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
 * 用户信息
 */
@Entity
@Table(name="UserEntity"
)
public class UserEntity extends org.food.safety.trace.dto.UserEntityView implements java.io.Serializable {


     /**
      * id
     */
     private String id;
     /**
      * 组织
     */
     private String organization;
     /**
      * 角色
     */
     private String roles;
     /**
      * 用户名
     */
     private String name;
     /**
      * 密码
     */
     private String password;
     /**
      * 昵称
     */
     private String nickName;
     /**
      * 年龄
     */
     private int age;
     /**
      * 性别
     */
     private boolean isMale;
     /**
      * 电话
     */
     private String phone;
     /**
      * 电子邮件
     */
     private String email;
     /**
      * 联系地址
     */
     private String address;
     /**
      * 创建时间
     */
     private Date createTime;

    public UserEntity() {
    }

    public UserEntity(String organization, String roles, String name, String password, String nickName, int age, boolean isMale, String phone, String email, String address, Date createTime) {
       this.organization = organization;
       this.roles = roles;
       this.name = name;
       this.password = password;
       this.nickName = nickName;
       this.age = age;
       this.isMale = isMale;
       this.phone = phone;
       this.email = email;
       this.address = address;
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
     *      * 角色
     */

    
    @Column(name="roles", length=512)
    public String getRoles() {
        return this.roles;
    }
    
    public void setRoles(String roles) {
        this.roles = roles;
    }
    /**       
     *      * 用户名
     */

    
    @Column(name="name", length=8)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    /**       
     *      * 密码
     */

    
    @Column(name="password", length=8)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    /**       
     *      * 昵称
     */

    
    @Column(name="nickName", length=16)
    public String getNickName() {
        return this.nickName;
    }
    
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    /**       
     *      * 年龄
     */

    
    @Column(name="age")
    public int getAge() {
        return this.age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    /**       
     *      * 性别
     */

    
    @Column(name="isMale")
    public boolean isIsMale() {
        return this.isMale;
    }
    
    public void setIsMale(boolean isMale) {
        this.isMale = isMale;
    }
    /**       
     *      * 电话
     */

    
    @Column(name="phone", length=11)
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**       
     *      * 电子邮件
     */

    
    @Column(name="email", length=16)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    /**       
     *      * 联系地址
     */

    
    @Column(name="address", length=128)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
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
      buffer.append("roles").append("='").append(getRoles()).append("' ");			
      buffer.append("name").append("='").append(getName()).append("' ");			
      buffer.append("password").append("='").append(getPassword()).append("' ");			
      buffer.append("nickName").append("='").append(getNickName()).append("' ");			
      buffer.append("age").append("='").append(getAge()).append("' ");			
      buffer.append("isMale").append("='").append(isIsMale()).append("' ");			
      buffer.append("phone").append("='").append(getPhone()).append("' ");			
      buffer.append("email").append("='").append(getEmail()).append("' ");			
      buffer.append("address").append("='").append(getAddress()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }



}


