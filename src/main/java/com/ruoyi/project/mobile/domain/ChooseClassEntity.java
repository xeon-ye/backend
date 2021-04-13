package com.ruoyi.project.mobile.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 选课管理对象 tt_choose_class
 * 
 * @author ruoyi
 * @date 2021-03-21
 */
public class ChooseClassEntity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer id;

    /** 结束时间 */
    @Excel(name = "结束时间")
    private String endTime;

    /** 场地 */
    @Excel(name = "场地")
    private String placeId;

    /** 开始时间 */
    @Excel(name = "开始时间")
    private String startTime;

    /** 周期 */
    @Excel(name = "周期")
    private String week;

    /** 课程 */
    @Excel(name = "课程")
    private Integer courseId;

    /** 教练 */
    @Excel(name = "教练")
    private Integer coachId;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setEndTime(String endTime) 
    {
        this.endTime = endTime;
    }

    public String getEndTime() 
    {
        return endTime;
    }
    public void setPlaceId(String placeId) 
    {
        this.placeId = placeId;
    }

    public String getPlaceId() 
    {
        return placeId;
    }
    public void setStartTime(String startTime) 
    {
        this.startTime = startTime;
    }

    public String getStartTime() 
    {
        return startTime;
    }
    public void setWeek(String week) 
    {
        this.week = week;
    }

    public String getWeek() 
    {
        return week;
    }
    public void setCourseId(Integer courseId) 
    {
        this.courseId = courseId;
    }

    public Integer getCourseId() 
    {
        return courseId;
    }
    public void setCoachId(Integer coachId) 
    {
        this.coachId = coachId;
    }

    public Integer getCoachId() 
    {
        return coachId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("endTime", getEndTime())
            .append("placeId", getPlaceId())
            .append("startTime", getStartTime())
            .append("week", getWeek())
            .append("courseId", getCourseId())
            .append("coachId", getCoachId())
            .toString();
    }
}
