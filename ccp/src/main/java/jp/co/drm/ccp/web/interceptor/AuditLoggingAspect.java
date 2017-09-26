package jp.co.drm.ccp.web.interceptor;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * <p>
 * このクラスは、監査ログを出力するクラスです。 サービスクラスのメソッドの開始・終了のタイミングで出力され、
 * 処理名、実行するメソッド名、メソッドの開始・終了の情報を規定します。
 * この情報に加えて実行ユーザ名、セッションIDがlog4j2によってログに出力されます。
 * </p>
 */
@Aspect
@Component
public class AuditLoggingAspect {
	@Pointcut("execution(* jp.co.drm.ccp.web.biz.service.*.*(..))")
	public void servicePointcut() {
	}

	@Before("servicePointcut()")
	public void deBefore(JoinPoint joinPoint) throws Throwable {
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		// 记录下请求内容
		System.out.println("URL : " + request.getRequestURL().toString());
		System.out.println("HTTP_METHOD : " + request.getMethod());
		System.out.println("IP : " + request.getRemoteAddr());
		System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName());
		System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));

	}

	@AfterReturning(returning = "ret", pointcut = "servicePointcut()")
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
		System.out.println("方法的返回值 : " + ret);
	}

	// 后置异常通知
	@AfterThrowing("servicePointcut()")
	public void throwss(JoinPoint jp) {
		System.out.println("方法异常时执行.....");
	}

	// 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
	@After("servicePointcut()")
	public void after(JoinPoint jp) {
		System.out.println("方法最后执行.....");
	}
//
//	// 环绕通知,环绕增强，相当于MethodInterceptor
//	@Around("servicePointcut()")
//	public Object arround(JoinPoint jp, ProceedingJoinPoint pjp) throws Throwable {
//
//		beforeArround(jp);
//
//		Object ret = pjp.proceed();
//		afterArround(jp);
//
//		return ret;
//
//	}

	private void beforeArround(JoinPoint jp)  {
		String clsNm = jp.getSignature().getDeclaringTypeName();
		String mdNm = clsNm + "." + jp.getSignature().getName();

		Logger logger = LogManager.getLogger(clsNm);
		logger.info("method: "+mdNm+" is called  "+ " with args "+Arrays.toString(jp.getArgs())+ "start");

	}

	private void afterArround(JoinPoint jp) {
		String clsNm = jp.getSignature().getDeclaringTypeName();
		String mdNm = clsNm + "." + jp.getSignature().getName();

		Logger logger = LogManager.getLogger(clsNm);
		logger.info("method: "+mdNm+" is called  "+ " with args "+Arrays.toString(jp.getArgs())+ "end");

	}



}
