package com.zhuyi.springboot_redis.jedis;

import redis.clients.jedis.Jedis;

public class JedisConfig {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        jedis.set("foo", "bar");
        String value = jedis.get("foo");
    }

}
