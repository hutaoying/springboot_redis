package com.zhuyi.springboot_redis.jedis;


import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class SafeEncoder {
    public static byte[] encode(String str) {
        try {
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
