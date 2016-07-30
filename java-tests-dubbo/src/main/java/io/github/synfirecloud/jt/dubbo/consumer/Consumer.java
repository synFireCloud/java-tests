package io.github.synfirecloud.jt.dubbo.consumer;

import io.github.synfirecloud.jt.dubbo.core.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by synFireCloud on 7/11/16.
 */
public class Consumer {
	public static void main(String[] args){
		int len;
		byte[] buffer = new byte[1024];
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
			context.start();
			Test t = (Test) context.getBean("testService");
			do {
				len = System.in.read(buffer);
				int length = t.p(new String(buffer,0,len-1));
				System.out.println(length);
			}while (len>0);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
