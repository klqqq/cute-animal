package com.cute.java.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 企业用户
 * </p>
 *
 * @author liuqiang123
 * @since 2018-06-05
 */
@TableName("member_shop")
public class MemberShop extends Model<MemberShop> {

    private static final long serialVersionUID = 1L;

    /**
     * 会员ID
     */
    @TableId("m_id")
    private Integer mId;
    /**
     * 企业名称
     */
    @TableField("shop_name")
    private String shopName;
    /**
     * 企业logo
     */
    private String logo;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 加入时间
     */
    private Integer addtime;
    /**
     * 编辑时间
     */
    private Integer endtime;
    /**
     * 电话
     */
    private String tel;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 客服url
     */
    @TableField("customer_url")
    private String customerUrl;
    /**
     * 营业执照
     */
    @TableField("business_license")
    private String businessLicense;
    /**
     * 省
     */
    private Integer prov;
    /**
     * 市
     */
    private Integer city;
    /**
     * 区
     */
    private Integer area;
    /**
     * 地址
     */
    private String address;
    /**
     * 描述
     */
    private String desc;
    /**
     * 评论数
     */
    @TableField("goods_comment")
    private Integer goodsComment;
    /**
     * 等级
     */
    private Integer level;
    /**
     * 余额
     */
    private Integer balance;
    /**
     * banner_url
     */
    @TableField("banner_url")
    private String bannerUrl;


    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAddtime() {
        return addtime;
    }

    public void setAddtime(Integer addtime) {
        this.addtime = addtime;
    }

    public Integer getEndtime() {
        return endtime;
    }

    public void setEndtime(Integer endtime) {
        this.endtime = endtime;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerUrl() {
        return customerUrl;
    }

    public void setCustomerUrl(String customerUrl) {
        this.customerUrl = customerUrl;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public Integer getProv() {
        return prov;
    }

    public void setProv(Integer prov) {
        this.prov = prov;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getGoodsComment() {
        return goodsComment;
    }

    public void setGoodsComment(Integer goodsComment) {
        this.goodsComment = goodsComment;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    @Override
    protected Serializable pkVal() {
        return this.mId;
    }

    @Override
    public String toString() {
        return "MemberShop{" +
        "mId=" + mId +
        ", shopName=" + shopName +
        ", logo=" + logo +
        ", status=" + status +
        ", addtime=" + addtime +
        ", endtime=" + endtime +
        ", tel=" + tel +
        ", email=" + email +
        ", customerUrl=" + customerUrl +
        ", businessLicense=" + businessLicense +
        ", prov=" + prov +
        ", city=" + city +
        ", area=" + area +
        ", address=" + address +
        ", desc=" + desc +
        ", goodsComment=" + goodsComment +
        ", level=" + level +
        ", balance=" + balance +
        ", bannerUrl=" + bannerUrl +
        "}";
    }
}
