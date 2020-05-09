package com.zhuyi.springboot_redis.util;

import com.zhuyi.springboot_redis.inter.A;
import com.zhuyi.springboot_redis.inter.B;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
    @Test
    public void test2(){
        /**
         * 三个参数
         * 1、ClassLoader
         * 方法需要动态生成一个类，这个类实现了A和B两个接口，然后创建这个类的对象
         * 需要生成一个类，这个类也需要加载到方法区中，所以我们需要一个ClassLoader来加载该类
         *
         * 2、Class[] interfaces
         * 我们需要代理对象实现的数组
         *
         * 3、InvocationHandler
         * 调用处理器
         */
        ClassLoader classLoader = this.getClass().getClassLoader();
        //这里创建一个空实现的调用处理器。
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("你好！！！！");//注意这里添加了一点小逻辑
                return "hello";
            }
        };
        Object obj = Proxy.newProxyInstance(classLoader, new Class[]{A.class, B.class}, invocationHandler);
        //强转为A和B接口类型，说明生成的代理对象实现了A和B接口
        A a = (A) obj;
        B b = (B) obj;
        System.out.println("a "+a.toString());
        //注意这里调用了toString()方法
        System.out.println("b "+b.getClass()); //final 方法 不会执行invoke
        //注意这里调用了getClass()方法
        //这里在A接口中添加了一个方法public Object aaa(String s1, int i);
        Object hello = a.aaa("Hello", 100);
        System.out.println("class "+ obj.getClass());//这里看一下代理对象是什么
        System.out.println(hello);//这里看一下返回值是什么

    }

}
