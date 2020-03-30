package com.zhuyi.springboot_redis.lettuce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HyperLogLogOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

public class RedisController {
    @Autowired
    RedisTemplate redisTemplate;

    public void Test(){
        redisTemplate.getConnectionFactory();
        HyperLogLogOperations hyperLogLogOperations = redisTemplate.opsForHyperLogLog();
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
//        zSetOperations.add()
//        hyperLogLogOperations.add("");


    }
}
