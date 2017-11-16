package kr.or.utradehub.portal.sys.mapper.external.unipass.impl;

import java.util.stream.IntStream;

public class test {
	public static void main(String[] args) {
		IntStream.range(0, 10).forEach((int value) -> System.out.println(value));
		
		IntStream.range(0, 10).forEach(value -> System.out.println(value));
		
		IntStream.range(0, 10).forEach(System.out::println);
	}
}
