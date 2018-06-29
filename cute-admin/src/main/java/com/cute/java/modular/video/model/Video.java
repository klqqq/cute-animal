package com.cute.java.modular.video.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 视频
 * </p>
 *
 * @author liuqiang123
 * @since 2018-06-07
 */
@TableName("video")
public class Video extends Model<Video> {

    private static final long serialVersionUID = 1L;

    @TableField("video_id")
    private String video_id;
    /**
     * 视频id
     */
    private String video_url;
    /*
    **播放地址
     */

    private String video_name;
    /**
     * 视频名字
     */
    private String video_desc;
    /**
     * 描述
     */
    private String video_type_id;
    /**
     * 视频类别
     */
    private Integer m_cat_id;
    /**
     * 宠物ID
     */
    private Integer m_id;
    /**
     * 会员ID
     */
    private Integer favorite;
    /**
     * 点赞数
     */
    private Integer share;
    /**
     * 分享数
     */
    private Integer view;
    /**
     * 播放次数
     */
    private Integer gift;
    /**
     * 礼物的数量
     */
    private Integer comment;
    /**
     * 论数量
     */
    private String upload_time;
    /**
     * 上传时间
     */
    private String upload_latlon;
    /**
     * 精度，纬度
     */
    private Integer status;
    /**
     * 阿里云审核？
     */
    private Long video_Width;
    /**
     * 阿里云审核？
     */
    private Long video_Height;
    /**
     * 阿里云审核？
     */

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getVideo_name() {
        return video_name;
    }

    public void setVideo_name(String video_name) {
        this.video_name = video_name;
    }

    public String getVideo_desc() {
        return video_desc;
    }

    public void setVideo_desc(String video_desc) {
        this.video_desc = video_desc;
    }

    public String getVideo_type_id() {
        return video_type_id;
    }

    public void setVideo_type_id(String video_type_id) {
        this.video_type_id = video_type_id;
    }

    public Integer getM_cat_id() {
        return m_cat_id;
    }

    public void setM_cat_id(Integer m_cat_id) {
        this.m_cat_id = m_cat_id;
    }

    public Integer getM_id() {
        return m_id;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    public Integer getFavorite() {
        return favorite;
    }

    public void setFavorite(Integer favorite) {
        this.favorite = favorite;
    }

    public Integer getShare() {
        return share;
    }

    public void setShare(Integer share) {
        this.share = share;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public Integer getGift() {
        return gift;
    }

    public void setGift(Integer gift) {
        this.gift = gift;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public String getUpload_time() {
        return upload_time;
    }

    public void setUpload_time(String upload_time) {
        this.upload_time = upload_time;
    }

    public String getUpload_latlon() {
        return upload_latlon;
    }

    public void setUpload_latlon(String upload_latlon) {
        this.upload_latlon = upload_latlon;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getVideo_Height() {
        return video_Height;
    }

    public void setVideo_Height(Long video_Height) {
        this.video_Height = video_Height;
    }

    public Long getVideo_Width() {
        return video_Width;
    }

    public void setVideo_Width(Long video_Width) {
        this.video_Width = video_Width;
    }



    @Override
    protected Serializable pkVal() {
        return this.video_id;
    }

    @Override
    public String toString() {
        return "Video{" +
                "video_id='" + video_id + '\'' +
                ", video_url='" + video_url + '\'' +
                ", video_name='" + video_name + '\'' +
                ", video_desc='" + video_desc + '\'' +
                ", video_type_id='" + video_type_id + '\'' +
                ", m_cat_id=" + m_cat_id +
                ", m_id=" + m_id +
                ", favorite=" + favorite +
                ", share=" + share +
                ", view=" + view +
                ", gift=" + gift +
                ", comment=" + comment +
                ", upload_time='" + upload_time + '\'' +
                ", upload_latlon='" + upload_latlon + '\'' +
                ", status=" + status +
                ", video_Width=" + video_Width +
                ", video_Height=" + video_Height +
                '}';
    }
}



