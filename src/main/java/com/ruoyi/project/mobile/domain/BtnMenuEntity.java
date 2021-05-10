package com.ruoyi.project.mobile.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 首页按钮权限对象 tt_btn_menu
 * 
 * @author ruoyi
 * @date 2021-04-26
 */
public class BtnMenuEntity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 按钮名称 */
    @Excel(name = "按钮名称")
    private String name;

    /** 按钮图片 */
    @Excel(name = "按钮图片")
    private String imgUrl;

    /** 菜单角色 */
    @Excel(name = "菜单角色")
    private String menuRole;

    /** 跳转页面 */
    @Excel(name = "跳转页面")
    private String targetUrl;

    private String useFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
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
    public void setImgUrl(String imgUrl) 
    {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() 
    {
        return imgUrl;
    }
    public void setMenuRole(String menuRole) 
    {
        this.menuRole = menuRole;
    }

    public String getMenuRole() 
    {
        return menuRole;
    }
    public void setTargetUrl(String targetUrl) 
    {
        this.targetUrl = targetUrl;
    }

    public String getTargetUrl() 
    {
        return targetUrl;
    }

    public String getUseFlag() {
        return useFlag;
    }

    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("imgUrl", getImgUrl())
            .append("menuRole", getMenuRole())
            .append("targetUrl", getTargetUrl())
            .toString();
    }
}
