package com.study.spring;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.format.Printer;

public class HelloBeanTest {

	public static void main(String[] args)
	{
		//xml 설정 파일의 위치를 선언
		/*
			classpath 의 의미를 웹애플리케이션을 WAR로 배포했을 때 classes
		*/
		String configLocation = "classpath:beans.xml";
		
		//1. IoC 컨테이너 생성
		//XML 파일로부터 정보를 읽어와 객체를 생성하고 초기화
		ApplicationContext context =
					new GenericXmlApplicationContext(configLocation);
		
		//2. Hello Bean 가져오기
		//컨테이너에서 생성된 빈을 getBean () 메서드를 통해 주입(injection) 받는다.
		Hello hello = (Hello)context.getBean("hello");
		
		List<String> myList = hello.getNames();
		for (String value : myList) {
			System.out.println("List : " + value);
		}
		
		Set<Integer> mySet1 = hello.getNums();
		for (Integer value : mySet1) {
			System.out.println("Set : " + value);
		}
		
		Map<String, Integer> map = hello.getAges();
		
		//방법 01 : entrySet //추가한것
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Map1 : " + entry.getKey() + " - " + entry.getValue());
		}
		
		//방법 02 : KeySet 을 이용한 방법
		for(String key : map.keySet()) {
			Integer value = map.get(key);
			System.out.println("Map 2 : " + key + " - " + value);
		}
		
		//방법 03 : Iterator 을 이용한 방법
		Iterator<String> iterator = map.keySet().iterator();
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			Integer value = map.get(key);
			System.out.println("Map3 : " + key + " - " + value);
		}
	}

}
