package com.hw.impl;

import com.hw.dto.OrderDTO;
import com.hw.enums.ResultEnum;
import com.hw.exception.SellException;
import com.hw.service.BuyerService;
import com.hw.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/7/3 0003.
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService{
    @Autowired
    private OrderService orderService;
    @Override
    public OrderDTO findOrderOne(String openid,String orderId){
        return checkOrderOwner(openid,orderId) ;
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO=checkOrderOwner(openid,orderId);
        if (orderDTO==null){
            log.error("【取消订单】查不到该订单,orderId={}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO) ;
    }
    private OrderDTO checkOrderOwner(String openid, String orderId){
        OrderDTO orderDTO=orderService.findOne(orderId);
        if (orderDTO==null){
            return null;
        }
//        判断是否是自己的订单
        if(!orderDTO.getBuyerOpenid().equals(openid)){
            log.error("【查询订单】订单的openid不一致，openid={},orderId={}",orderDTO.getBuyerOpenid(),orderDTO.getOrderId());
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return  orderDTO;
    }
}
