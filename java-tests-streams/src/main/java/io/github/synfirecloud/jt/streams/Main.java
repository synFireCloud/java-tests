package io.github.synfirecloud.jt.streams;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by synFireCloud on 7/7/16.
 */
public class Main {
	public static final int TEST_SET_SIZE=2000000;

	public static void random(List<Long> list,int size){
		Random random = new Random(System.currentTimeMillis());
		for(int i=0;i<size;++i){
			list.add(random.nextLong());
		}
	}

	public static void main(String[] args){
		long startTime = System.currentTimeMillis();
		List<Long> tests = new ArrayList<>();
		long newTestsTime = System.currentTimeMillis();
		random(tests,TEST_SET_SIZE);
		long randomTime = System.currentTimeMillis();
		long sortedSize = tests.parallelStream().sorted().count();
		long sortedTime = System.currentTimeMillis();
		System.out.printf("newTests:%d,random:%d,sorted:%d,sortedSize:%d",newTestsTime-startTime,randomTime-newTestsTime,sortedTime-randomTime,sortedSize);
	}
}
