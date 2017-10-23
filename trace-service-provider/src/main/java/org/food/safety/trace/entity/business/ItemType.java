package org.food.safety.trace.entity.business;
// Generated 2017-10-23 17:48:01 by Hibernate Tools 5.2.5.Final


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
      * 库存上限
     */
     private Integer wareUpLimit;
     /**
      * 库存下限
     */
     private Integer wareDownLimit;
     /**
      * 剂型
     */
     private String drugForm;
     /**
      * 零散比
     */
     private Integer itemBulk;
     /**
      * 处方单位
     */
     private String recipeUnit;
     /**
      * 处方价格
     */
     private Double recipePrice;
     /**
      * 是否记库
     */
     private String isCount;
     /**
      * 拼音编码
     */
     private String inputCode;
     /**
      * 货位信息
     */
     private String location;
     /**
      * 分组
     */
     private String groupName;
     /**
      * 是否可兑换
     */
     private String isCanExchange;
     /**
      * 兑换积分
     */
     private Integer exchangeRewardPoint;
     /**
      * 生产商
     */
     private String dealerCode;
     /**
      * 生产商名称
     */
     private String dealerName;
     /**
      * 用法
     */
     private String useWay;
     /**
      * 备注
     */
     private String remark;
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
      * 商品服务种类
     */
     private String itemStyle;
     /**
      * 业务类型
     */
     private String busiTypeId;
     /**
      * 会员价
     */
     private Double vipSellPrice;
     /**
      * 质保期
     */
     private Integer safeDay;
     /**
      * 是否散装
     */
     private Double isScattered;
     /**
      * 状态
     */
     private String status;

    public ItemType() {
    }

    public ItemType(String organization, String cateNo, String name, String code, String barCode, String packageUnit, String itemStandard, Double inputPrice, Double sellPrice, String isVipDiscount, String isSell, Integer wareUpLimit, Integer wareDownLimit, String drugForm, Integer itemBulk, String recipeUnit, Double recipePrice, String isCount, String inputCode, String location, String groupName, String isCanExchange, Integer exchangeRewardPoint, String dealerCode, String dealerName, String useWay, String remark, Date createDate, String createUserId, Date updateDate, String updateUserId, String itemStyle, String busiTypeId, Double vipSellPrice, Integer safeDay, Double isScattered, String status) {
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
       this.wareUpLimit = wareUpLimit;
       this.wareDownLimit = wareDownLimit;
       this.drugForm = drugForm;
       this.itemBulk = itemBulk;
       this.recipeUnit = recipeUnit;
       this.recipePrice = recipePrice;
       this.isCount = isCount;
       this.inputCode = inputCode;
       this.location = location;
       this.groupName = groupName;
       this.isCanExchange = isCanExchange;
       this.exchangeRewardPoint = exchangeRewardPoint;
       this.dealerCode = dealerCode;
       this.dealerName = dealerName;
       this.useWay = useWay;
       this.remark = remark;
       this.createDate = createDate;
       this.createUserId = createUserId;
       this.updateDate = updateDate;
       this.updateUserId = updateUserId;
       this.itemStyle = itemStyle;
       this.busiTypeId = busiTypeId;
       this.vipSellPrice = vipSellPrice;
       this.safeDay = safeDay;
       this.isScattered = isScattered;
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

    
    @Column(name="item_name", length=96)
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
     *      * 库存上限
     */

    
    @Column(name="ware_up_limit", length=11)
    public Integer getWareUpLimit() {
        return this.wareUpLimit;
    }
    
    public void setWareUpLimit(Integer wareUpLimit) {
        this.wareUpLimit = wareUpLimit;
    }
    /**       
     *      * 库存下限
     */

    
    @Column(name="ware_down_limit", length=11)
    public Integer getWareDownLimit() {
        return this.wareDownLimit;
    }
    
    public void setWareDownLimit(Integer wareDownLimit) {
        this.wareDownLimit = wareDownLimit;
    }
    /**       
     *      * 剂型
     */

    
    @Column(name="drug_form", length=128)
    public String getDrugForm() {
        return this.drugForm;
    }
    
    public void setDrugForm(String drugForm) {
        this.drugForm = drugForm;
    }
    /**       
     *      * 零散比
     */

    
    @Column(name="item_bulk", length=11)
    public Integer getItemBulk() {
        return this.itemBulk;
    }
    
    public void setItemBulk(Integer itemBulk) {
        this.itemBulk = itemBulk;
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
     *      * 处方价格
     */

    
    @Column(name="recipe_price", length=48)
    public Double getRecipePrice() {
        return this.recipePrice;
    }
    
    public void setRecipePrice(Double recipePrice) {
        this.recipePrice = recipePrice;
    }
    /**       
     *      * 是否记库
     */

    
    @Column(name="is_count", length=8)
    public String getIsCount() {
        return this.isCount;
    }
    
    public void setIsCount(String isCount) {
        this.isCount = isCount;
    }
    /**       
     *      * 拼音编码
     */

    
    @Column(name="input_code", length=48)
    public String getInputCode() {
        return this.inputCode;
    }
    
    public void setInputCode(String inputCode) {
        this.inputCode = inputCode;
    }
    /**       
     *      * 货位信息
     */

    
    @Column(name="location", length=128)
    public String getLocation() {
        return this.location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    /**       
     *      * 分组
     */

    
    @Column(name="group_name", length=48)
    public String getGroupName() {
        return this.groupName;
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    /**       
     *      * 是否可兑换
     */

    
    @Column(name="is_can_exchange", insertable=false, updatable=false, length=48)
    public String getIsCanExchange() {
        return this.isCanExchange;
    }
    
    public void setIsCanExchange(String isCanExchange) {
        this.isCanExchange = isCanExchange;
    }
    /**       
     *      * 兑换积分
     */

    
    @Column(name="exchange_reward_point", insertable=false, updatable=false, length=11)
    public Integer getExchangeRewardPoint() {
        return this.exchangeRewardPoint;
    }
    
    public void setExchangeRewardPoint(Integer exchangeRewardPoint) {
        this.exchangeRewardPoint = exchangeRewardPoint;
    }
    /**       
     *      * 生产商
     */

    
    @Column(name="dealer_code", length=128)
    public String getDealerCode() {
        return this.dealerCode;
    }
    
    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
    }
    /**       
     *      * 生产商名称
     */

    
    @Column(name="dealer_name", insertable=false, updatable=false, length=48)
    public String getDealerName() {
        return this.dealerName;
    }
    
    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }
    /**       
     *      * 用法
     */

    
    @Column(name="use_way")
    public String getUseWay() {
        return this.useWay;
    }
    
    public void setUseWay(String useWay) {
        this.useWay = useWay;
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
     *      * 商品服务种类
     */

    
    @Column(name="item_style", insertable=false, updatable=false, length=48)
    public String getItemStyle() {
        return this.itemStyle;
    }
    
    public void setItemStyle(String itemStyle) {
        this.itemStyle = itemStyle;
    }
    /**       
     *      * 业务类型
     */

    
    @Column(name="busi_type_id", insertable=false, updatable=false, length=48)
    public String getBusiTypeId() {
        return this.busiTypeId;
    }
    
    public void setBusiTypeId(String busiTypeId) {
        this.busiTypeId = busiTypeId;
    }
    /**       
     *      * 会员价
     */

    
    @Column(name="vip_sell_price", insertable=false, updatable=false)
    public Double getVipSellPrice() {
        return this.vipSellPrice;
    }
    
    public void setVipSellPrice(Double vipSellPrice) {
        this.vipSellPrice = vipSellPrice;
    }
    /**       
     *      * 质保期
     */

    
    @Column(name="safe_day", insertable=false, updatable=false, length=11)
    public Integer getSafeDay() {
        return this.safeDay;
    }
    
    public void setSafeDay(Integer safeDay) {
        this.safeDay = safeDay;
    }
    /**       
     *      * 是否散装
     */

    
    @Column(name="is_scattered", insertable=false, updatable=false)
    public Double getIsScattered() {
        return this.isScattered;
    }
    
    public void setIsScattered(Double isScattered) {
        this.isScattered = isScattered;
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
      buffer.append("wareUpLimit").append("='").append(getWareUpLimit()).append("' ");			
      buffer.append("wareDownLimit").append("='").append(getWareDownLimit()).append("' ");			
      buffer.append("drugForm").append("='").append(getDrugForm()).append("' ");			
      buffer.append("itemBulk").append("='").append(getItemBulk()).append("' ");			
      buffer.append("recipeUnit").append("='").append(getRecipeUnit()).append("' ");			
      buffer.append("recipePrice").append("='").append(getRecipePrice()).append("' ");			
      buffer.append("isCount").append("='").append(getIsCount()).append("' ");			
      buffer.append("inputCode").append("='").append(getInputCode()).append("' ");			
      buffer.append("location").append("='").append(getLocation()).append("' ");			
      buffer.append("groupName").append("='").append(getGroupName()).append("' ");			
      buffer.append("isCanExchange").append("='").append(getIsCanExchange()).append("' ");			
      buffer.append("exchangeRewardPoint").append("='").append(getExchangeRewardPoint()).append("' ");			
      buffer.append("dealerCode").append("='").append(getDealerCode()).append("' ");			
      buffer.append("dealerName").append("='").append(getDealerName()).append("' ");			
      buffer.append("useWay").append("='").append(getUseWay()).append("' ");			
      buffer.append("remark").append("='").append(getRemark()).append("' ");			
      buffer.append("createUserId").append("='").append(getCreateUserId()).append("' ");			
      buffer.append("updateUserId").append("='").append(getUpdateUserId()).append("' ");			
      buffer.append("itemStyle").append("='").append(getItemStyle()).append("' ");			
      buffer.append("busiTypeId").append("='").append(getBusiTypeId()).append("' ");			
      buffer.append("vipSellPrice").append("='").append(getVipSellPrice()).append("' ");			
      buffer.append("safeDay").append("='").append(getSafeDay()).append("' ");			
      buffer.append("isScattered").append("='").append(getIsScattered()).append("' ");			
      buffer.append("status").append("='").append(getStatus()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }



}


