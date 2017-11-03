package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JTextArea;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import common.CalenderService;
import model.DailyMemo;
import model.DataBase;
import model.Memo;
import model.SubMemo;
import viewAndAction.GUIDate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Controller implements CalenderService {
	private  Memo memo ;
	private GUIDate gui;
	private DataBase db;
	public Controller() {
		//db = new DataBase();
		//gui =new GUIDate(this);
		ApplicationContext bfDB =new ClassPathXmlApplicationContext("database.xml");
		db = (DataBase) bfDB.getBean("database");
		this.memo = new Memo(db);
		db.StartDataBase(memo);
		setMemo();
		System.out.println("Server Strand by");
		
		//setGUI();
	}
	public void setMemo() {
		try {
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:Supanut.db";
			Connection conn =DriverManager.getConnection(dbURL);
			if(conn !=  null) {
				String query ="Select * from EventCalender";
				Statement state = conn.createStatement();
				ResultSet result = state.executeQuery(query);
				while(result.next()) {
					String form =result.getString(6)+"";
					if (form.equals("null")) {
					this.memo.getListDate().add(new SubMemo(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5)));
					}else {
					this.memo.chngeDaily(new DailyMemo(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6)),result.getString(6));
					}
				}
				}
		}
		catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}	
	}
	public ArrayList<SubMemo> setGUI() {
//		for (SubMemo sub :memo.getListDate()) {
//				gui.getComboBoxDate().addItem("Subject:"+sub.getSubject()+"->"+sub.getYear()+"-"+sub.getMonth()+"-"+sub.getDay()+"");
//		}
		
		return memo.getListDate();
		
		
	}
	public void addText(String subject,String textArea,String day,String month,String year) {//getDay Year Month  นำมาใส่เพื่อผันทึกค่า อย่าลืมคิดเคสที่เดือนวันปีเดียวกัน
		SubMemo submemo= new SubMemo(subject,textArea,day,month,year);
		memo.addMemo(submemo);
	}
	public void addText(String subject,String textArea,String day,String month,String year, String daily,String form) {
		memo.addMemo(subject,textArea,day,month,year,daily,form);
	}
	public String calledDate(String date) {
		return memo.getInfo(date);
	}
	public String calledDaily(String date) {
		return memo.showInfoDaily(date);
	}
	public String setDate(String date,String infoText ) {
		memo.setInfo(date, infoText);
		return memo.getInfo(date);

	}
	public void removeDate(String date) {
		memo.removeMemo(date);
	}

	public void removeDaily(String string) {
		memo.removeDaily(string);
	}

	public void editDaily(String text, String daily) {
		memo.editDaily(text,daily);
	}
	public String calledDailyArea(String dayButton, ArrayList<String> listSun, ArrayList<String> listMon,
			ArrayList<String> listTue, ArrayList<String> listWed, ArrayList<String> listThu, ArrayList<String> listFri,
			ArrayList<String> listSat) {
		return memo.getinfoDaily(dayButton,listSun,listMon,listTue,listWed,listThu,listFri,listSat);
		
	}

}
