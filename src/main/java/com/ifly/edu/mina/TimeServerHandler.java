package com.ifly.edu.mina;

/**
 *
 * @author pangzhw
 * @date 2015年4月12日
 */

import java.util.Date;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 * The Time Server handler : it return the current date when a message is received,
 * or close the session if the "quit" message is received.
 * 
 * @author <a href="http://mina.apache.org">Apache MINA Project</a>
 */
public class TimeServerHandler extends IoHandlerAdapter
{
    /**
     * Trap exceptions.
     */
    @Override
    public void exceptionCaught( IoSession session, Throwable cause ) throws Exception
    {
        cause.printStackTrace();
    }

    /**
     * If the message is 'quit', we exit by closing the session. Otherwise,
     * we return the current date.
     */
    @Override
    public void messageReceived( IoSession session, Object message ) throws Exception
    {
        String str = message.toString();
        
        if( str.trim().equalsIgnoreCase("quit") ) {
            // "Quit" ? let's get out ...
            session.close(true);
            return;
        }

        // Send the current date back to the client
        Date date = new Date();
        session.write( date.toString() );
        System.out.println("Message written...");
    }

    /**
     * On idle, we just write a message on the console
     */
    @Override
    public void sessionIdle( IoSession session, IdleStatus status ) throws Exception
    {
        System.out.println( "IDLE " + session.getIdleCount( status ));
    }
} 
