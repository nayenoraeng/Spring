package com.study.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//검색된 클래스를 빈으로 등록할 떄, 클래스의 첫글자를 소문자로 바꾼
//Hello라는 이름을 빈의 이름으로 사용한다.
@Component
public class Hello {
	
	@Value("홍길동")
	private String name;
	@Value("전우치")
	private String nickname;
	//자동주입
	@Autowired
	//@Qualifier : 자동주입 가능한 빈이 두 개 이상일 때 특정한 한 개 지정하기
	//printerA 를 지정
	@Qualifier("printerA")
	private Printer printer;
	
	public Hello(){};

	public Hello(String name, String nickname, Printer printer)
	{
		super();
		this.name = name;
		this.nickname = nickname;
		this.printer = printer;
	}
	
//	public void setName(String name)
//	{
//		this.name = name;
//	}
//	public void setNickname(String nickname)
//	{
//		this.nickname = nickname;
//	}
	
	public void setPrinter(Printer printer)
	{
		this.printer = printer;
	}
	
	public String sayHello()
	{
		return "Hello " + name + " : " + nickname;
	}
	
	public void print()
	{
		printer.print(sayHello());
	}

}
