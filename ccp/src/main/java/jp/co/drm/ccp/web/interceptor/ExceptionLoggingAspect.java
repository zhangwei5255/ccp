package jp.co.drm.ccp.web.interceptor;

import java.lang.reflect.InvocationTargetException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 例外ログ出力クラス
 * </p>
 */
@Aspect
@Component
public class ExceptionLoggingAspect {
	@Pointcut("execution(* jp.co.drm.ccp.web.presentation.controller.*.*(..))")
	public void controllerPointcut() {
	}

/*	@Before("controllerPointcut()")
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

	@AfterReturning(returning = "ret", pointcut = "controllerPointcut()")
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
		System.out.println("方法的返回值 : " + ret);
	}

	// 后置异常通知
	@AfterThrowing("controllerPointcut()")
	public void throwss(JoinPoint jp) {
		System.out.println("方法异常时执行.....");
	}

	// 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
	@After("controllerPointcut()")
	public void after(JoinPoint jp) {
		System.out.println("方法最后执行.....");
	}*/

	// 环绕通知,环绕增强，相当于MethodInterceptor
	@Around("controllerPointcut()")
	public Object arround(ProceedingJoinPoint pjp) throws Throwable {
		String clsNm = pjp.getSignature().getDeclaringTypeName();
		Logger logger = LogManager.getLogger(clsNm);

		try {
			Object ret = pjp.proceed();
			return ret;
		} catch (InvocationTargetException ex) {
			Throwable cause = ex.getCause();
			logger.error((Exception) cause);
			throw cause;
		} catch (Exception e) {
			// ログ出力
			logger.error(e);
			throw e;
		}


	}


}
