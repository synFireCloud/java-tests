package io.github.synfirecloud.jt.zip;

import com.sun.nio.zipfs.ZipDirectoryStream;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * Created by synFireCloud on 7/18/16.
 */
public class UnZip {
	public static void main(String[] args) throws IOException {
		int len;
		ZipEntry z;
		byte[] buffer = new byte[1024];
		FileInputStream fileInputStream = new FileInputStream("test.zip");
		NetTestInputStream netTestInputStream = new NetTestInputStream(fileInputStream,10240000);
		ZipInputStream zipInputStream = new ZipInputStream(netTestInputStream);
		while ((z=zipInputStream.getNextEntry())!=null){
			File f = new File("test"+File.pathSeparator+z.getName());
			System.out.printf("File:%s\n",z.getName());
			if(z.isDirectory()){
				f.mkdir();
			}else{
				FileOutputStream fileOutputStream = new FileOutputStream(f);
				while ((len=zipInputStream.read(buffer))>0){
					fileOutputStream.write(buffer,0,len);
				}
				fileOutputStream.flush();
				fileOutputStream.close();
			}
		}
	}
}
