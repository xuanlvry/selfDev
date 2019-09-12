package com.sun.dev.netty3;

import org.jboss.netty.channel.*;

/**
 * Created by sunchengfei on 2019/3/6.
 */
public class ClientHandler extends SimpleChannelHandler {
    // 接收消息
    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
            throws Exception {
        // 接收消息
        String s = (String) e.getMessage();
        System.out.println(s);
        super.messageReceived(ctx, e);
    }

    // 捕获异常
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e)
            throws Exception {
        System.out.println("exceptionCaught");
        super.exceptionCaught(ctx, e);
    }

    // 新连接
    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e)
            throws Exception {
        System.out.println("channelConnected");
        super.channelConnected(ctx, e);
    }

    // 必须【连接已经建立】，关闭通道的时候才会触发
    @Override
    public void channelDisconnected(ChannelHandlerContext ctx,
                                    ChannelStateEvent e) throws Exception {
        System.out.println("channelDisconnected");
        super.channelDisconnected(ctx, e);
    }

    // channel关闭的时候触发（比如服务端没有启动，客户端发起连接的话，就会报这个错）
    @Override
    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e)
            throws Exception {
        System.out.println("channelClosed");
        super.channelClosed(ctx, e);
    }
}
