package com.hw.repository;

import com.hw.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2018/6/28 0028.
 */
/**运行当前类*/

@RunWith(SpringRunner.class)
/**spring测试注解*/
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;
    @Test
    public void findByProductStatus() throws Exception {
        List <ProductInfo> productinfo=repository.findByProductStatus(1);
        System.out.println("测试输出:"+productinfo);
    }

    @Test
    public  void findOne(){
        System.out.println("测试输出:"+repository.findById("1").get());
    }
    @Test
    public void saveProductInfo (){
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("12345");
        productInfo.setProductName("大盘鸡");
        productInfo.setProductPrice(new BigDecimal(32.6));
        productInfo.setProductStatus(0);
        productInfo.setProductIcon("http://xxxx.jpg");
        productInfo.setProductStock(100);
        productInfo.setCategoryType(3);
        productInfo.setProductDescription("特别好吃");
        ProductInfo result=repository.save(productInfo);
        Assert.assertNotNull(result);
    }
}