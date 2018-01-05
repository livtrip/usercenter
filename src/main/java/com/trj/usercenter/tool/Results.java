package com.trj.usercenter.tool;

/**
 * Created by xierongli on 17/6/16.
 */
public class Results {

    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    public Results() {
    }

    public static <T> Result<T> newSuccessResult(T data) {
        return newResult(data,0, SUCCESS, true);
    }

    public static <T> Result<T> newFailedResult() {
        return newResult(null,-1, ERROR, false);
    }

    public static <T> Result<T> newFailedResult(StateCode stateCode) {
        return newResult(null,stateCode.getCode(), stateCode.getDescription(), false);
    }
    public static <T> Result<T> newFailedResult(Integer code,String message) {
        return newResult(null,code, message, false);
    }

    public static <T> Result<T> newResult(T data,Integer code, String message, boolean success) {
        Result result = new Result();
        result.setData(data);
        result.setCode(code);
        result.setSuccess(success);
        result.setMessage(message);
        return result;
    }
}
