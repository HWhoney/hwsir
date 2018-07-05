package com.hw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



/**
 * Created by Administrator on 2018/6/27 0027.
 */

@RunWith(SpringRunner.class)

@SpringBootTest
public class LoggerTest {
    private  final Logger logger= LoggerFactory.getLogger(LoggerTest.class) ;
    @Test
    public void test1(){
        String name="hw";
        String password="123456";
        logger.debug("debug....");
        logger.info("info...");
        logger.info("name:"+name+"password:"+password);
        logger.info("name:{}, password:{}",name,password);
        logger.error("error...");
    }
            }
