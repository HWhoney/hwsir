package com.hw.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 表单验证
 * Created by Administrator on 2018/6/29 0029.
 */
@Data
public class OrderForm {
    /**买家性别*/
    @NotEmpty(message="姓名必填")
    private String name;
   /**买家手机号*/
    @NotEmpty(message = "手机号必填")
    private String phone;
   /**买家地址*/
   @NotEmpty(message = "地址必填")
    private String address;
   /**买家微信opendid*/
   @NotEmpty(message = "opendid必填")
    private  String openid;
   /**购物车*/
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
