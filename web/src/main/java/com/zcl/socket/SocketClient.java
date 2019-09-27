package com.zcl.socket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * web .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-9-25 .
 */
public class SocketClient {
	public static void main(String[] args) throws IOException {
		// 要连接的服务端ip地址和端口
		String host = "127.0.0.1";
		int port = 55533;
		// 与服务端建立连接
		Socket socket = new Socket(host, port);
		// 建立好连接后获取输出流
		OutputStream outputStream = socket.getOutputStream();
		String message = "dsadasdf";
		socket.getOutputStream().write(message.getBytes("UTF-8"));
		socket.shutdownOutput();
		InputStream inputStream = socket.getInputStream();
		byte[] bytes = new byte[1024];
		int len;
		StringBuilder sb = new StringBuilder();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		while ((len = inputStream.read(bytes)) != -1) {
			baos.write(bytes, 0, len);
			sb.append(baos);
		}
		System.out.println("get message from sever:" + sb);

		inputStream.close();
		outputStream.close();
		socket.close();
	}
}
