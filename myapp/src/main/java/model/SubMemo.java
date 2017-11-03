package model;

import java.io.Serializable;

public class SubMemo extends ReminderMemo  {
	private  String subject;
	private  String info;
	private  String day;
	private  String month;
	private  String year;
	public SubMemo(String subject, String info, String day, String month, String year) {
		super(subject, info, day, month, year);
	}
	
}
