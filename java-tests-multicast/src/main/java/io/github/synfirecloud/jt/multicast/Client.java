package io.github.synfirecloud.jt.multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Created by synFireCloud on 7/11/16.
 */
public class Client {
	public static void main(String[] args){
		try {
			InetAddress group = InetAddress.getByName("FF01::FC01");
			MulticastSocket s = new MulticastSocket(10240);
			s.joinGroup(group);
			byte[] buffer = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buffer,buffer.length);
			do {
				s.receive(dp);
				System.out.print(dp.getAddress()+":"+new String(dp.getData(),dp.getOffset(),dp.getLength()));
			}while (dp.getLength()>0);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
