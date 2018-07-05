package com.hw.repository;

import com.hw.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2018/6/28 0028.
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
    List <ProductInfo> findByProductStatus(Integer ProductStatus);
    Page<ProductInfo> findAll(Pageable pageable);
}
