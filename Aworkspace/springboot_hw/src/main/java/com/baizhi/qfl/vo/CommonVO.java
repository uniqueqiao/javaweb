package com.baizhi.qfl.vo;

import java.io.Serializable;

public class CommonVO implements Serializable {
    private Boolean status;
    private Object data;
    private String message;

    public CommonVO(){
        //刚创建的CommonVO先假定失败，成功时手动设置成功
        this.status = false;
    }

    public Boolean getStatus() {
        return status;
    }

    public CommonVO setStatus(Boolean status) {
        this.status = status;
        //所有的setter返回this，可以实现连续设置属性，并且设置完可以直接返回
        return this;
    }

    public Object getData() {
        return data;
    }

    public CommonVO setData(Object data) {
        this.data = data;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CommonVO setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "CommonVO{" +
                "status=" + status +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
