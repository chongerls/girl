package com.ls.girl.Service;

import com.ls.girl.Model.Girl;

import java.util.List;

/**
 * Create By lishan10 on 2018/7/23
 */
public interface GirlService {
    Iterable<Girl> getGirlsList();
    Girl add(Girl girl);
    Girl select(Integer id);
    Girl update(Girl girl);
    void delete(Integer id);
    List<Girl> ageList(Integer age,Integer age2);
    List<Girl> nameList(String name);
    void insertTow();
    void getAge(Integer id) throws Exception;
}
