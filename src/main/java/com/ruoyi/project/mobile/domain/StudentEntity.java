package com.ruoyi.project.mobile.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 学员对象 tt_student
 * 
 * @author ruoyi
 * @date 2021-03-20
 */
public class StudentEntity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer id;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 年龄 */
    @Excel(name = "年龄")
    private String age;

    /** 剩余课时 */
    @Excel(name = "剩余课时")
    private String classHours;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 家长名 */
    @Excel(name = "家长名")
    private String parentName;

    /** 家长电话 */
    @Excel(name = "家长电话")
    private String parentTel;

    /** 所属场地 */
    @Excel(name = "所属场地")
    private String placeId;

    /** 报名时间 */
    @Excel(name = "报名时间")
    private String registrTime;

    /** 学号 */
    @Excel(name = "学号")
    private String sn;

    /** 电话 */
    @Excel(name = "电话")
    private String tel;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idCard;

    /** 剩余金额 */
    @Excel(name = "剩余金额")
    private String money;

    /** 销售名 */
    @Excel(name = "销售名")
    private String saleName;

    /** 单节价格 */
    @Excel(name = "单节价格")
    private String unitPrice;

    //缴费方式(1 充值  2买课)
    private Integer chargeType;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setAge(String age) 
    {
        this.age = age;
    }

    public String getAge() 
    {
        return age;
    }
    public void setClassHours(String classHours) 
    {
        this.classHours = classHours;
    }

    public String getClassHours() 
    {
        return classHours;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setParentName(String parentName) 
    {
        this.parentName = parentName;
    }

    public String getParentName() 
    {
        return parentName;
    }
    public void setParentTel(String parentTel) 
    {
        this.parentTel = parentTel;
    }

    public String getParentTel() 
    {
        return parentTel;
    }
    public void setPlaceId(String placeId) 
    {
        this.placeId = placeId;
    }

    public String getPlaceId() 
    {
        return placeId;
    }
    public void setRegistrTime(String registrTime) 
    {
        this.registrTime = registrTime;
    }

    public String getRegistrTime() 
    {
        return registrTime;
    }
    public void setSn(String sn) 
    {
        this.sn = sn;
    }

    public String getSn() 
    {
        return sn;
    }
    public void setTel(String tel) 
    {
        this.tel = tel;
    }

    public String getTel() 
    {
        return tel;
    }
    public void setIdCard(String idCard) 
    {
        this.idCard = idCard;
    }

    public String getIdCard() 
    {
        return idCard;
    }
    public void setMoney(String money) 
    {
        this.money = money;
    }

    public String getMoney() 
    {
        return money;
    }
    public void setSaleName(String saleName) 
    {
        this.saleName = saleName;
    }

    public String getSaleName() 
    {
        return saleName;
    }
    public void setUnitPrice(String unitPrice) 
    {
        this.unitPrice = unitPrice;
    }

    public String getUnitPrice() 
    {
        return unitPrice;
    }

    public Integer getChargeType() {
        return chargeType;
    }

    public void setChargeType(Integer chargeType) {
        this.chargeType = chargeType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("address", getAddress())
            .append("age", getAge())
            .append("classHours", getClassHours())
            .append("name", getName())
            .append("parentName", getParentName())
            .append("parentTel", getParentTel())
            .append("placeId", getPlaceId())
            .append("registrTime", getRegistrTime())
            .append("sn", getSn())
            .append("tel", getTel())
            .append("idCard", getIdCard())
            .append("money", getMoney())
            .append("saleName", getSaleName())
            .append("unitPrice", getUnitPrice())
            .toString();
    }
}
