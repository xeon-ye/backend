package com.ruoyi.project.mobile.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 课程信息对象 tt_course
 * 
 * @author ruoyi
 * @date 2021-03-20
 */
public class CourseEntity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer id;

    /** 课时数 */
    @Excel(name = "课时数")
    private String classHours;

    /** 单节价格 */
    @Excel(name = "单节价格")
    private String money;

    /** 课程名 */
    @Excel(name = "课程名")
    private String name;
    private Integer type;

    /** 场地名 */
    @Excel(name = "场地名")
    private Integer placeId;
    private String placeName;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }

    public String getClassHours() {
        return classHours;
    }

    public void setClassHours(String classHours) {
        this.classHours = classHours;
    }

    public void setMoney(String money)
    {
        this.money = money;
    }

    public String getMoney() 
    {
        return money;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPlaceId(Integer placeId) 
    {
        this.placeId = placeId;
    }

    public Integer getPlaceId() 
    {
        return placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("classHours", getClassHours())
            .append("money", getMoney())
            .append("name", getName())
            .append("placeId", getPlaceId())
            .toString();
    }
}
