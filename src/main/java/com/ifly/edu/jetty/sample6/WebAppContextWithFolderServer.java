package com.ifly.edu.jetty.sample6;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class WebAppContextWithFolderServer {
    public static void main(String[] args) throws Exception {  
        Server server = new Server(8080);  
  
        WebAppContext context = new WebAppContext();  
        context.setContextPath("/myapp");  
        context.setDescriptor("I:/test/struts2-showcase/WEB-INF/web.xml");  
        context.setResourceBase("I:/test/struts2-showcase");  
        context.setParentLoaderPriority(true);  
        server.setHandler(context);  
  
        server.start();  
        server.join();  
    }  
}
