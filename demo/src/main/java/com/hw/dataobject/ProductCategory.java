package com.hw.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**类目
 * Created by Administrator on 2018/6/27 0027.
 */
//映射成数据库中的实体
@Entity
//动态更新注解
@DynamicUpdate
//调用lombok插件，自动生成getter和setter方法
@Data
public class ProductCategory {
    /**类目id.*/
    @Id
    @GeneratedValue
    private Integer categoryId;
    /**类目名字*/
    private String categoryName;
    private Date createTime;
    private Date updateTime;
    /**类目编号*/
    private  Integer  categoryType;


    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
