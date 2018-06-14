package com.cute.java.modular.video.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;

/**
 * <p>
 * 视频
 * </p>
 *
 * @author liuqiang123
 * @since 2018-06-07
 */
public class Video extends Model<Video> {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /**
     * 视频名称
     */
    @TableField("video_name")
    private String videoName;
    /**
     * 视频类型
     */
    @TableField("video_type")
    private Integer videoType;
    /**
     * 描述
     */
    @TableField("video_desc")
    private String videoDesc;
    /**
     * 播放地址
     */
    @TableField("video_url")
    private String videoUrl;
    /**
     * 会员ID
     */
    @TableField("m_id")
    private Integer mId;
    /**
     * 点赞数
     */
    private Integer favorite;
    /**
     * 分享数
     */
    private Integer share;
    /**
     * 评论数
     */
    private Integer comment;
    /**
     * 状态：0审核；1正常；2下架
     */
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public Integer getVideoType() {
        return videoType;
    }

    public void setVideoType(Integer videoType) {
        this.videoType = videoType;
    }

    public String getVideoDesc() {
        return videoDesc;
    }

    public void setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
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

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Video{" +
        "id=" + id +
        ", videoName=" + videoName +
        ", videoType=" + videoType +
        ", videoDesc=" + videoDesc +
        ", videoUrl=" + videoUrl +
        ", mId=" + mId +
        ", favorite=" + favorite +
        ", share=" + share +
        ", comment=" + comment +
        ", status=" + status +
        "}";
    }
}
