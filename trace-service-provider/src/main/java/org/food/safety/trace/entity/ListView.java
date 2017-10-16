package org.food.safety.trace.entity;
// Generated 2017-10-16 15:44:53 by Hibernate Tools 5.2.5.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * 列表视图信息
 */
@Entity
@Table(name="ListView"
)
public class ListView  implements org.food.safety.trace.dto.Viewable,java.io.Serializable {


     /**
      * id
     */
     private String id;
     /**
      * 实体名称
     */
     private String entityName;
     /**
      * 标题
     */
     private String title;
     /**
      * 是否显示到列表
     */
     private boolean listable;
     /**
      * 是否支持搜索
     */
     private boolean searchable;
     /**
      * 是否修改
     */
     private boolean updateable;
     /**
      * 是否添加
     */
     private boolean insertable;
     /**
      * 列名
     */
     private String name;
     /**
      * 规则
     */
     private String rules;
     /**
      * 渲染元素类型
     */
     private String itemType;
     /**
      * 引用数据类型
     */
     private String refType;
     /**
      * 备选数据
     */
     private String itemValue;

    public ListView() {
    }

    public ListView(String entityName, String title, boolean listable, boolean searchable, boolean updateable, boolean insertable, String name, String rules, String itemType, String refType, String itemValue) {
       this.entityName = entityName;
       this.title = title;
       this.listable = listable;
       this.searchable = searchable;
       this.updateable = updateable;
       this.insertable = insertable;
       this.name = name;
       this.rules = rules;
       this.itemType = itemType;
       this.refType = refType;
       this.itemValue = itemValue;
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
     *      * 实体名称
     */

    
    @Column(name="entityName", length=128)
    public String getEntityName() {
        return this.entityName;
    }
    
    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
    /**       
     *      * 标题
     */

    
    @Column(name="title", length=32)
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    /**       
     *      * 是否显示到列表
     */

    
    @Column(name="listable")
    public boolean isListable() {
        return this.listable;
    }
    
    public void setListable(boolean listable) {
        this.listable = listable;
    }
    /**       
     *      * 是否支持搜索
     */

    
    @Column(name="searchable")
    public boolean isSearchable() {
        return this.searchable;
    }
    
    public void setSearchable(boolean searchable) {
        this.searchable = searchable;
    }
    /**       
     *      * 是否修改
     */

    
    @Column(name="updateable")
    public boolean isUpdateable() {
        return this.updateable;
    }
    
    public void setUpdateable(boolean updateable) {
        this.updateable = updateable;
    }
    /**       
     *      * 是否添加
     */

    
    @Column(name="insertable")
    public boolean isInsertable() {
        return this.insertable;
    }
    
    public void setInsertable(boolean insertable) {
        this.insertable = insertable;
    }
    /**       
     *      * 列名
     */

    
    @Column(name="name", length=32)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    /**       
     *      * 规则
     */

    
    @Column(name="rules", length=512)
    public String getRules() {
        return this.rules;
    }
    
    public void setRules(String rules) {
        this.rules = rules;
    }
    /**       
     *      * 渲染元素类型
     */

    
    @Column(name="itemType", length=32)
    public String getItemType() {
        return this.itemType;
    }
    
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
    /**       
     *      * 引用数据类型
     */

    
    @Column(name="refType", length=32)
    public String getRefType() {
        return this.refType;
    }
    
    public void setRefType(String refType) {
        this.refType = refType;
    }
    /**       
     *      * 备选数据
     */

    
    @Column(name="itemValue", length=512)
    public String getItemValue() {
        return this.itemValue;
    }
    
    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }

    /**
     * toString
     * @return String
     */
     public String toString() {
	  StringBuffer buffer = new StringBuffer();

      buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
      buffer.append("entityName").append("='").append(getEntityName()).append("' ");			
      buffer.append("title").append("='").append(getTitle()).append("' ");			
      buffer.append("listable").append("='").append(isListable()).append("' ");			
      buffer.append("searchable").append("='").append(isSearchable()).append("' ");			
      buffer.append("updateable").append("='").append(isUpdateable()).append("' ");			
      buffer.append("insertable").append("='").append(isInsertable()).append("' ");			
      buffer.append("name").append("='").append(getName()).append("' ");			
      buffer.append("rules").append("='").append(getRules()).append("' ");			
      buffer.append("itemType").append("='").append(getItemType()).append("' ");			
      buffer.append("refType").append("='").append(getRefType()).append("' ");			
      buffer.append("itemValue").append("='").append(getItemValue()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }



}


