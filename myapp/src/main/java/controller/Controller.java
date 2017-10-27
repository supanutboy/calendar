package controller;

import java.text.SimpleDateFormat;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JTextArea;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import model.DailyMemo;
import model.DataBase;
import model.Memo;
import model.SubMemo;
import viewAndAction.GUIDate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Controller {
	private  Memo memo ;
	private GUIDate gui;
	private DataBase db;
	public void startApplication() {
		gui =new GUIDate(this);
		//db = new DataBase();
		ApplicationContext bf =new ClassPathXmlApplicationContext("database.xml");
		db = (DataBase) bf.getBean("database");
		this.memo = new Memo(db);	
	//	gui.starFrame();
		db.StartDataBase(memo);
		setGUI();
	}
	public void setGUI() {
		for (SubMemo sub :memo.getListDate()) {
				gui.getComboBoxDate().addItem("Subject:"+sub.getSubject()+"->"+sub.getYear()+"-"+sub.getMonth()+"-"+sub.getDay()+"");
		}
	}
	public void addText(String subject,String textArea,String day,String month,String year) {//getDay Year Month  นำมาใส่เพื่อผันทึกค่า อย่าลืมคิดเคสที่เดือนวันปีเดียวกัน
		SubMemo submemo= new SubMemo(subject,textArea,day,month,year);
		memo.addMemo(submemo);
	}
	public void addText(String subject,String textArea,String day,String month,String year, String daily,String form) {
		memo.addMemo(subject,textArea,day,month,year,daily,form);
	}
	public void calledDate(String date) {
		String info=memo.getInfo(date);
		gui.showDate(info);
	}
	public void calledDaily(String date) {
		String info=memo.showInfoDaily(date);
		gui.showDateDaily(info);
	}
	public void setDate(String date,String infoText ) {
		memo.setInfo(date, infoText);
		String info=memo.getInfo(date);
		gui.showDate(info);
	}
	public void removeDate(String date) {
		memo.removeMemo(date);
		gui.showDate(date+" <==== This date has been deleted");
		gui.deleteComboBoxDate(date);
	}

	public void removeDaily(String string) {
		memo.removeDaily(string);
	}

	public void editDaily(String text, String daily) {
		memo.editDaily(text,daily);
	}
	public void calledDailyArea(String dayButton, ArrayList<String> listSun, ArrayList<String> listMon,
			ArrayList<String> listTue, ArrayList<String> listWed, ArrayList<String> listThu, ArrayList<String> listFri,
			ArrayList<String> listSat) {
		String str=memo.getinfoDaily(dayButton,listSun,listMon,listTue,listWed,listThu,listFri,listSat);
		gui.showDateDailyArea(str);
		
	}

}
