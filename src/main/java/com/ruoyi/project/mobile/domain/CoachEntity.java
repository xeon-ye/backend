package com.ruoyi.project.mobile.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 教练信息对象 tt_coach
 * 
 * @author ruoyi
 * @date 2021-03-21
 */
public class CoachEntity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer id;

    /** 入职日期 */
    @Excel(name = "入职日期")
    private String entryDate;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idCard;

    /** 照片 */
    @Excel(name = "照片")
    private String imgUrl;

    /** 全职/兼职 */
    @Excel(name = "全职/兼职")
    private String isFullTime;

    /** 离职日期 */
    @Excel(name = "离职日期")
    private String leaveDate;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 是否请假 */
    @Excel(name = "是否请假")
    private String onLeave;

    /** 是否离职 */
    @Excel(name = "是否离职")
    private String onWork;

    /** 场地 */
    @Excel(name = "场地")
    private Integer placeId;
    private String placeName;

    /** 简单描述 */
    @Excel(name = "简单描述")
    private String remarks;

    /** 电话 */
    @Excel(name = "电话")
    private String tel;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setEntryDate(String entryDate) 
    {
        this.entryDate = entryDate;
    }

    public String getEntryDate() 
    {
        return entryDate;
    }
    public void setIdCard(String idCard) 
    {
        this.idCard = idCard;
    }

    public String getIdCard() 
    {
        return idCard;
    }
    public void setImgUrl(String imgUrl) 
    {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() 
    {
        return imgUrl;
    }
    public void setIsFullTime(String isFullTime) 
    {
        this.isFullTime = isFullTime;
    }

    public String getIsFullTime() 
    {
        return isFullTime;
    }
    public void setLeaveDate(String leaveDate) 
    {
        this.leaveDate = leaveDate;
    }

    public String getLeaveDate() 
    {
        return leaveDate;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setOnLeave(String onLeave) 
    {
        this.onLeave = onLeave;
    }

    public String getOnLeave() 
    {
        return onLeave;
    }
    public void setOnWork(String onWork) 
    {
        this.onWork = onWork;
    }

    public String getOnWork() 
    {
        return onWork;
    }
    public void setPlaceId(Integer placeId) 
    {
        this.placeId = placeId;
    }

    public Integer getPlaceId() 
    {
        return placeId;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }
    public void setTel(String tel) 
    {
        this.tel = tel;
    }

    public String getTel() 
    {
        return tel;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("entryDate", getEntryDate())
            .append("idCard", getIdCard())
            .append("imgUrl", getImgUrl())
            .append("isFullTime", getIsFullTime())
            .append("leaveDate", getLeaveDate())
            .append("name", getName())
            .append("onLeave", getOnLeave())
            .append("onWork", getOnWork())
            .append("placeId", getPlaceId())
            .append("remarks", getRemarks())
            .append("tel", getTel())
            .toString();
    }
}
