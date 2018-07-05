package com.hw.service;

import com.hw.dataobject.ProductCategory;

import java.util.List;

/**
 * Created by Administrator on 2018/6/27 0027.
 */
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);
    List <ProductCategory> findAll();
    List <ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);
    ProductCategory save(ProductCategory productCategory);

}
