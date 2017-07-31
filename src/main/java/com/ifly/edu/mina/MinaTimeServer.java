package com.ifly.edu.mina;

/**
 *
 * @author pangzhw
 * @date 2015年4月12日
 */
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
    
public class MinaTimeServer   
{   
    /** We will use a port above 1024 to be able to launch the server with a standard user */
    private static final int PORT = 9123;

    /**
     * The server implementation. It's based on TCP, and uses a logging filter 
     * plus a text line decoder.
     */
    public static void main(String[] args) throws IOException {
        // Create the acceptor
        IoAcceptor acceptor = new NioSocketAcceptor();
        
        // Add two filters : a logger and a codec
        acceptor.getFilterChain().addLast( "logger", new LoggingFilter() );
        acceptor.getFilterChain().addLast( "codec", new ProtocolCodecFilter( new TextLineCodecFactory( Charset.forName( "UTF-8" ))));
   
        // Attach the business logic to the server
        acceptor.setHandler( new TimeServerHandler() );

        // Configurate the buffer size and the iddle time
        acceptor.getSessionConfig().setReadBufferSize( 2048 );
        acceptor.getSessionConfig().setIdleTime( IdleStatus.BOTH_IDLE, 10 );
        
        // And bind !
        acceptor.bind( new InetSocketAddress(PORT) );
    }  
} 
