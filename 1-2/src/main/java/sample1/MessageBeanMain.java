package sample1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageBeanMain {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("sample1/beans.xml");
		MessageBean bean = (MessageBean) ctx.getBean("messageBean");
		bean.sayHello();
	}

}
