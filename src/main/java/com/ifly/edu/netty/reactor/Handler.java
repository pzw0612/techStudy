package com.ifly.edu.netty.reactor;



import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @author yihua.huang@dianping.com
 */
public class Handler implements Runnable {

    //todo:init of socket
	final SocketChannel socket = SocketChannel.open();

	final SelectionKey sk;

	Handler(Selector sel) throws IOException {
		
        //注册handler到Selector
        socket.configureBlocking(false);
		sk = socket.register(sel, 0);
		sk.attach(this);
		sk.interestOps(SelectionKey.OP_READ);
		
		boolean connected = socket.connect(new InetSocketAddress("localhost",111));
		
		sel.wakeup();
	}

    @Override
    public void run() {
        System.out.println("reactor study");
    }
}
