package model;

public class SubMemo {
	private  String subject;
	private  String info;
	private  String day;
	private  String month;
	private  String year;
	public SubMemo(String subject,String info,String day,String month,String year) {
		this.setSubject(subject);
		this.setDay(day);
		this.setMonth(month);
		this.setYear(year);
		this.setInfo(info);
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
}
