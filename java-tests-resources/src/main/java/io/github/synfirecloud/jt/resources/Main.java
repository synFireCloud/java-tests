package io.github.synfirecloud.jt.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

/**
 * Created by synFireCloud on 7/16/16.
 */
@SpringBootApplication
public class Main implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(Main.class);

	@Autowired
	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(Main.class,args);
	}

	@Override
	public void run(String... strings) throws Exception {
		byte[] buffer = new byte[1024];
		Resource r = applicationContext.getResource("r.conf");
		int len = r.getInputStream().read(buffer);
		logger.info(new String(buffer,0,len));
	}
}
