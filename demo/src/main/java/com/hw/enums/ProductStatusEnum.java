package com.hw.enums;

import lombok.Getter;

/**
 * 商品状态
 * Created by Administrator on 2018/6/28 0028.
 */
@Getter
public enum ProductStatusEnum {
    UP(0,"在架"),
    DOWN(1,"下架")
    ;
    private Integer code;
    private String message;
    ProductStatusEnum(Integer code,String message) {
        this.code = code;
        this.message=message;
    }



}
