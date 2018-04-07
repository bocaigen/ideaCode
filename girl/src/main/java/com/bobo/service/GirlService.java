package com.bobo.service;

import com.bobo.entity.Girl;
import com.bobo.enums.ResultEnum;
import com.bobo.exception.GirlException;
import com.bobo.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/4/5.
 */

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    /**
     * 查询的方法上不用添加事务
     */
    @Transactional
    public void insertTwo(){

        Girl girlA = new Girl();
        girlA.setAge(18);
        girlA.setCupSize("B");
        girlA.setName("赵丽颖");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(28);
        girlB.setCupSize("FGGGG");
        girlB.setName("赵雅芝");
        girlRepository.save(girlB);

    }

    public void getAge(Integer id) throws Exception {
        Girl one = girlRepository.findOne(id);
        Integer age = one.getAge();
        if(age <= 10){
            //返回你还在上小学吧
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age > 10 && age <= 16){
            //返回你可能在上初中
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过id查询一个女生
     * @param id
     * @return
     */
    public Girl findOneById(Integer id){
        Girl one = girlRepository.findOne(id);
        return one;
    }

}
