package sample;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class MessageBeanMain {

	public static void main(String[] args) {

		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("beans.xml"));
		
		MessageBean mb = (MessageBean)factory.getBean("proxy");
		mb.sayHello();
		
	}

}
