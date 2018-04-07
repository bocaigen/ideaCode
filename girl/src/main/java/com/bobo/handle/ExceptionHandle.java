package com.bobo.handle;

import com.bobo.entity.Result;
import com.bobo.exception.GirlException;
import com.bobo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 * Created by zhangxibo on 2018/4/7.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger log = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else{
            log.info("【系统异常】 {} ",e);
            return ResultUtil.error(-1,"未知错误");
        }
    }
}
