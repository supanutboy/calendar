package controller;

import java.text.SimpleDateFormat;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JTextArea;

import model.DailyMemo;
import model.DataBase;
import model.Memo;
import model.SubMemo;
import viewAndAction.GUIDate;
import viewAndAction.View;

public class Controller {
	Memo memo;
//	SubMemo subMemo;
	GUIDate gui;
	DataBase db;
	public void startApplication() {
		Date currentDate = new Date();
		memo = new Memo();
		gui =new GUIDate();
		db = new DataBase();
		gui.starFrame();
		db.StartDataBase(memo,gui);
		
	}

	public void addText(String subject,String textArea,String day,String month,String year) {//getDay Year Month  นำมาใส่เพื่อผันทึกค่า อย่าลืมคิดเคสที่เดือนวันปีเดียวกัน
		memo.addSub(new SubMemo(subject,textArea,day,month,year));
	}
	
	public void calledDate(String date) {
		System.out.println(date);
		//System.out.println(listDate[1]+"   "+listDate[2]+"   "+listDate[3]);
		String info=memo.getInfo(date);
	//	System.out.println(info);
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

	public void addDaily(String subject,String textArea,String day,String month,String year, String daily) {
		memo.addDaily(subject,textArea,day,month,year,daily);
		//System.out.println(subject+" "+textArea+" "+day+month+year+daily);
	}

	public void removeDaily(String string) {
		memo.removeDaily(string);
		
	}

	public void editDaily(String text, String daily) {
		memo.editDaily(text,daily);
	}

}
