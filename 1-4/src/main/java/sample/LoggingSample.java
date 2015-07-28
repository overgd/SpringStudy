package sample;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class LoggingSample {

	@Around("execution(* sayHello())")

	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {

		String methodName = pjp.getSignature().getName();
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		System.out.println("호출된 메서드 : " + methodName);
		
		Object runObj = pjp.proceed();
		sw.stop();
		System.out.println("소요된 시간" + sw.getTotalTimeMillis()/10000+"초");
		
		return null;

	}

}
