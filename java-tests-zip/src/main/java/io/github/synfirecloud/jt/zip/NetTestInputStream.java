package io.github.synfirecloud.jt.zip;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by synFireCloud on 7/18/16.
 */
public class NetTestInputStream extends InputStream {
	private InputStream inputStream;
	private long dateStamp;
	private int secSpeed;
	private int secPoint;
	public NetTestInputStream(InputStream inputStream,int secSpeed){
		this.inputStream = inputStream;
		this.secSpeed = secSpeed;
		this.secPoint = 0;
		this.dateStamp = System.currentTimeMillis();
	}

	@Override
	public int read() throws IOException {
		secPoint++;
		if(secPoint>secSpeed){
			long d = dateStamp+1000l-System.currentTimeMillis();
			if(d>0){
				try {
					Thread.sleep(d);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			secPoint = 0;
			dateStamp = System.currentTimeMillis();
		}
		return inputStream.read();
	}
}
