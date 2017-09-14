package model;

import java.util.ArrayList;

public class DailyMemo {

	private  String subject;
	private  String info;
	private  String day;
	private  String month;
	private  String year;
	private String  daily;
//	private ArrayList<String> list = new ArrayList<String>();
//	private ArrayList<String> listMonthly = new ArrayList<String>();
//	private ArrayList<String> listWeekly = new ArrayList<String>();
	public DailyMemo(String subject,String info,String day,String month,String year,String daily) {
		this.setSubject(subject);
		this.setDay(day);
		this.setMonth(month);
		this.setYear(year);
		this.setInfo(info);
		this.setDaily(daily);
	}
	public void newSet(String subject, String info, String day, String month, String year, String daily) {
		this.subject=subject;
		this.info=info;
		this.day=day;
		this.month=month;
		this.year=year;
		this.setDaily(daily);	
	}
	
	public  String getSubject() {
		return subject;
	}
	void setSubject(String subject) {
		this.subject = subject;
	}
	public  String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public  String getDay() {
		return day;
	}
	void setDay(String day) {
		this.day = day;
	}
	public  String getMonth() {
		return month;
	}
	void setMonth(String month) {
		this.month = month;
	}
	public  String getYear() {
		return year;
	}
	void setYear(String year) {
		this.year = year;
	}
	private String getDaily() {
		return daily;
	}
	private void setDaily(String daily) {
		this.daily = daily;
	}
	
}
