package com.zhuyi.springboot_redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Cacheable-------使用这个注解的方法在执行后会缓存其返回结果。
 * @CacheEvict--------使用这个注解的方法在其执行前或执行后移除Spring Cache中的某些元素。
 */
@Service
//用来描述该类中所有方法使用的缓存名称，当然也可以不使用该注解，直接在具体的缓存注解上配置名称
@CacheConfig(cacheNames = "test")
public class CacheTestService {
    String uu;
    @Autowired
    CacheManager cacheManager;


    @Cacheable(key = "#name")
    public void hh(String name,String address){

    }

    @Cacheable(value ="#root.hh1" )
    public void hh1(String name,String address){

//        cacheManager.getCache()

    }
}
