package model;

public class SubMemo {
	private static String subject;
	private static String info;
	private static String day;
	private static String month;
	private static String year;
	public SubMemo(String subject,String info,String day,String month,String year) {
		this.setSubject(subject);
		this.setDay(day);
		this.setMonth(month);
		this.setYear(year);
		this.setInfo(info);
	}
	public static String getSubject() {
		return subject;
	}
	void setSubject(String subject) {
		this.subject = subject;
	}
	public static String getInfo() {
		return info;
	}
	void setInfo(String info) {
		this.info = info;
	}
	public static String getDay() {
		return day;
	}
	void setDay(String day) {
		this.day = day;
	}
	public static String getMonth() {
		return month;
	}
	void setMonth(String month) {
		this.month = month;
	}
	public static String getYear() {
		return year;
	}
	void setYear(String year) {
		this.year = year;
	}
}
