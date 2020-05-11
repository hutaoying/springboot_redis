package com.zhuyi.springboot_redis.jedis;

import com.zhuyi.springboot_redis.jedis.protocol.CommandProtocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Connection {
    private Socket socket;
    private String host;
    private int port;
    private OutputStream outputStream;
    private InputStream inputStream;

    public Connection(String host, int port) {
        this.host = host;
        this.port = port;
    }

    Connection sendCommand(CommandProtocol.Command command,byte[] ... args){
        connection();
        CommandProtocol.sendCommand(outputStream, command,args);
        return this;
    }

    public String getStatusCodeReply(){
        byte[] b =new byte[1024];
        try {
            socket.getInputStream().read(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(b);
    }


    public void connection() {
        try {
            socket = new Socket(host, port);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
