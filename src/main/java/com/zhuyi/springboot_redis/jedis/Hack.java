package com.zhuyi.springboot_redis.jedis;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Hack {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6309);
            Socket accept = serverSocket.accept();
            byte[] b = new byte[1024];
            accept.getInputStream().read(b);
            System.out.println(new String(b));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
