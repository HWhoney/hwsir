package com.hw.repository;

import com.hw.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by Administrator on 2018/6/28 0028.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
   private OrderDetailRepository repository;
    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> orderDetailList=repository.findByOrderId("111");
        Assert.assertEquals(0,orderDetailList.size());
//        System.out.println(orderDetailList);
    }
    @Test
    public void findOne(){
        OrderDetail orderDetail=repository.findById("1").get();
        Assert.assertNull(orderDetail);
//        System.out.println(repository.findById("1").get());
    }

}