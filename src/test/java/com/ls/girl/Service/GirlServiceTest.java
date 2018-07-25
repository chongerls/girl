package com.ls.girl.Service;

import com.ls.girl.Model.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import static org.junit.Assert.*;

/**
 * Create By lishan10 on 2018/7/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void selectTest(){
        Girl girl = girlService.select(7);
        Assert.assertEquals(new Integer(28),girl.getAge());
    }
}