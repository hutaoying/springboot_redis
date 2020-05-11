package com.zhuyi.springboot_redis.jedis;

import com.zhuyi.springboot_redis.jedis.protocol.CommandProtocol;

public class Client {
    private Connection connection;

    public Client(String host,int port) {
         connection = new Connection(host, port);
    }

    public String set(String key, String value) {
        connection.sendCommand(CommandProtocol.Command.SET,SafeEncoder.encode(key),SafeEncoder.encode(value));
        return connection.getStatusCodeReply();
    }

    public String get(String key) {
        connection.sendCommand(CommandProtocol.Command.GET,SafeEncoder.encode(key));
        return connection.getStatusCodeReply();
    }

}
