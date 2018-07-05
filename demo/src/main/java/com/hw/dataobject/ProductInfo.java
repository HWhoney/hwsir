package com.hw.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2018/6/28 0028.
 */
@Entity
@Data
public class ProductInfo {
    /**商品id*/
    @Id
    private String productId;
    /**商品名称*/
    private String productName;
    /**商品价格*/
    private BigDecimal productPrice;
    /**商品库存*/
    private Integer productStock;
    /**小图*/
    private  String productIcon;
    /**商品状态*/
    private Integer productStatus;
    /**类目编号*/
    private Integer categoryType;
    /**商品描述*/
    private String productDescription;
}
