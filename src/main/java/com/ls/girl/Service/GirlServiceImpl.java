package com.ls.girl.Service;

import com.ls.girl.Exception.GirlException;
import com.ls.girl.Model.Girl;
import com.ls.girl.Repository.GirlRepository;
import com.ls.girl.enums.ResultEnum;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * Create By lishan10 on 2018/7/23
 */
@Service
public class GirlServiceImpl implements GirlService{


    @Autowired
    GirlRepository girlRepository;
    @Override
    public Iterable<Girl> getGirlsList() {
        return girlRepository.findAll();
    }

    @Override
    public Girl add(Girl girl) {
        return girlRepository.save(girl);
    }

    @Override
    public Girl select(Integer id) {
       return girlRepository.findOne(id);
    }

    @Override
    public Girl update(Girl girl) {
        return girlRepository.save(girl);
    }

    @Override
    public void delete(Integer id) {
         girlRepository.delete(id);
    }

    @Override
    public List<Girl> ageList(Integer low,Integer high) {
//        return girlRepository.findByAge(age);
        return girlRepository.findAllByAgeBetween(low,high);
    }

    @Override
    public List<Girl> nameList(String name) {
//        return girlRepository.findAllByName(name);
        return girlRepository.findAllByNameLike(name+"%");
    }

    @Transactional
    @Override
    public void insertTow() {
        Girl girl1 = new Girl(13,"mmm",28);
        girlRepository.save(girl1);
        Girl girl2 = new Girl(14,"pppppppppppppppppp",555);
        girlRepository.save(girl2);
    }

    @Override
    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if(age<10)
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        else if(age>10&&age<16)
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
    }

}
