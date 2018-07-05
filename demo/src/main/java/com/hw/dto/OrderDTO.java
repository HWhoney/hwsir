package com.hw.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hw.dataobject.OrderDetail;
import com.hw.enums.PayStatusEnum;
import com.hw.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/6/29 0029.
 */
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
/**不返回空值属性*/
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    private String orderId;
    /**买家名字*/
    private String buyerName;
    /**买家手机号*/
    private String buyerPhone;
    /**买家地址*/
    private String buyerAddress;
    /**买家微信Openid*/
    private String buyerOpenid;
    /**订单总金额*/
    private BigDecimal orderAmount;
    /**订单状态,默认为新订单*/
    private Integer orderStatus;
    /**支付状态，默认为0未支付*/
    private Integer payStatus= PayStatusEnum.WAIT.getCode();
    /**创建时间*/
    @JsonSerialize(using =  Date2LongSerializer.class)
    private Date createTime;
    /**修改时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;
 /*   @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }
    @JsonIgnore
    public CodeEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class );
    }*/
    List<OrderDetail> orderDetailList;
}
