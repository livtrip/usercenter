package com.trj.usercenter.tool;

/**
 * Created by xierongli on 17/6/16.
 */
public class Results {

    private static final String SUCCESS = "成功";
    private static final String ERROR = "失败";

    public Results() {
    }

    public static <T> Result<T> newSuccessResult(T data) {
        return newResult(data, "成功", true);
    }

    public static <T> Result<T> newFailedResult() {
        return newResult(null, "失败", false);
    }

    public static <T> Result<T> newFailedResult(String message) {
        return newResult(null, message, false);
    }

    public static <T> Result<T> newResult(T data, String message, boolean success) {
        Result result = new Result();
        result.setData(data);
        result.setSuccess(success);
        result.setMessage(message);
        return result;
    }
}
