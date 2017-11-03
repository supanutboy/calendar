package common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import controller.Controller;

public class StartServer {
	public static void main(String[] args) throws Exception {
		ApplicationContext bf = new ClassPathXmlApplicationContext("server.xml");
		System.out.println("Server Start");
//		Controller control = new Controller();
//		control.startApplication();
		}
}
