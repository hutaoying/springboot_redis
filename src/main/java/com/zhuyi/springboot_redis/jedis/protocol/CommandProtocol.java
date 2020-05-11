package com.zhuyi.springboot_redis.jedis.protocol;

import java.io.IOException;
import java.io.OutputStream;

public class CommandProtocol {
    //set foo bar
    private  static String DOLLOR="$";
    private  static String ADD_STRING="+";
    private  static String ASTERISK_STRING="*";
    private  static String LINE="\r\n";
    public static void sendCommand(OutputStream outputStream,Command command,byte[] ... args){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ASTERISK_STRING).append(args.length+1).append(LINE);
        stringBuilder.append(DOLLOR).append(command.name().length()).append(LINE);
        stringBuilder.append(command).append(LINE);
        for (byte[] arg : args) {
            stringBuilder.append(DOLLOR).append(arg.length).append(LINE);
            stringBuilder.append(new String(arg)).append(LINE);
        }
        try {
            outputStream.write(stringBuilder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static enum Command{
        GET,SET;
    }

}
