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
    private String placeName;

    /** 开始时间 */
    @Excel(name = "开始时间")
    private String startTime;

    /** 周期 */
    @Excel(name = "周期")
    private String week;

    /** 课程 */
    @Excel(name = "课程")
    private Integer courseId;
    private String courseName;

    /** 教练 */
    @Excel(name = "教练")
    private Integer coachId;
    private String coachName;

    private Integer studentId;
    private String studentName;

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

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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
