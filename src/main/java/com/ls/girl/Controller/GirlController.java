package com.ls.girl.Controller;

import com.ls.girl.Model.Girl;
import com.ls.girl.Service.GirlService;
import com.ls.girl.Utils.RestResult;
import com.ls.girl.Utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Create By lishan10 on 2018/7/23
 */
@RestController
public class GirlController {
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    GirlService girlService;
    //获取女生列表
    @GetMapping(value = "/girls")
    List<Girl> getGirlsList(){
        Iterable<Girl> girls = girlService.getGirlsList();
        List<Girl> list = new ArrayList<>();
        for(Girl girl : girls){
            list.add(girl);
        }
        logger.info("getGrilsList:获取女生列表成功～～～");
       return list;
    }
    //创建一个女生
    @PostMapping(value = "/add")
    RestResult<Girl> add(@Valid Girl g, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
//            RestResult<Girl> restResult = new RestResult<>();
//            restResult.setCode(1);
//            restResult.setMessage(bindingResult.getFieldError().getDefaultMessage());
//            restResult.setData(null);
//            return restResult;
            return ResultUtil.error(400, bindingResult.getFieldError().getDefaultMessage());
        }
//        Girl girl1 = new Girl();
//        girl1.setAge(g.getAge());
//        girl1.setName(g.getName());
          g.setAge(g.getAge());
          g.setName(g.getName());
//        RestResult<Girl> restResult = new RestResult<>();
//        restResult.setCode(1);
//        restResult.setMessage("Success!");
//        restResult.setData(girlService.add(girl1));
//        return restResult;
//        return girlService.add(girl1);
        return ResultUtil.success(girlService.add(g));
    }
    //通过id查询一个女生
    @GetMapping(value = "/girls/{id}")
    Girl select(@PathVariable Integer id){
        logger.info("获取id={}的女生信息～",id);
        return girlService.select(id);
    }
    //通过id更新一个女生
    @PutMapping(value = "/update/{id}")
    Girl update(@PathVariable Integer id,
                @RequestParam("age") Integer age,
                @RequestParam("name") String name){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setName(name);

        return girlService.update(girl);
    }
    //通过id删除一个女生
    @DeleteMapping(value = "delete/{id}")
    void delete(@PathVariable Integer id){
         girlService.delete(id);
    }
    //按照年龄查询
    @GetMapping(value = "/girl/{low}/{high}")
    List<Girl> ageList(@PathVariable Integer low,@PathVariable Integer high){
        return  girlService.ageList(low, high);
    }
    //按照名字查询
    @GetMapping(value = "girl/{name}")
    List<Girl> nameList(@PathVariable String name){
        return girlService.nameList(name);
    }
    //事务管理：插入两个女生
    @GetMapping(value = "/insert")
    void insert(){
        girlService.insertTow();
    }
    @GetMapping(value = "/age/{id}")
    void getAge(@PathVariable Integer id) throws Exception {
        girlService.getAge(id);
    }
}
