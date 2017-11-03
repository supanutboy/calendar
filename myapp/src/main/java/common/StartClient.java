package common;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import controller.Controller;
import model.SubMemo;
import viewAndAction.GUIDate;

public class StartClient {
	GUIDate gui;
	public static void main(String[] args) throws Exception {

		ApplicationContext bf =new ClassPathXmlApplicationContext("client.xml");
		CalenderService manager = (CalenderService) bf.getBean("calender");
		
		Client client = new Client(manager);
		//Controller control = new Controller();
		//control.startApplication(manager);
		}
	

}
