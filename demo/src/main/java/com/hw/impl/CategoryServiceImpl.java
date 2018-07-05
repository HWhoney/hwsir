package com.hw.impl;

import com.hw.dataobject.ProductCategory;
import com.hw.repository.ProductCategoryRepository;
import com.hw.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * service接口实现
 * Created by Administrator on 2018/6/27 0027.
 */
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private  ProductCategoryRepository repository;
    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.findById(categoryId).get();

    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType) {
        return repository.findByCategoryTypeIn( categoryType);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
