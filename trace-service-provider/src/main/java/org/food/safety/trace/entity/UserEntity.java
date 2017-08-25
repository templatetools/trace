package org.food.safety.trace.entity;
// Generated 2017-8-25 16:17:16 by Hibernate Tools 5.2.5.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * 用户信息
 */
@Entity
@Table(name="UserEntity"
)
public class UserEntity  implements java.io.Serializable {


     /**
      * id
     */
     private String id;
     /**
      * 用户名
     */
     private String name;
     /**
      * 登录用户名
     */
     private String loginName;
     /**
      * 登录密码
     */
     private String password;

    public UserEntity() {
    }

    public UserEntity(String name, String loginName, String password) {
       this.name = name;
       this.loginName = loginName;
       this.password = password;
    }
   
    /**       
     *      * id
     */
     @GenericGenerator(name="generator", strategy="uuid")@Id @GeneratedValue(generator="generator")

    
    @Column(name="id", nullable=false, updatable=false, length=10)
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
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
     *      * 登录用户名
     */

    
    @Column(name="loginName", length=16)
    public String getLoginName() {
        return this.loginName;
    }
    
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    /**       
     *      * 登录密码
     */

    
    @Column(name="password", length=16)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * toString
     * @return String
     */
     public String toString() {
	  StringBuffer buffer = new StringBuffer();

      buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
      buffer.append("name").append("='").append(getName()).append("' ");			
      buffer.append("loginName").append("='").append(getLoginName()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }



}


