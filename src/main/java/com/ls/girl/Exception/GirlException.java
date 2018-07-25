package com.ls.girl.Exception;

import com.ls.girl.enums.ResultEnum;

/**
 * Create By lishan10 on 2018/7/25
 */
public class GirlException extends RuntimeException{
    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
