package com.ruoyi.project.miniapp.weixinpay.vo;

/**
 * @Description:
 * @author: lzq
 * @date: 2018年7月3日
 */
public class Json {
    private boolean success;
    private String msg;
    private Object data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
