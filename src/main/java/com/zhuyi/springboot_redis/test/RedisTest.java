package com.zhuyi.springboot_redis.test;

import redis.clients.jedis.Jedis;

import java.net.URI;

/**
 * Created by hutaoying on 2020/3/28
 */

public class RedisTest {
    static final String SET_KEY = "SET:USER:LOGIN:20200327";
    static final String PF_KEY = "PF:USER:LOGIN:20200329";
    public static void main(String[] args) {

        Jedis c = new Jedis("redis://123456@118.25.191.81:6379");

        c.set("test","test");
//        for (int i = 0; i < 1000000; i++) {
//            c.sadd(SET_KEY,"USER"+i);
//            c.pfadd(PF_KEY,"USER"+i);
//        }

    }
}
