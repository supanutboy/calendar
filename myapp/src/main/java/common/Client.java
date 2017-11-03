package common;

import java.util.ArrayList;

import model.SubMemo;
import viewAndAction.GUIDate;

public class Client   {
	CalenderService manager;
	GUIDate gui;
	public Client(CalenderService manager) {
		 gui =new GUIDate(this);
		this.manager= manager;
		setGUI();
	}
	
	public void setGUI() {
		ArrayList<SubMemo>list = (ArrayList<SubMemo>) manager.setGUI();
	
		for (SubMemo sub :list) {
			gui.getComboBoxDate().addItem("Subject:"+sub.getSubject()+"->"+sub.getYear()+"-"+sub.getMonth()+"-"+sub.getDay()+"");
	}
	}

	public void addText(String subject, String textArea, String day, String month, String year) {
		manager.addText(subject, textArea, day, month, year);
	}

	public void addText(String subject, String textArea, String day, String month, String year, String daily,
			String form) {
		manager.addText(subject,textArea,day,month,year,daily,form);		
	}

	public void calledDate(String date) {
		String info=manager.calledDate(date);
		gui.showDate(info);		
	}

	public void calledDaily(String date) {
		String info=manager.calledDaily(date);
		gui.showDateDaily(info);
	}

	public void setDate(String date, String infoText) {
		String info = manager.setDate(date, infoText);
		gui.showDate(info);		
	}

	public void removeDate(String date) {
		manager.removeDate(date);
		gui.showDate(date+" <==== This date has been deleted");
		gui.deleteComboBoxDate(date);		
	}

	public void removeDaily(String string) {
		manager.removeDaily(string);
		gui.showDateDaily(string+" <==== This date has been deleted");
	}

	public void editDaily(String text, String daily) {
		// TODO Auto-generated method stub
		manager.editDaily(text, daily);	
	}

	public void calledDailyArea(String dayButton, ArrayList<String> listSun, ArrayList<String> listMon,
			ArrayList<String> listTue, ArrayList<String> listWed, ArrayList<String> listThu, ArrayList<String> listFri,
			ArrayList<String> listSat) {
		String str=manager.calledDailyArea(dayButton,listSun,listMon,listTue,listWed,listThu,listFri,listSat);
		gui.showDateDailyArea(str);
	}
	

}
