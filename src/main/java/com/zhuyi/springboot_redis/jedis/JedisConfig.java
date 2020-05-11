package com.zhuyi.springboot_redis.jedis;

public class JedisConfig {
//    public static void main(String[] args) {
//        Jedis jedis = new Jedis("localhost",6309);
//        jedis.set("foo", "bar");
//        String value = jedis.get("foo");
//    }

//    *3
//    $3
//            SET
//    $3
//            foo
//    $3
//            bar

    public static void main(String[] args) throws InterruptedException {
        Client jedis = new Client("localhost", 6379);
        for (int i = 0; i < 100; i++) {
            jedis.set("test"+i, "zhuyi"+i);
            String value = jedis.get("test"+i);
            System.out.println(value);
            Thread.sleep(500);
        }

    }

}
