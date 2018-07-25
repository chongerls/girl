package com.ls.girl.Handle;

import com.ls.girl.Exception.GirlException;
import com.ls.girl.Model.Girl;
import com.ls.girl.Utils.RestResult;
import com.ls.girl.Utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create By lishan10 on 2018/7/25
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RestResult handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else{
            logger.error("[系统错误]："+e.getMessage());
            return ResultUtil.error(-1,"未知错误");
        }
    }
}
