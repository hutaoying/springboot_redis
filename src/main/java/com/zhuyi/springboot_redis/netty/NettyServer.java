package com.zhuyi.springboot_redis.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
@Component
public class NettyServer {
    static EventLoopGroup boss = new NioEventLoopGroup();
    static EventLoopGroup work = new NioEventLoopGroup();

    public static void main(String[] args)throws InterruptedException {
        start();
    }

    @PostConstruct
    public static void start() throws InterruptedException {
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boss, work)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    public void initChannel(SocketChannel sc) throws Exception {
                        sc.pipeline().addLast(new ServerUAVHandler());
                        sc.pipeline().addLast(new LineBasedFrameDecoder(1024));
                        sc.pipeline().addLast(new StringDecoder());
                    }
                });
        ChannelFuture cf = bootstrap.bind(8888).sync();
        if (cf.isSuccess()) {
            System.out.println("启动成功");
        }
    }

    @PreDestroy
    private void destory() throws Exception {
        boss.shutdownGracefully();
        work.shutdownGracefully();
        System.out.println("关闭server");
    }
}

class ServerUAVHandler extends ChannelHandlerAdapter {
    private int count=0;
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ByteBuf buf = (ByteBuf) msg;
//        byte[] req = new byte[buf.readableBytes()];
//        buf.readBytes(req);
//        String body = new String(req, "UTF-8");
        String body = (String) msg;
        System.out.println("客户端信息是：" + body);
        System.out.println(body+",count:::"+ ++count);
//        ByteBuf resp = Unpooled.copiedBuffer("no".getBytes());
        ByteBuf resp = Unpooled.copiedBuffer(("A"+System.getProperty("line.separator")).getBytes());
//        ctx.writeAndFlush(resp).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
        ctx.writeAndFlush(resp);
    }
}
