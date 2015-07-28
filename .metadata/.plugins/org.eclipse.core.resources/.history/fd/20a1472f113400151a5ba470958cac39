package sample;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LoggingAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {

		String methodName = arg0.getMethod().getName();
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		System.out.println("호출된 메서드 이름 : " + methodName);
		Object rtnObj = arg0.proceed();
		sw.stop();
		System.out.println("소요시간 : " + sw.getTotalTimeMillis() / 1000 + "초");

		return rtnObj;
	}

}
