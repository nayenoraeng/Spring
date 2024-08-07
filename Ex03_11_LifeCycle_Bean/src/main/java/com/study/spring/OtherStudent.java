package com.study.spring;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class OtherStudent {

	private String name;
	private int age;
	
	public OtherStudent(String name, int age)
	{
		this.name = name;
		this.age = age;
	}

	public String getName()
	{
		return name;
	}

	public int getAge()
	{
		return age;
	}
	
	//어노테이션
	//의존관계 주입(DI)가 이루어진 후 초기화를 수행하여 객체의 값을 설정
	@PostConstruct
	public void initMethod()
	{
		System.out.println("OtherStudent : initMethod()");
	}
	
	@PreDestroy
	public void destroyMethod()
	{
		System.out.println("OtherStudent : destroyMethod()");
	}
	
}
