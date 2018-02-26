package com.product.test.aopTest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodTimeMonitor {
			  	
	private long startTime; 
	
    //声明切面类路径，类型必须为final String类型的,注解里要使用的变量只能是静态常量类型的
    //public static final String POINT = "execution(* com.product.service.*.*(..))";
    //也可以使用注解声明切入点,如下
    @Pointcut("execution(* com.product.service.*.*(..))")
    public void point(){}
    
//    @Before("point()")
//    public void doBefore(){
//    	this.startTime = System.currentTimeMillis();
//    }
    
    @Around("point()")
	public Object doAround(ProceedingJoinPoint pjp){
		long startTime = System.currentTimeMillis();  
		Object obj = null;
		try {
			obj = pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		long endTime = System.currentTimeMillis();
		
		MethodSignature signature = (MethodSignature) pjp.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();
        System.out.println(methodName+"方法执行了"+(endTime-startTime)+"ms");
    	return obj;
	}
    
//    @After("point()")
//    public void doAfter(){
//    	long endTime = System.currentTimeMillis();
//    	System.out.println("方法执行了"+(endTime-this.startTime)+"ms");
//    }
    
    
}
