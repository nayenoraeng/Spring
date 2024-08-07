package com.study.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloBeanTest {

	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(Config.class);
				
		//2. Hello Bean 가져오기. 스프링 컨테이너에서 컴포넌트 가져옴
		Hello helloA = (Hello)context.getBean("hello"); 
		helloA.print();
		
		Hello helloB = (Hello)context.getBean("hello1"); 
		helloB.print();
		
		//3. Printer B Bean 가져오기
		Printer printer = context.getBean("printerB", Printer.class);
		helloA.setPrinter(printer);
		helloA.print();
		
		System.out.println(helloA == helloB);
//		context.close();

	}

}
