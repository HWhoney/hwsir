package com.hw.dto;

import lombok.Data;

/**购物车
 * Created by Administrator on 2018/6/29 0029.
 */
@Data
public class CartDTO {

    /**商品Id*/
    private String productId;
    /**数量*/
    private Integer productQuantity;
    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

}
