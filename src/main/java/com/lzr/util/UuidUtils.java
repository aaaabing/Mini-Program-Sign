package com.lzr.util;

import java.util.UUID;

/***
 * 快速生成uuid的工具类
 * @author lzr
 * @date 2021.08.13
 */

public class UuidUtils {

    public static String getFastUuid(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
