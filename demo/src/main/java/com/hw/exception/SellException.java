package com.hw.exception;

import com.hw.enums.ResultEnum;

/**
 * Created by Administrator on 2018/6/28 0028.
 */
public class SellException extends  RuntimeException{
    private Integer code;
    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }

    public SellException( Integer code,String message) {
        super(message);
        this.code = code;
    }
}
