package demo.active.active_revice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class active_test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/app-receive.xml");
		System.out.println("消费者C====>");
	}
}
