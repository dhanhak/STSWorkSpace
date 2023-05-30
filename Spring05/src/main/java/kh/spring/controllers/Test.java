package kh.spring.controllers;

import com.google.common.collect.EvictingQueue;

public class Test {
	public static void main(String[] args) {
		
		EvictingQueue<String> list = EvictingQueue.create(100);
		// 사이즈에 제한을 줄 수 있다.

		list.add("Orange");
		list.add("Banana");
		list.add("Apple");
		list.add("Mango");
		
		System.out.println(list);
		
	}

}
