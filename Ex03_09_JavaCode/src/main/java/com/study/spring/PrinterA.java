package com.study.spring;

import org.springframework.stereotype.Component;

@Component("printerA") // 이 이름으로 bean에 등록하겠다 (빈으로 등록할 땐 앞에가 소문자)
public class PrinterA implements Printer{
	
	@Override
	public void print(String message)
	{
		System.out.println("Printer A : " + message);
	}

}
