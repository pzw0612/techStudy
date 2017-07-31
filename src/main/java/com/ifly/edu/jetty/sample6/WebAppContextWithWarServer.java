package com.ifly.edu.jetty.sample6;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class WebAppContextWithWarServer {
   public static void main(String[] args) throws Exception {
       Server server = new Server(8080);

       WebAppContext context = new WebAppContext();
       context.setContextPath("/myapp");
//       context.setWar("E:\\work\\irecom\\sse\\temp\\source\\webfont.war");
       context.setWar("F:\\opensouce\\struts2\\struts-2.3.16.3\\apps\\struts2-blank.war");
       server.setHandler(context);

       server.start();
       server.join();
   }
} 
