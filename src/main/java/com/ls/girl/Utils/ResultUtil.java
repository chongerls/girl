package com.ls.girl.Utils;

/**
 * Create By lishan10 on 2018/7/24
 */
public class ResultUtil {
    public static RestResult success(Object object){
        RestResult restResult = new RestResult();
        restResult.setCode(0);
        restResult.setMessage("Success!");
        restResult.setData(object);
        return restResult;
    }
    public static RestResult success(){
        return success(null);
    }
    public static RestResult error(int code ,String msg){
        RestResult restResult = new RestResult();
        restResult.setCode(code);
        restResult.setMessage(msg);
        restResult.setData(null);
        return restResult;
    }
}
