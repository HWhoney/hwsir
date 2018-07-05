package com.hw.impl;

import com.hw.dataobject.ProductInfo;
import com.hw.dto.CartDTO;
import com.hw.enums.ProductStatusEnum;
import com.hw.enums.ResultEnum;
import com.hw.exception.SellException;
import com.hw.repository.ProductInfoRepository;
import com.hw.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/6/28 0028.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository  repository;
    @Override
    public ProductInfo findOne(String productId) {
        ProductInfo productInfo =repository.findById(productId).get();
        return productInfo;
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<ProductInfo> findAll() {
        List<ProductInfo> productInfos =repository.findAll();
        return productInfos;
    }

    @Override
    public List<ProductInfo> findByProductStatus(Integer productStatus) {
        List<ProductInfo> productByStatus =repository.findByProductStatus(ProductStatusEnum.UP.getCode());
        return  productByStatus;
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional
//    增加库存
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO:cartDTOList){
            ProductInfo productInfo=repository.findById(cartDTO.getProductId()).get();
            if(productInfo==null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIT);
            }
            Integer result=productInfo.getProductStock()+cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }
    @Override
    @Transactional
//    减少库存
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO:cartDTOList){
            ProductInfo productInfo=repository.findById(cartDTO.getProductId()).get();
            if(productInfo==null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIT);
            }
            Integer result=productInfo.getProductStock()-cartDTO.getProductQuantity();
            if (result<0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }

    }
}
