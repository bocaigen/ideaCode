package com.bobo.exception;

import com.bobo.enums.ResultEnum;

/**
 * 新建自已的异常
 * RuntimeException继承自Exception
 * spring框架只对抛出的RuntimeException异常进行回滚
 *
 * Created by zhangxibo on 2018/4/7.
 */
public class GirlException extends RuntimeException{

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
