package com.ruoyi.project.mobile.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 商品购买记录对象 tt_purchase_detail
 * 
 * @author ruoyi
 * @date 2021-04-15
 */
public class PurchaseDetailEntity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 商品id */
    @Excel(name = "商品id")
    private Long storageId;
    private String storageName;

    /** 购买人手机号 */
    @Excel(name = "购买人手机号")
    private String buyTel;

    /** 购买时间 */
    @Excel(name = "购买时间")
    private String buyTime;

    /** 购买数量 */
    @Excel(name = "购买数量")
    private String buyCount;

    /** 总消费 */
    @Excel(name = "总消费")
    private String buyMoney;

    /**
     * 微信商户订单号
     */
    private int orderno;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStorageId(Long storageId) 
    {
        this.storageId = storageId;
    }

    public Long getStorageId() 
    {
        return storageId;
    }
    public void setBuyTel(String buyTel) 
    {
        this.buyTel = buyTel;
    }

    public String getBuyTel() 
    {
        return buyTel;
    }
    public void setBuyTime(String buyTime) 
    {
        this.buyTime = buyTime;
    }

    public String getBuyTime() 
    {
        return buyTime;
    }
    public void setBuyCount(String buyCount) 
    {
        this.buyCount = buyCount;
    }

    public String getBuyCount() 
    {
        return buyCount;
    }
    public void setBuyMoney(String buyMoney) 
    {
        this.buyMoney = buyMoney;
    }

    public String getBuyMoney() 
    {
        return buyMoney;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public int getOrderno() {
        return orderno;
    }

    public void setOrderno(int orderno) {
        this.orderno = orderno;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("storageId", getStorageId())
            .append("buyTel", getBuyTel())
            .append("buyTime", getBuyTime())
            .append("buyCount", getBuyCount())
            .append("buyMoney", getBuyMoney())
            .toString();
    }
}
