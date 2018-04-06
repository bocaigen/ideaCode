package com.bobo.controller;

import com.bobo.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018/3/31.
 */

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

//    @RequestMapping(value = "/say/{id}", method = RequestMethod.GET)
    @GetMapping(value = "/say/{id}")
    public String say(@PathVariable("id") Integer aid, @RequestParam(value = "myId",required = false,defaultValue = "0") String Id){
        return "id : "+aid + "==myId : "+Id;
    }
}
