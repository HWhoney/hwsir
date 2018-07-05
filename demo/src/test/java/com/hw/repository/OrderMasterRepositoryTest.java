package com.hw.repository;

import com.hw.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2018/6/28 0028.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;
            ;
    @Test
    public void findByBuyerOpenid() throws Exception {
        PageRequest request=new PageRequest(0,1);
        Page<OrderMaster> result=repository.findByBuyerOpenid("111",request);
       /**测试方法*/
        Assert.assertNotEquals(0,result.getTotalElements());
//        System.out.println(result.getTotalElements());
    }
    @Test
    public void findOne(){
        System.out.println(repository.findById("111").get());
    }


}