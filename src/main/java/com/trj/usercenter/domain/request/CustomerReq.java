package com.trj.usercenter.domain.request;


import javax.validation.constraints.NotNull;

public class CustomerReq {

    @NotNull(message = "Id不能为空")
    private Integer id;
    @NotNull(message = "状态不能为空")
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
