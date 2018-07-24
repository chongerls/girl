package com.ls.girl.Repository;

import com.ls.girl.Model.Girl;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Create By lishan10 on 2018/7/24
 */

public interface GirlRepository extends PagingAndSortingRepository<Girl,Integer> {


    //通过年龄来查询
    List<Girl> findByAge(Integer age);
    List<Girl> findAllByAgeBetween(Integer low ,Integer high);
    List<Girl> findAllByName(String name);
    List<Girl> findAllByNameLike(String name);
}
