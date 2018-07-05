package com.hw.service;

import com.hw.dataobject.ProductInfo;
import com.hw.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**productInfoservice
 * Created by Administrator on 2018/6/28 0028.
 */
public interface ProductService {
    ProductInfo findOne(String productId);
    Page<ProductInfo> findAll(Pageable pageable);
    List<ProductInfo> findAll();
    List<ProductInfo> findByProductStatus(Integer productStatus);
    ProductInfo save(ProductInfo productInfo);
//    加库存
    void increaseStock(List<CartDTO> cartDTOList);
//    减库存
    void decreaseStock(List<CartDTO> cartDTOList);
}
