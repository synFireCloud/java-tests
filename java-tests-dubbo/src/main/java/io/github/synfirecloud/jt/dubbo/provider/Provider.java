package io.github.synfirecloud.jt.dubbo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by synFireCloud on 7/11/16.
 */
public class Provider {
	public static void main(String[] args){
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
			context.start();
			System.in.read();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
