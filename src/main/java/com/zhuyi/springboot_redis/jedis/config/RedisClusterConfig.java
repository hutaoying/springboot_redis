package com.zhuyi.springboot_redis.jedis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterNode;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class RedisClusterConfig {
    @Value("${myCluster.cluster.host}")
    String host;
    @Value("${myCluster.cluster.connectionTimeout}")
    int connectionTimeout;
    @Value("${myCluster.cluster.soTimeout}")
    int soTimeout;
    @Value("${myCluster.cluster.maxRedirections}")
    int maxRedirections;


    @Bean
    public JedisCluster jedisCluster() {
        Set<HostAndPort> nodeSet = new HashSet<>();
        String[] splits = host.split(",");
        for(String node :splits) {
            String[] split = node.split(":");
            nodeSet.add(new HostAndPort(split[0],Integer.valueOf(split[1])));
        }
//        new JedisCluster()
        return new JedisCluster(nodeSet);
    }

}
