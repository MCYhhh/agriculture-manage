package com.agriculture.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//公共返回对象

/**
 * 封装统一返回结果类
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private String code;
    private String msg;
    private Object data;

    /**
     * 成功返回结果
     * @param msg
     * @return
     * */
    public static Result success(UserDTO msg){
        return new Result(HttpCode.SUCCESS.code(),msg,null);
    }

    public static Result success(Object data){
        return new Result(HttpCode.SUCCESS.code(),HttpCode.SUCCESS.message(), data);
    }
    /**
     * 成功返回结果
     * @param msg
     * @param  data
     * @return
     * */
    public static Result success(String msg, Object data){
        return new Result(HttpCode.SUCCESS.code(),msg,data);
    }

    /**
     * 失败返回结果
     * @param msg
     * @return
     * */
    public static Result error(String msg){
        return new Result(HttpCode.SYSTEM_ERROR.code(),msg,null);
    }
    public static Result error(String code,String msg){
        return new Result(code,msg,null);
    }
}

