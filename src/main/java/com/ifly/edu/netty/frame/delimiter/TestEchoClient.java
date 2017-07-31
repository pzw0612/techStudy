package com.ifly.edu.netty.frame.delimiter;


import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class TestEchoClient {

	public void connect(String ip, int port) throws Exception{
		EventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
		try{
			Bootstrap bootstrap= new Bootstrap();
			bootstrap.group(nioEventLoopGroup).channel(NioSocketChannel.class)
			.option(ChannelOption.TCP_NODELAY, true)
			.handler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ByteBuf delimiter = Unpooled.copiedBuffer("$_".getBytes());
					ch.pipeline().addLast(new  DelimiterBasedFrameDecoder(1024, delimiter));
					ch.pipeline().addLast(new StringDecoder());
					ch.pipeline().addLast(new TestEchoClientHandler());
				}
			});
		    // 发起异步连接操作
		    ChannelFuture f = bootstrap.connect(ip, port).sync();
		    // 当代客户端链路关闭
		    f.channel().closeFuture().sync();
		    
		}finally{
			nioEventLoopGroup.shutdownGracefully();
		}
	}
	public static void main(String[] args) {
		try {
			new TestEchoClient().connect("localhost", 8080);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
