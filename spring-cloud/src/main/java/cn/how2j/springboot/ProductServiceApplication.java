package cn.how2j.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import cn.hutool.core.util.NetUtil;

@SpringBootApplication
public class ProductServiceApplication {
	public static void main(String[] args) {
    	int port = 8080;
		if(!NetUtil.isUsableLocalPort(port)) {
			System.err.printf("端口%d被占用了，无法启动%n", port );
    		System.exit(1);
    	}
        new SpringApplicationBuilder(ProductServiceApplication.class).properties("server.port=" + port).run(args);
	}
}
