package com.ifly.edu.java.net.sample1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 单线程通信,一个客户端，一个服务端
*
* @author pangzhw
* @date 2015年4月12日
 */
public class MyServer {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(10000);
		Socket socket = server.accept();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream());

		while (true) {
			String msg = in.readLine();
			System.out.println(msg);
			out.println("Server received " + msg);
			out.flush();
			if (msg.equals("bye")) {
				break;
			}
		}
		socket.close();
	}
}
