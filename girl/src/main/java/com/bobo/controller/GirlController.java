package com.bobo.controller;

import com.bobo.entity.Girl;
import com.bobo.entity.Result;
import com.bobo.repository.GirlRepository;
import com.bobo.service.GirlService;
import com.bobo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Administrator on 2018/4/5.
 */

@RestController
public class GirlController {

    private final static Logger log = LoggerFactory.getLogger(GirlController.class);
    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        log.info("进入girlList方法==============");
        List<Girl> girls = girlRepository.findAll();
        return girls;
    }

    /**
     * 添加一个女生
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        boolean b = bindingResult.hasErrors();
        if(b){
//            String defaultMessage = bindingResult.getFieldError().getDefaultMessage();
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError error:allErrors){
                log.error(error.getDefaultMessage());
            }
            return ResultUtil.error(0,allErrors.get(0).getDefaultMessage());
        }

        Girl saveGirl = girlRepository.save(girl);
        return ResultUtil.success(saveGirl);
    }

    /**
     * 根据id查询一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        log.info("进入girlfindOnd方法===============");
        Girl one = girlRepository.findOne(id);
        return one;
    }

    /**
     * 根据id更新一个女生
     * @param id
     * @param age
     * @param cupSize
     * @param name
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("age") Integer age,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("name") String name){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setName(name);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        Girl save = girlRepository.save(girl);
        return save;
    }

    /**
     * 根据id删除一个女生
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }

    /**
     * 通过年龄查询女生
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        List<Girl> byAge = girlRepository.findByAge(age);
        return byAge;
    }

    /**
     * 事务管理
     * 添加两个女生
     */
    @GetMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }


    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }

}
