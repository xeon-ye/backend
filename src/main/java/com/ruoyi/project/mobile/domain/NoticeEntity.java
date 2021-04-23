package com.ruoyi.project.mobile.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 公告轮播对象 tt_notice
 * 
 * @author ruoyi
 * @date 2021-03-22
 */
public class NoticeEntity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一标识 */
    private Integer id;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String imgUrl;

    /** 标题 */
    @Excel(name = "标题")
    private String nickName;

    /** 发布时间 */
    @Excel(name = "发布时间")
    private String publishDate;

    /** 发布人 */
    @Excel(name = "发布人")
    private Integer publishId;
    private String publishName;

    /** 内容 */
    @Excel(name = "内容")
    private String reward;

    /** 类型 */
    @Excel(name = "类型")
    private String type;
    private Integer receiveId;
    private String receiveName;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setImgUrl(String imgUrl) 
    {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() 
    {
        return imgUrl;
    }
    public void setNickName(String nickName) 
    {
        this.nickName = nickName;
    }

    public String getNickName() 
    {
        return nickName;
    }
    public void setPublishDate(String publishDate) 
    {
        this.publishDate = publishDate;
    }

    public String getPublishDate() 
    {
        return publishDate;
    }
    public void setPublishId(Integer publishId) 
    {
        this.publishId = publishId;
    }

    public Integer getPublishId() 
    {
        return publishId;
    }
    public void setReward(String reward) 
    {
        this.reward = reward;
    }

    public String getReward() 
    {
        return reward;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }

    public String getPublishName() {
        return publishName;
    }

    public void setPublishName(String publishName) {
        this.publishName = publishName;
    }

    public Integer getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Integer receiveId) {
        this.receiveId = receiveId;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("imgUrl", getImgUrl())
            .append("nickName", getNickName())
            .append("publishDate", getPublishDate())
            .append("publishId", getPublishId())
            .append("reward", getReward())
            .append("type", getType())
            .toString();
    }
}
