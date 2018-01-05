package com.trj.usercenter.util;

import java.util.Map;

/**
 * 签名工具
 * Created by xierongli on 17/6/20.
 */
public class SignUtil {

    private final static  String SOLT_VALUE = "000000";

    public static  String generateSignByStr(String params){
        StringBuilder sb = new StringBuilder();
        sb.append(SOLT_VALUE).append(params).append(SOLT_VALUE);
        System.out.println(params);
        return MD5.GetMD5Code(sb.toString());
    }

    public static  String generateSignByMap(Map map){
        map.remove("sign");
        String params = MapUtil.convertMapToString(map);
        generateSignByStr(params);
        return "";
    }
}
