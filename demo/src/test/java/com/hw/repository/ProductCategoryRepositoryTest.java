package com.hw.repository;

import com.hw.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * 单元测试
 * Created by Administrator on 2018/6/27 0027.
 */
//测试注解
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private  ProductCategoryRepository repository;
    @Test

    public void findOneTest(){
        System.out.println(repository.findById(1).get().toString());
    }
    @Test
    public void saveTest(){

  //        ProductCategory productCategory = repository.findById(1).get();
//          productCategory.setCategoryType(5);
//          repository.save(productCategory);
        ProductCategory productCategory=new ProductCategory("女生最爱",9);
        ProductCategory  result =repository.save(productCategory);
        Assert.assertNull(result);
//        System.out.println("update successfully");
    }
    @Test
    public void findByCategoryTypeInTest(){
        List <Integer> list= Arrays.asList(2,3,4);
        List<ProductCategory> result= repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }

}