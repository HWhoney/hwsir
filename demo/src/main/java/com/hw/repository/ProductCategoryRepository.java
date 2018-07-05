package com.hw.repository;

import com.hw.dataobject.ProductCategory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2018/6/27 0027.
 */
//jpa接口，默认查找方法是按照id查找
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>{
    //自定义按照类目查找的抽象方法
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
