package com.ruoyi.project.mobile.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 缴费信息对象 tt_tuition
 * 
 * @author ruoyi
 * @date 2021-03-20
 */
public class TuitionEntity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer id;

    /** 开票类型 */
    @Excel(name = "开票类型")
    private Integer billingType;

    /** 缴费方式 */
    @Excel(name = "缴费方式")
    private Integer chargeType;

    /** 课程名 */
    @Excel(name = "课程名")
    private Integer courseId;

    /** 备注 */
    @Excel(name = "备注")
    private String description;

    /** 是否开票 */
    @Excel(name = "是否开票")
    private Integer invoice;

    /** 缴费金额 */
    @Excel(name = "缴费金额")
    private String payMoney;

    /** 缴费时间 */
    @Excel(name = "缴费时间")
    private String payTime;
    private Integer orderno;

    /** 场地名 */
    @Excel(name = "场地名")
    private Integer placeId;
    private String placeName;

    /** 学员名 */
    @Excel(name = "学员名")
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
    public void setBillingType(Integer billingType) 
    {
        this.billingType = billingType;
    }

    public Integer getBillingType() 
    {
        return billingType;
    }
    public void setChargeType(Integer chargeType) 
    {
        this.chargeType = chargeType;
    }

    public Integer getChargeType() 
    {
        return chargeType;
    }
    public void setCourseId(Integer courseId) 
    {
        this.courseId = courseId;
    }

    public Integer getCourseId() 
    {
        return courseId;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setInvoice(Integer invoice) 
    {
        this.invoice = invoice;
    }

    public Integer getInvoice() 
    {
        return invoice;
    }
    public void setPayMoney(String payMoney) 
    {
        this.payMoney = payMoney;
    }

    public String getPayMoney() 
    {
        return payMoney;
    }
    public void setPayTime(String payTime) 
    {
        this.payTime = payTime;
    }

    public String getPayTime() 
    {
        return payTime;
    }
    public void setPlaceId(Integer placeId) 
    {
        this.placeId = placeId;
    }

    public Integer getPlaceId() 
    {
        return placeId;
    }
    public void setStudentId(Integer studentId) 
    {
        this.studentId = studentId;
    }

    public Integer getStudentId() 
    {
        return studentId;
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

    public Integer getOrderno() {
        return orderno;
    }

    public void setOrderno(Integer orderno) {
        this.orderno = orderno;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("billingType", getBillingType())
            .append("chargeType", getChargeType())
            .append("courseId", getCourseId())
            .append("description", getDescription())
            .append("invoice", getInvoice())
            .append("payMoney", getPayMoney())
            .append("payTime", getPayTime())
            .append("placeId", getPlaceId())
            .append("studentId", getStudentId())
            .toString();
    }
}
