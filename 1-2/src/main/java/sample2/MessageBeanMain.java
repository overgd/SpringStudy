package sample2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageBeanMain {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("sample2/beans.xml");
		MessageBean mb = (MessageBean) ctx.getBean("messageBean");
		mb.sayHello();
	}

}
