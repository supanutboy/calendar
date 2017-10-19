package model;

import java.util.ArrayList;

public class DailyMemo extends ReminderMemo {

	private  String subject;
	private  String info;
	private  String day;
	private  String month;
	private  String year;
	private String  daily;
	public DailyMemo(String subject,String info,String day,String month,String year,String daily) {
		super(subject,info,day,month,year);
		this.daily=daily;
	}
	public void newSet(String subject, String info, String day, String month, String year, String daily) {
		this.subject=subject;
		this.info=info;
		this.day=day;
		this.month=month;
		this.year=year;
		this.setDaily(daily);	
	}

	public String getDaily() {
		return daily;
	}
	private void setDaily(String daily) {
		this.daily = daily;
	}
	
}
