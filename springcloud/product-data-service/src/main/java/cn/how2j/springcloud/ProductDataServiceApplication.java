package cn.how2j.springcloud;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.NetUtil;
import cn.hutool.core.util.NumberUtil;

@SpringBootApplication
@EnableEurekaClient
public class ProductDataServiceApplication {
    public static void main(String[] args) {
    	int port = 0;
    	int defaultPort = 8001;
    	Future<Integer> future = ThreadUtil.execAsync(() ->{
	        	int p = 0;
	        	System.out.println("请于5秒钟内输入端口号, 推荐  8001 、 8002  或者  8003，超过5秒将默认使用 " + defaultPort);
	        	Scanner scanner = new Scanner(System.in);
	            while(true) {
	                String strPort = scanner.nextLine(); 
	                if(!NumberUtil.isInteger(strPort)) {
	                	System.err.println("只能是数字");
	                	continue;
	                }
	                else {
	                	p = Convert.toInt(strPort);
	                	scanner.close();
	                	break;
	                }
	            }
	            return p;
		});
		try{
		    port=future.get(5,TimeUnit.SECONDS);
		}
		catch (InterruptedException | ExecutionException | TimeoutException e){
		    port = defaultPort;
		}
		
    	if(!NetUtil.isUsableLocalPort(port)) {
    		System.err.printf("端口%d被占用了，无法启动%n", port );
    		System.exit(1);
    	}
        
        new SpringApplicationBuilder(ProductDataServiceApplication.class).properties("server.port=" + port).run(args);
    }
}

