package org.food.safety.trace.entity;
// Generated 2017-9-11 16:19:23 by Hibernate Tools 5.2.5.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * 对象关系表
 */
@Entity
@Table(name="Reference"
)
public class Reference  implements org.food.safety.trace.dto.Viewable,java.io.Serializable {


     /**
      * id
     */
     private String id;
     /**
      * 目标对象
     */
     private String targetName;
     /**
      * 目标
     */
     private String targetId;
     /**
      * 源对象
     */
     private String sourceName;
     /**
      * 源
     */
     private String sourceId;

    public Reference() {
    }

    public Reference(String targetName, String targetId, String sourceName, String sourceId) {
       this.targetName = targetName;
       this.targetId = targetId;
       this.sourceName = sourceName;
       this.sourceId = sourceId;
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
     *      * 目标对象
     */

    
    @Column(name="targetName", length=128)
    public String getTargetName() {
        return this.targetName;
    }
    
    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }
    /**       
     *      * 目标
     */

    
    @Column(name="targetId", length=128)
    public String getTargetId() {
        return this.targetId;
    }
    
    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }
    /**       
     *      * 源对象
     */

    
    @Column(name="sourceName", length=128)
    public String getSourceName() {
        return this.sourceName;
    }
    
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
    /**       
     *      * 源
     */

    
    @Column(name="sourceId", length=128)
    public String getSourceId() {
        return this.sourceId;
    }
    
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * toString
     * @return String
     */
     public String toString() {
	  StringBuffer buffer = new StringBuffer();

      buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
      buffer.append("targetName").append("='").append(getTargetName()).append("' ");			
      buffer.append("targetId").append("='").append(getTargetId()).append("' ");			
      buffer.append("sourceName").append("='").append(getSourceName()).append("' ");			
      buffer.append("sourceId").append("='").append(getSourceId()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }



}


