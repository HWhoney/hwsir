package com.hw.utils;

import com.hw.enums.CodeEnum;

/**
 * Created by Administrator on 2018/6/29 0029.
 */
public class EnumUtil {
    public static<T extends CodeEnum> T getByCode (Integer code , Class<T> enumClass){
        for (T each:enumClass.getEnumConstants())
            {
                if(code.equals(each.getCode())){
                    return each;
            }
        }
        return null;
    }
}
