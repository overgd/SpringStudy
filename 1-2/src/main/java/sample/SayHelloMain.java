package sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SayHelloMain {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("sample/beans.xml");
		// 스프링 환경설정을 불러오는 객체
		
		MessageBean mb = (MessageBean) ctx.getBean("MessageBeanKr");  //ID로
		mb.sayHello("홍길동");
		mb = (MessageBean) ctx.getBean("MessageBeanEn");
		mb.sayHello("홍길동");
		
		mb = (MessageBean) ctx.getBean("a"); //Name으로
		mb.sayHello("가길동");
		mb = (MessageBean)ctx.getBean("a1");
		mb.sayHello("가길동");
	}

}
