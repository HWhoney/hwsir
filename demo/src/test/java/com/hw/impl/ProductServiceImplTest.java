package com.hw.impl;

import com.hw.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2018/6/28 0028.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;
    @Test
    public void findOne() throws Exception {
        ProductInfo productInfo=productService.findOne("1");

        System.out.println(productInfo.getProductPrice());
    }

    @Test
    public void findAll() throws Exception {
        System.out.println(productService.findAll());
    }

    @Test
    public void findAll1() throws Exception {
        PageRequest request=new PageRequest(0,2);
        Page<ProductInfo>productInfoPage=productService.findAll(request);
        System.out.println(productInfoPage.getTotalElements());
    }

//    @Test
//    public void findByProductStatus() throws Exception {
//
//        System.out.println(productService.findByProductStatus(ProductStatusEnum.UP.getCode()));
//    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("1234");
        productInfo.setProductName("虎皮尖椒");
        productInfo.setProductPrice(new BigDecimal(15.0));
        productInfo.setProductStatus(0);
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductStock(100);
        productInfo.setCategoryType(3);
        productInfo.setProductDescription("特别好吃");
        ProductInfo result=productService.save(productInfo);
        Assert.assertNotNull(result);
    }

}