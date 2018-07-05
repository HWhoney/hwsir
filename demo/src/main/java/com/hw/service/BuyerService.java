package com.hw.service;

import com.hw.dto.OrderDTO;

/**
 * Created by Administrator on 2018/7/3 0003.
 */
public interface BuyerService {
//    查询订单
    OrderDTO findOrderOne(String openid,String oderId);
//    取消订单
    OrderDTO cancelOrder(String openid,String oderId);

}
