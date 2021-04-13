package com.ruoyi.project.mobile.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 场地对象 tt_place
 * 
 * @author ruoyi
 * @date 2021-03-19
 */
public class PlaceEntity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Integer id;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 提成 */
    @Excel(name = "提成")
    private String commission;

    /** 负责人 */
    @Excel(name = "负责人")
    private String contacts;

    /** 负责人电话 */
    @Excel(name = "负责人电话")
    private String contactsTel;

    /** 结束时间 */
    @Excel(name = "结束时间")
    private String endTime;

    /** 场地名 */
    @Excel(name = "场地名")
    private String name;

    /** 租金 */
    @Excel(name = "租金")
    private String rent;

    /** 收租方式 */
    @Excel(name = "收租方式")
    private Integer rentType;

    /** 签约时间 */
    @Excel(name = "签约时间")
    private String signTime;

    /** 开始时间 */
    @Excel(name = "开始时间")
    private String startTime;

    /** 场地类型 */
    @Excel(name = "场地类型")
    private Integer type;

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
    public void setCommission(String commission) 
    {
        this.commission = commission;
    }

    public String getCommission() 
    {
        return commission;
    }
    public void setContacts(String contacts) 
    {
        this.contacts = contacts;
    }

    public String getContacts() 
    {
        return contacts;
    }
    public void setContactsTel(String contactsTel) 
    {
        this.contactsTel = contactsTel;
    }

    public String getContactsTel() 
    {
        return contactsTel;
    }
    public void setEndTime(String endTime) 
    {
        this.endTime = endTime;
    }

    public String getEndTime() 
    {
        return endTime;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setRent(String rent) 
    {
        this.rent = rent;
    }

    public String getRent() 
    {
        return rent;
    }
    public void setRentType(Integer rentType) 
    {
        this.rentType = rentType;
    }

    public Integer getRentType() 
    {
        return rentType;
    }
    public void setSignTime(String signTime) 
    {
        this.signTime = signTime;
    }

    public String getSignTime() 
    {
        return signTime;
    }
    public void setStartTime(String startTime) 
    {
        this.startTime = startTime;
    }

    public String getStartTime() 
    {
        return startTime;
    }
    public void setType(Integer type) 
    {
        this.type = type;
    }

    public Integer getType() 
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("address", getAddress())
            .append("commission", getCommission())
            .append("contacts", getContacts())
            .append("contactsTel", getContactsTel())
            .append("endTime", getEndTime())
            .append("name", getName())
            .append("rent", getRent())
            .append("rentType", getRentType())
            .append("signTime", getSignTime())
            .append("startTime", getStartTime())
            .append("type", getType())
            .toString();
    }
}
