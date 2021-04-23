package com.ruoyi.project.mobile.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 短信发送记录对象 tt_send_msg
 * 
 * @author ruoyi
 * @date 2021-04-21
 */
public class SendMsgEntity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 短信id */
    private Integer id;

    /** 短信内容 */
    @Excel(name = "短信内容")
    private String content;

    /** 发送时间 */
    @Excel(name = "发送时间")
    private String sendTime;

    /** 发送手机号 */
    @Excel(name = "发送手机号")
    private String sendMobile;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setSendTime(String sendTime) 
    {
        this.sendTime = sendTime;
    }

    public String getSendTime() 
    {
        return sendTime;
    }
    public void setSendMobile(String sendMobile) 
    {
        this.sendMobile = sendMobile;
    }

    public String getSendMobile() 
    {
        return sendMobile;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("content", getContent())
            .append("sendTime", getSendTime())
            .append("sendMobile", getSendMobile())
            .toString();
    }
}
