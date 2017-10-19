package org.food.safety.trace.entity.business;
// Generated 2017-10-19 11:03:09 by Hibernate Tools 5.2.5.Final


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
@Table(name="t_item_type"
)
public class ItemType extends org.food.safety.trace.dto.ItemTypeView implements java.io.Serializable {


     /**
      * id
     */
     private String id;
     /**
      * 组织
     */
     private String organization;
     /**
      * 类型
     */
     private String cateNo;
     /**
      * 名称
     */
     private String name;
     /**
      * 编号
     */
     private String code;
     /**
      * 条码
     */
     private String barCode;
     /**
      * 销售单位
     */
     private String packageUnit;
     /**
      * 规格
     */
     private String itemStandard;
     /**
      * 默认进价
     */
     private Double inputPrice;
     /**
      * 基本进价
     */
     private Double sellPrice;
     /**
      * 是否打折
     */
     private String isVipDiscount;
     /**
      * 是否销售
     */
     private String isSell;
     /**
      * 处方单位
     */
     private String recipeUnit;
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

    public ItemType() {
    }

    public ItemType(String organization, String cateNo, String name, String code, String barCode, String packageUnit, String itemStandard, Double inputPrice, Double sellPrice, String isVipDiscount, String isSell, String recipeUnit, Date createDate, String createUserId, Date updateDate, String updateUserId, String status) {
       this.organization = organization;
       this.cateNo = cateNo;
       this.name = name;
       this.code = code;
       this.barCode = barCode;
       this.packageUnit = packageUnit;
       this.itemStandard = itemStandard;
       this.inputPrice = inputPrice;
       this.sellPrice = sellPrice;
       this.isVipDiscount = isVipDiscount;
       this.isSell = isSell;
       this.recipeUnit = recipeUnit;
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
     *      * 类型
     */

    
    @Column(name="cate_no", length=128)
    public String getCateNo() {
        return this.cateNo;
    }
    
    public void setCateNo(String cateNo) {
        this.cateNo = cateNo;
    }
    /**       
     *      * 名称
     */

    
    @Column(name="item_name", length=8)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    /**       
     *      * 编号
     */

    
    @Column(name="item_code", insertable=false, updatable=false, length=32)
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    /**       
     *      * 条码
     */

    
    @Column(name="bar_code", length=48)
    public String getBarCode() {
        return this.barCode;
    }
    
    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
    /**       
     *      * 销售单位
     */

    
    @Column(name="package_unit", length=128)
    public String getPackageUnit() {
        return this.packageUnit;
    }
    
    public void setPackageUnit(String packageUnit) {
        this.packageUnit = packageUnit;
    }
    /**       
     *      * 规格
     */

    
    @Column(name="item_standard", length=48)
    public String getItemStandard() {
        return this.itemStandard;
    }
    
    public void setItemStandard(String itemStandard) {
        this.itemStandard = itemStandard;
    }
    /**       
     *      * 默认进价
     */

    
    @Column(name="input_price", length=48)
    public Double getInputPrice() {
        return this.inputPrice;
    }
    
    public void setInputPrice(Double inputPrice) {
        this.inputPrice = inputPrice;
    }
    /**       
     *      * 基本进价
     */

    
    @Column(name="sell_price", length=48)
    public Double getSellPrice() {
        return this.sellPrice;
    }
    
    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }
    /**       
     *      * 是否打折
     */

    
    @Column(name="is_vip_discount", length=8)
    public String getIsVipDiscount() {
        return this.isVipDiscount;
    }
    
    public void setIsVipDiscount(String isVipDiscount) {
        this.isVipDiscount = isVipDiscount;
    }
    /**       
     *      * 是否销售
     */

    
    @Column(name="is_sell", length=8)
    public String getIsSell() {
        return this.isSell;
    }
    
    public void setIsSell(String isSell) {
        this.isSell = isSell;
    }
    /**       
     *      * 处方单位
     */

    
    @Column(name="recipe_unit", length=128)
    public String getRecipeUnit() {
        return this.recipeUnit;
    }
    
    public void setRecipeUnit(String recipeUnit) {
        this.recipeUnit = recipeUnit;
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

    
    @Column(name="status", insertable=false, updatable=false, length=128)
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
      buffer.append("cateNo").append("='").append(getCateNo()).append("' ");			
      buffer.append("name").append("='").append(getName()).append("' ");			
      buffer.append("code").append("='").append(getCode()).append("' ");			
      buffer.append("barCode").append("='").append(getBarCode()).append("' ");			
      buffer.append("packageUnit").append("='").append(getPackageUnit()).append("' ");			
      buffer.append("itemStandard").append("='").append(getItemStandard()).append("' ");			
      buffer.append("inputPrice").append("='").append(getInputPrice()).append("' ");			
      buffer.append("sellPrice").append("='").append(getSellPrice()).append("' ");			
      buffer.append("isVipDiscount").append("='").append(getIsVipDiscount()).append("' ");			
      buffer.append("isSell").append("='").append(getIsSell()).append("' ");			
      buffer.append("recipeUnit").append("='").append(getRecipeUnit()).append("' ");			
      buffer.append("createUserId").append("='").append(getCreateUserId()).append("' ");			
      buffer.append("updateUserId").append("='").append(getUpdateUserId()).append("' ");			
      buffer.append("status").append("='").append(getStatus()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }



}


