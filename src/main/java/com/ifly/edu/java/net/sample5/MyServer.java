package com.ifly.edu.java.net.sample5;

/**
 * 使用加密协议传输对象 
 * 加密方式时，需要通过命令行产生keystore文件 命令如下：
 * keytool -genkey -alias mysocket -keyalg RSA -keystore mysocket.jks
 * 
 * 运行时vm参数设置：
 * -Djavax.net.ssl.keyStore=mysocket.jks -Djavax.net.ssl.keyStorePassword=mysocket
 * @author pangzhw
 * @date 2015年4月12日
 */
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocketFactory;

import com.ifly.edu.java.net.common.User;
  
public class MyServer {  
      
    private final static Logger logger = Logger.getLogger(MyServer.class.getName());  
      
    public static void main(String[] args) {  
        try {  
            ServerSocketFactory factory = SSLServerSocketFactory.getDefault();  
            ServerSocket server = factory.createServerSocket(10000);  
              
            while (true) {  
                Socket socket = server.accept();  
                invoke(socket);  
            }  
        } catch (Exception ex) {  
            ex.printStackTrace();  
        }  
    }  
      
    private static void invoke(final Socket socket) throws IOException {  
        new Thread(new Runnable() {  
            public void run() {  
                ObjectInputStream is = null;  
                ObjectOutputStream os = null;  
                try {  
                    is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));  
                    os = new ObjectOutputStream(socket.getOutputStream());  
  
                    Object obj = is.readObject();  
                    User user = (User)obj;  
                    System.out.println("user: " + user.getName() + "/" + user.getPassword());  
  
                    user.setName(user.getName() + "_new");  
                    user.setPassword(user.getPassword() + "_new");  
  
                    os.writeObject(user);  
                    os.flush();  
                } catch (IOException ex) {  
                    logger.log(Level.SEVERE, null, ex);  
                } catch(ClassNotFoundException ex) {  
                    logger.log(Level.SEVERE, null, ex);  
                } finally {  
                    try {  
                        is.close();  
                    } catch(Exception ex) {}  
                    try {  
                        os.close();  
                    } catch(Exception ex) {}  
                    try {  
                        socket.close();  
                    } catch(Exception ex) {}  
                }  
            }  
        }).start();  
    }  
} 