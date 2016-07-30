package io.github.synfirecloud.jt.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Stack;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by synFireCloud on 7/18/16.
 */
public class Zip {
	public static void main(String[] args) throws IOException {
		int len;
		byte[] buffer=new byte[1024];
		FileOutputStream fileOutputStream = new FileOutputStream("test.zip");
		ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
		File root = new File("test"+File.separator);
		List<File> files = FileSearch.search(root);
		for(File file:files){
			if(file.isFile()) {
				zipOutputStream.putNextEntry(new ZipEntry(file.getPath().substring(("test"+File.separator).length(),file.getPath().length())));
				FileInputStream fileInputStream = new FileInputStream(file);
				while ((len=fileInputStream.read(buffer))>0) {
					zipOutputStream.write(buffer,0,len);
				}
				fileInputStream.close();
			}
		}
		zipOutputStream.flush();
		zipOutputStream.close();
	}
}
