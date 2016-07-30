package io.github.synfirecloud.jt.zip;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by synFireCloud on 7/18/16.
 */
public class FileSearch {
	public static List<File> search(File root){
		Stack<File> fileHeap = new Stack<File>();
		List<File> files = new ArrayList<File>();
		File temp;
		fileHeap.push(root);
		while(!fileHeap.isEmpty()){
			temp=fileHeap.pop();
			files.add(temp);
			File[] temps = temp.listFiles();
			if(temps!=null) {
				for (File f : temps) {
					if (f.isDirectory()) {
						fileHeap.push(f);
					} else {
						files.add(f);
					}
				}
			}
		}
		return files;
	}
}
