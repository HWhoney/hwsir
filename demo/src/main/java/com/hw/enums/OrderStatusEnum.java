package com.hw.enums;

import lombok.Getter;

/**
 * 商品状态
 * Created by Administrator on 2018/6/28 0028.
 */
@Getter
public enum OrderStatusEnum {
    NEW(0,"新下单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已经取消");
    private  Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
