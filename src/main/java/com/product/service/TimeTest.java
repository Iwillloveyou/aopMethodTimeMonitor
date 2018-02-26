package com.product.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class TimeTest {
	
	public void testMethod(){
		System.out.println("执行方法");
	}
	
	public void testMethod2(){
		int sum = 0;
		for(int i=0;i<1000;i++){
			sum += i;
		}
		System.out.println(sum);
		System.out.println("执行方法2");
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext-aop.xml");

		TimeTest A = (TimeTest)ctx.getBean("timeTest");
		A.testMethod();
		//A.testMethod2();
	    ctx.destroy();
	}
	
}
