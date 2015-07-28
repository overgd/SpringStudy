package sample2;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

public class MessageBeanImpl implements MessageBean {

	private String name;
	private String greeting;
	private Outputter outputter;

	public MessageBeanImpl(String name) {
		super();
		this.name = name;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public Outputter getOutputter() {
		return outputter;
	}

	@Autowired
	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}

	@Override
	public void sayHello() {

		String message = greeting + name + " ~";
		try {
			outputter.output(message);
		} catch (IOException ie) {
			ie.printStackTrace();
		}

	}

}
