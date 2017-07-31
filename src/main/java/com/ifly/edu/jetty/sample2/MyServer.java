package com.ifly.edu.jetty.sample2;

import org.eclipse.jetty.server.Connector;  
import org.eclipse.jetty.server.Server;  
import org.eclipse.jetty.server.nio.SelectChannelConnector;  
  
public class MyServer {  
    public static void main(String[] args) throws Exception {  
        Server server = new Server();  
  
        SelectChannelConnector connector1 = new SelectChannelConnector();  
        connector1.setPort(8080);  
  
        SelectChannelConnector connector2 = new SelectChannelConnector();  
        connector2.setPort(9090);  
  
        server.setConnectors(new Connector[] { connector1, connector2 });  
  
        server.setHandler(new HelloHandler());  
  
        server.start();  
        server.join();  
    }  
}  
