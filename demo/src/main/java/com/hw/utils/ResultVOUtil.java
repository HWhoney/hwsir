package com.hw.utils;

import com.hw.vo.ResultVO;

/**
 * Created by Administrator on 2018/6/28 0028.
 */
public class ResultVOUtil {
    public static ResultVO success(Object object){
        ResultVO resultVO=new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
    public static ResultVO success(){
        return success(null);
    }
    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO=new ResultVO();
        resultVO.setData(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
