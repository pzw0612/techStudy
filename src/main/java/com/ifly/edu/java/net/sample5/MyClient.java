package com.ifly.edu.java.net.sample5;

/**
 *
 * @author pangzhw
 * @date 2015年4月12日
 */
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

import com.ifly.edu.java.net.common.User;
  
/**
 * 运行时，指定加密文件
 * -Djavax.net.ssl.trustStore=mysocket.jks  -Djavax.net.ssl.trustStorePassword=mysocket
*
* @author pangzhw
* @date 2015年4月12日
 */
public class MyClient {  
      
private final static Logger logger = Logger.getLogger(MyClient.class.getName());  
  
    public static void main(String[] args) throws Exception {  
        for (int i = 0; i < 100; i++) {  
            Socket socket = null;  
            ObjectOutputStream os = null;  
            ObjectInputStream is = null;  
              
            try {  
                SocketFactory factory = SSLSocketFactory.getDefault();  
                socket = factory.createSocket("localhost", 10000);  
      
                os = new ObjectOutputStream(socket.getOutputStream());  
                User user = new User("user_" + i, "password_" + i);  
                os.writeObject(user);  
                os.flush();  
                  
                is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));  
                Object obj = is.readObject();  
                if (obj != null) {  
                    user = (User)obj;  
                    System.out.println("user: " + user.getName() + "/" + user.getPassword());  
                }  
            } catch(IOException ex) {  
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
    }  
} 
