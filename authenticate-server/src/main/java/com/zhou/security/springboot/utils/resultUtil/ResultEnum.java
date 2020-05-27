package com.zhou.security.springboot.utils.resultUtil;

public enum ResultEnum {
    SUCCESS("成功", true, 200),
    FAIL("失败", false, 500),
    LOGIN_SUCCESS("登录成功", true, 0),
    LOGIN_FAIL("登录失败", false, 1);

    public int code;
    public String msg;
    public boolean success;

    ResultEnum(String msg, boolean success, int code) {
        this.code = code;
        this.success = success;
        this.msg = msg;
    }

}
