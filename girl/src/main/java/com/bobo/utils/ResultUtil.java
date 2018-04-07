package com.bobo.utils;

import com.bobo.entity.Result;

/**
 * Created by zhangxibo on 2018/4/7.
 */
public class ResultUtil {

    /**
     * 成功 有返回数据
     * @param object
     * @return
     */
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(1);
        result.setMessage("成功！");
        result.setData(object);
        return result;
    }

    /**
     * 成功 没有返回数据
     * @return
     */
    public static Result success(){
        return success(null);
    }

    /**
     * 失败
     * @param code
     * @param message
     * @return
     */
    public static Result error(Integer code,String message){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}
