package com.zcl.socket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * web .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-9-25 .
 */
public class SocketServer {

	public static void main(String[] args) throws IOException {
		int port = 55533;
		ServerSocket server = new ServerSocket(port);
		System.out.println("server将一直等待连接的到来");
		while (true) {
			Socket socket = server.accept();
			// 建立好连接后，在socket中获取输入流，并建立缓冲区进行读取
			InputStream inputStream = socket.getInputStream();
			byte[] buffer = new byte[1024];
			int len;
			StringBuilder sb = new StringBuilder();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			while ((len = inputStream.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
				sb.append(baos);
			}
			System.out.println("get message from client:" + sb);
			OutputStream outputStream = socket.getOutputStream();
			outputStream.write("Hello Client,I get the message.".getBytes(StandardCharsets.UTF_8));

			inputStream.close();
			outputStream.close();
			socket.close();
			server.close();
		}
	}
}
