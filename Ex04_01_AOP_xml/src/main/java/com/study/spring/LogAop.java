package com.study.spring;

import org.aspectj.lang.ProceedingJoinPoint;

//공통 기능을 수행할 클래스 정의
public class LogAop {

	//beans.xml 에 등록된 표현식에 의해 Student 클래스 Worker 클래스가 조인포인트로
	//설정되었기 때문에 해당클래스의 모든 메서드는 포인트컷이 되었음.
	public Object loggerAop (ProceedingJoinPoint joinpoint) throws Throwable {
		/*
			현재 호출된 메서드명을 문자열
		*/
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(signatureStr + " is start.");
		
//		long st = System.currentTimeMillis();
		
		long st = System.nanoTime();
		
		try {
			Object obj = joinpoint.proceed();
			return obj;
		} finally {
//			long et = System.currentTimeMillis();
			long et = System.nanoTime();
			
			System.out.println( signatureStr + " is finished.");
			System.out.println( signatureStr + " 경과시간 : " + (et - st));
		}
		
		
	}
}
