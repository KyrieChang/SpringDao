package com.kyrie.common.datasource;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAspect{
	// @Order(-2147483648)
	@Pointcut("execution(* com.kyrie.service.*.*(..))")
	public void pointcut(){}

	/**
	 * 在进入Service方法之前执行
	 *
	 * @param point 切面对象
	 */
	@Before("pointcut()")
	public void before(JoinPoint point) {
		// 获取到当前执行的方法名
		String className = point.getTarget().getClass().getName();
		String method = point.getSignature().getName();
		try {
			for (String key : DynamicDataSource.METHODTYPE.keySet()) {
				for (String type : DynamicDataSource.METHODTYPE.get(key)) {
					if (method.startsWith(type)) {
						System.out.println("类  "+ className +"============="+ method +"===========方法： "+ key +" 库");
						DynamicDataSourceHolder.putDataSourceKey(key);
						break ;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterReturning("pointcut()")
	public void after(){
		DynamicDataSourceHolder.remove();
	}
}