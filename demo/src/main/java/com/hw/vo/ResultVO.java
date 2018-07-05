package com.hw.vo;

import lombok.Data;

/**
 * http请求返回的最外层对象
 * Created by Administrator on 2018/6/28 0028.
 */
@Data
public class ResultVO<T> {
    /**错误码*/
    private Integer code;
    /**提示信息*/
    private String msg;
    /**具体内容*/
    private T data;

}
