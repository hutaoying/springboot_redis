//package com.zhuyi.springboot_redis.netty;
//
//import io.netty.bootstrap.Bootstrap;
//import io.netty.buffer.ByteBuf;
//import io.netty.buffer.Unpooled;
//import io.netty.channel.*;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioSocketChannel;
//import io.netty.handler.codec.LineBasedFrameDecoder;
//import io.netty.handler.codec.string.StringDecoder;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//
//@Component
//public class NettyClient {
//    private static SocketChannel socketChannel;
//    static EventLoopGroup group = new NioEventLoopGroup();
//
//    public static void main(String[] args)throws Exception {
//        start();
//    }
//
//
//    public static void start() throws Exception {
//        //boss 线程组用于处理连接工作
//        try {
//            Bootstrap b = new Bootstrap();
//            b.group(group).channel(NioSocketChannel.class)
//                    .option(ChannelOption.TCP_NODELAY, true)
//                    .option(ChannelOption.SO_KEEPALIVE, true)
//                    .handler(new ChannelInitializer<SocketChannel>() {
//                        public void initChannel(SocketChannel ch) throws Exception {
//                            ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
//                            ch.pipeline().addLast(new StringDecoder());
//                            ch.pipeline().addLast(new ClientHandler());
//
//                        }
//                    });
//            //绑定端口
//            ChannelFuture cf = b.connect("127.0.0.1", 8888).sync();
//            if (cf.isSuccess()) {
//                System.out.println("链接服务器成功");
//            }
//            cf.channel().closeFuture().sync();
//        } finally {
//            group.shutdownGracefully();
//        }
//    }
//}
//
//@Component
//class ClientHandler extends ChannelHandlerAdapter {
//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        ByteBuf resp = null;
//        for (int i = 0; i < 100; i++) {
//            resp = Unpooled.copiedBuffer(("I love you" + System.getProperty("line.separator")).getBytes());
//            ctx.writeAndFlush(resp);
//        }
////        byte[] req = ("I love you"+System.getProperty("line.separator")).getBytes();
////        ByteBuf first = Unpooled.buffer(req.length);
////        first.writeBytes(req);
////        ctx.writeAndFlush(first).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
//
//    }
//
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
////        ByteBuf buf = (ByteBuf) msg;
////        byte[] req = new byte[buf.readableBytes()];
////        buf.readBytes(req);
////        String body = new String(req, "UTF-8");
//        String body = (String) msg;
//        System.out.println(body+" ");
////        if ("no".equals(body)) {
////            ByteBuf resp = Unpooled.copiedBuffer("不灰心不丧气，继续我爱你".getBytes());
////            ctx.writeAndFlush(resp).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
////        }
//    }
//}