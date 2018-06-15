package com.cute.java.modular.member.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 会员
 * </p>
 *
 * @author liuqiang123
 * @since 2018-06-13
 */
@TableName("member")
public class Member extends Model<Member> {

    private static final long serialVersionUID = 1L;

    /**
     * 会员id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 账户
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    private String salt;
    /**
     * 头像
     */
    private String headimgurl;
    /**
     * 推荐人
     */
    @TableField("flag_user")
    private Integer flagUser;
    /**
     * 类型：0-爱宠者；1-铲屎官；2-商家；3-企业会员
     */
    private Integer type;
    /**
     * 余额
     */
    private Double balance;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public Integer getFlagUser() {
        return flagUser;
    }

    public void setFlagUser(Integer flagUser) {
        this.flagUser = flagUser;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Member{" +
        "id=" + id +
        ", username=" + username +
        ", password=" + password +
        ", salt=" + salt +
        ", headimgurl=" + headimgurl +
        ", flagUser=" + flagUser +
        ", type=" + type +
        ", balance=" + balance +
        "}";
    }
}
