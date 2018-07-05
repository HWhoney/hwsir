package com.hw.utils;

import java.util.Random;

/**
 * 生成唯一主键
 * 格式：时间+随机数
 * @return
 * Created by Administrator on 2018/6/29 0029.
 */
public class KeyUtil {
    public static synchronized String genUniqueKey(){
        Random random=new Random();
        Integer number =random.nextInt(900000)+1000000;
        return System.currentTimeMillis()+String.valueOf(number);
    }
}
