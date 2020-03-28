package com.zhuyi.springboot_redis.util;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;

/**
 * Created by hutaoying on 2020/3/28
 */

@SpringBootTest
public class RedisTest {
//    @Autowired
//    RedisTemplate redisTemplate;
     static final String SET_KEY = "SET:USER:LOGIN:20200327";
     static final String PF_KEY = "PF:USER:LOGIN:20200329";
//    RedisProperties.Jedis client  = new RedisProperties.Jedis();
    @Test
    public void test1(){
        Jedis c = new Jedis();
        c.set("test","test");
//        for (int i = 0; i < 1000000; i++) {
//            c.sadd(SET_KEY,"USER"+i);
//            c.pfadd(PF_KEY,"USER"+i);
//        }

    }
}
