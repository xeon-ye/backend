package com.ruoyi.project.mobile.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 学员签到对象 tt_student_sign
 * 
 * @author ruoyi
 * @date 2021-03-20
 */
public class StudentSignEntity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer id;

    /** 课程名 */

    private Integer courseId;
    @Excel(name = "课程名")
    private String courseName;

    /** 场地名 */

    private Integer placeId;
    @Excel(name = "场地名")
    private String placeName;

    /** 签到时间 */
    @Excel(name = "签到时间")
    private String signTime;

    /** 签到状态（1.正常 2.迟到） */
    //@Excel(name = "签到状态", readConverterExp = "1=.正常,2=.迟到")
    private String status;

    /** 学员 */

    private Integer studentId;
    @Excel(name = "学员")
    private String studentName;

    /** 教练 */

    private Integer userId;
    @Excel(name = "教练")
    private String coachName;

    /** 本节价格 */
    @Excel(name = "本节价格")
    private String money;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setCourseId(Integer courseId) 
    {
        this.courseId = courseId;
    }

    public Integer getCourseId() 
    {
        return courseId;
    }
    public void setPlaceId(Integer placeId) 
    {
        this.placeId = placeId;
    }

    public Integer getPlaceId() 
    {
        return placeId;
    }
    public void setSignTime(String signTime) 
    {
        this.signTime = signTime;
    }

    public String getSignTime() 
    {
        return signTime;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setStudentId(Integer studentId) 
    {
        this.studentId = studentId;
    }

    public Integer getStudentId() 
    {
        return studentId;
    }
    public void setUserId(Integer userId) 
    {
        this.userId = userId;
    }

    public Integer getUserId() 
    {
        return userId;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("courseId", getCourseId())
            .append("placeId", getPlaceId())
            .append("signTime", getSignTime())
            .append("status", getStatus())
            .append("studentId", getStudentId())
            .append("userId", getUserId())
            .append("money", getMoney())
            .append("remarks", getRemarks())
            .toString();
    }
}
