package com.agriculture.common;

public enum HttpCode {

    // 成功状态码
    SUCCESS("00000", "成功"),
    UNKNOWN_ERROR("99999", "服务未知异常"),
    // 系统500错误
    SYSTEM_ERROR("10000", "系统异常，请稍后重试"),


    // 认证错误：20001-29999
    USER_NOAUTH("20000", "用户未登录"),
    TOKEN_ERROR("20001", "生成token失败"),
    LOGIN_ERROR("20002", "登录失败"),
    USER_LOCKED("20004", "账户已锁定"),
    USER_PASS_OUT("20005", "用户名或密码错误次数过多"),
    USER_NOTFIND_ERROR("20006", "没有找到用户"),
    USER_ERROR("20007", "用户名或密码不正确"),
    USER_CODE("20008", "验证码输入有误，请重新输入！"),
    USER_DISABLE("20009", "该账号也被禁用,请联系管理员!"),
    USER_INFOERROR("20010", "用户信息获取异常!"),
    USER_NOAUTHON("20011", "用户没有权限访问"),
    USER_System("20012", "系统错误"),

    ;


    private String code;

    private String message;

    HttpCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}

