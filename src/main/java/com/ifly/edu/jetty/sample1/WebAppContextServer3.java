package com.ifly.edu.jetty.sample1;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

public class WebAppContextServer3 {

    public static void main(String[] args) throws Exception { 
    	
        Server server = new Server();  
        QueuedThreadPool threadPool = new QueuedThreadPool();  
        threadPool.setMinThreads(10);  
        threadPool.setMaxThreads(500);  
        server.setThreadPool(threadPool);  
             
        SelectChannelConnector connector = new SelectChannelConnector();  
        connector.setPort(8080);  
        //每个请求被accept前允许等待的连接数  
        connector.setAcceptQueueSize(50);  
        //同事监听read事件的线程数  
        connector.setAcceptors(2);  
        //连接最大空闲时间，默认是200000，-1表示一直连接  
        connector.setMaxIdleTime(3000);  
             
        server.addConnector(connector);  
        server.setHandler(new HelloHandler());  
        server.start();  
        server.join();  
        
   }  
}
