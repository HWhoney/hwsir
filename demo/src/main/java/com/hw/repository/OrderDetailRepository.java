package com.hw.repository;

import com.hw.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2018/6/28 0028.
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
    List <OrderDetail> findByOrderId(String orderId);
}
