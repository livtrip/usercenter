package com.trj.usercenter.tool;

/**
 * 状态参数
 * Created by xierongli on 17/6/16.
 */
public enum StateCode {
    DATE_EMPTY(-10,"数据为空"),
    SIGN_ERROR(-12,"数据签名错误"),
    PARAM_ERROR(-11,"参数不合法");

    private Integer code;
    private String description;

    StateCode(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
