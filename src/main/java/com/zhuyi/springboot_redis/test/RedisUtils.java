package com.zhuyi.springboot_redis.test;

import redis.clients.jedis.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by hutaoying on 2020/3/28
 */

public class RedisUtils {
    static final String SET_KEY = "SET:USER:LOGIN:20200327";
    static final String PF_KEY = "PF:USER:LOGIN:20200329";
    private static JedisPool pool;
    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(100);
        config.setMaxIdle(50);
        config.setMaxWaitMillis(3000);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        pool = new JedisPool(config,"118.25.191.81",6379,2000,"123456");
    }

    public static void main(String[] args) {


        Jedis jedis = pool.getResource();

        jedis.set("test","test");
//
        for (int i = 0; i < 1000000; i++) {
            jedis.sadd(SET_KEY,"USER"+i);

            jedis.pfadd(PF_KEY,"USER"+i);
        }
    }
}
