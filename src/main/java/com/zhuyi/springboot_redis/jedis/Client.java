package com.zhuyi.springboot_redis.jedis;

public class Client {
    private Connection connection;

    public Client(String host,int port) {
         connection = new Connection(host, port);
    }

    public String set(String key, String value) {
        connection.sendCommand();
        return null;
    }

    public String get(String key) {
        connection.sendCommand();
        return null;
    }

}
