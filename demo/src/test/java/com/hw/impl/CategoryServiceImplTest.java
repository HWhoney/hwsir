package com.hw.impl;

import com.hw.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/6/27 0027.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
   @Autowired

   private CategoryServiceImpl categoryService;
    @Test
    public void findOne() throws Exception {
        System.out.println(categoryService.findOne(1));
    }

    @Test
    public void findAll() throws Exception {
        System.out.println(categoryService.findAll());
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<Integer> list= Arrays.asList(2,3,4);
       System.out.println( categoryService.findByCategoryTypeIn(list));
    }

    @Test
    public void save() throws Exception {
        ProductCategory productCategory=new ProductCategory("和尚最爱",1);
        categoryService.save(productCategory);
    }

}