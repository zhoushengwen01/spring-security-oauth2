package com.zhou.security.springboot.utils.resultUtil;

public class ReturnResult<T> {
    private long total;
    private T data;
    private int code;
    private String msg;
    private boolean success;


    public static ReturnResult success() {
        return new ReturnResult(ResultEnum.SUCCESS);
    }

    public static ReturnResult fail() {
        return new ReturnResult(ResultEnum.FAIL);
    }

    public ReturnResult(boolean success, T data, int code, String msg, long total) {
        this.total = total;
        this.data = data;
        this.code = code;
        this.msg = msg;
        this.success = success;
    }

    public ReturnResult(long total, T data, ResultEnum resultEnum) {
        this.total = total;
        this.data = data;
        this.code = resultEnum.code;
        this.msg = resultEnum.msg;
        this.success = resultEnum.success;
    }


    public ReturnResult(boolean success, int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.success = success;
    }

    public ReturnResult(ResultEnum resultEnum) {
        this.code = resultEnum.code;
        this.msg = resultEnum.msg;
        this.success = resultEnum.success;
    }


    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
