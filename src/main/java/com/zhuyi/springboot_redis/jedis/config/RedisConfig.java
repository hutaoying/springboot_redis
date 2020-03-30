package com.zhuyi.springboot_redis.jedis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {
    @Value("${spring.redis.host}")
    private String host;

    @Value("${redis.port}")
    private int port;

    @Value("${redis.timeout}")
    private int timeout;

    @Value("${redis.pool.max-idle}")
    private int maxIdle;

    @Value("${redis.pool.max-wait}")
    private long maxWaitMillis;

    @Value("${redis.password}")
    private String password;

    @Value("${redis.block-when-exhausted}")
    private boolean blockWhenExhausted;


    @Bean
    public JedisPool redisPoolFactory()  throws Exception{
        System.out.println("=============JedisPool注入成功！！redis地址：" + host + ":" + port);
        System.out.println("=============JedisPool注入成功！！password：" + password + "maxIdle:" + maxIdle+ "max-wait:" + maxWaitMillis+ "blockWhenExhausted:" + blockWhenExhausted);
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        // 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
        jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
        // 是否启用pool的jmx管理功能, 默认true
        //是否开启jmx监控，如果应用开启了jmx端口并且jmxEnabled设置为true，就可以通过jconsole或者jvisualvm看到关于连接池的相关统计
        // ，有助于了解连接池的使用情况，并且可以针对其做监控统计，默认是true。
        jedisPoolConfig.setJmxEnabled(true);
        //redis设置了密码时使用，没密码使用该方式初始化连接池会失败
        //JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout,password);
        //redis没设置密码时使用
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout);
        return jedisPool;
    }

}
