package com.ruoyi.project.mobile.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 商品库存对象 tt_storage
 * 
 * @author ruoyi
 * @date 2021-03-23
 */
public class StorageEntity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一id */
    private Integer id;

    /** 商品名 */
    @Excel(name = "商品名")
    private String name;

    /** 品牌 */
    @Excel(name = "品牌")
    private String brand;

    /** 单价 */
    @Excel(name = "单价")
    private BigDecimal price;

    /** 库存量 */
    @Excel(name = "库存量")
    private Integer inventory;

    /** 图片 */
    @Excel(name = "图片")
    private String imgUrl;

    private String type;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setBrand(String brand) 
    {
        this.brand = brand;
    }

    public String getBrand() 
    {
        return brand;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setInventory(Integer inventory) 
    {
        this.inventory = inventory;
    }

    public Integer getInventory() 
    {
        return inventory;
    }
    public void setImgUrl(String imgUrl) 
    {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() 
    {
        return imgUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("brand", getBrand())
            .append("price", getPrice())
            .append("inventory", getInventory())
            .append("remark", getRemark())
            .append("imgUrl", getImgUrl())
            .toString();
    }
}
