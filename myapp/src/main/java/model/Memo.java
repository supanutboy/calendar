package model;

import java.util.ArrayList;


public class Memo {
	private  ArrayList<SubMemo> list;
	private  DailyMemo dailyDay    ;
	private  DailyMemo dailyMonth ;
	private  DailyMemo dailyWeek ;
	private DataBase db;
	int checkDB=0;
	public   Memo(DataBase db) {
		list= new ArrayList<SubMemo>();
		this.db = db;
	}
	public  void addMemo(SubMemo subMemo) {
		list.add(subMemo);
		String str ="'"+subMemo.getSubject()+"','"+subMemo.getInfo()+"','"+subMemo.getDay()+"','"+subMemo.getMonth()+"','"+subMemo.getYear()+"'";
		db.insertToDB(str);
	}
	public  void addMemo(String subject,String info,String day,String month,String year,String daily,String form) {
		String str  = "";
		if (daily.equals("Daily")) {
			dailyDay  = new DailyMemo(subject,info,day,month,year,daily);
			str ="'"+dailyDay.getSubject()+"','"+dailyDay.getInfo()+"','"+dailyDay.getDay()+"','"+dailyDay.getMonth()+"','"+dailyDay.getYear()+"','Daily'";
		}
		else if (daily.equals("Weekly")) {
			dailyWeek = new DailyMemo(subject,info,day,month,year,daily);
			str ="'"+dailyWeek.getSubject()+"','"+dailyWeek.getInfo()+"','"+dailyWeek.getDay()+"','"+dailyWeek.getMonth()+"','"+dailyWeek.getYear()+"','Weekly"+form+"'";

		}
		else if (daily.equals("Monthly")) {
			dailyMonth = new DailyMemo(subject,info,day,month,year,daily);
			str ="'"+dailyMonth.getSubject()+"','"+dailyMonth.getInfo()+"','"+dailyMonth.getDay()+"','"+dailyMonth.getMonth()+"','"+dailyMonth.getYear()+"','Monthly"+form+"'";
		}
		db.insertDailyDataBase(str,daily);
	}
	public  String getInfo(String date) {
		for (SubMemo subMemo:list) {
			String str = subMemo.getYear()+"-"+subMemo.getMonth()+"-"+subMemo.getDay();		
			if (str.equals(date)) {
				if (!dailyDay.getInfo().equals(null)) {
				return subMemo.getInfo();
				}
			}
		}
		return "---Empty---";	
	}
	public String getinfoDaily(String dayButton, ArrayList<String> listSun, ArrayList<String> listMon,
			ArrayList<String> listTue, ArrayList<String> listWed, ArrayList<String> listThu, ArrayList<String> listFri,
			ArrayList<String> listSat) {
		String str ="";
	//	try {
		String[] dayMonth= dailyMonth.getDaily().split("Monthly");
		String[] dayWeek = dailyWeek.getDaily().split("Weekly");
		ArrayList<String> arr = new ArrayList<String>();
		try {
		if (!dailyDay.getInfo().equals(null)) {
			 str=str+"------Daily-----\n"+dailyDay.getInfo()+"\n---------------\n";
			}
		}catch(Exception e) {
			str="";
		}
		try {
		if (dayButton.equals(dayMonth[1])) {
			str=str+"---Every "+dayButton+" of Month---\n"+dailyMonth.getInfo()+"\n------------\n";
		}
		}catch(Exception e) {
			str="";
		}
		try {
		if (dayWeek[1].equals("Sun")) {
			arr=listSun;
		}
		if (dayWeek[1].equals("Mon")) {
			arr=listMon;
			}
		if (dayWeek[1].equals("Tue")) {
			arr=listTue;
			}
		if (dayWeek[1].equals("Thu")) {
			arr =listThu;
			}
		if (dayWeek[1].equals("Wed")) {
			arr= listWed;
			}
		if (dayWeek[1].equals("Fri")) {
			arr =listFri;
			}
		if (dayWeek[1].equals("Sat")) {
			arr= listSat;
			}
		for (String a:arr) {
			if (a.equals(dayButton)) {
				str=str+"---Every "+a+" of Weekly---\n"+dailyWeek.getInfo()+"\n------------\n";
			}
		}
		}catch(Exception e) {
			str="";
		}
		return str;
	}
	public  String showInfoDaily(String daily) {
		String information ="";
		String[] dayMonth= dailyMonth.getDaily().split("Monthly");
		String[] dayWeek = dailyWeek.getDaily().split("Weekly");
		try {
		if (daily.equals("Daily")) {
			information = dailyDay.getInfo();
		}
		else if (daily.equals("Weekly")) {
			information ="---Every "+dayWeek[1]+"---\n"+dailyWeek.getInfo();
		}
		else if (daily.equals("Monthly")) {
			information  ="---Every "+dayMonth[1]+"---\n"+dailyMonth.getInfo();
		}}
		finally {
			return information;
		}
	}
	public  void chngeDaily(DailyMemo obj,String daily) {
		if (daily.equals("Daily")) {
			dailyDay = obj;
		}
		else if (daily.contains("Weekly")) {
			dailyWeek = obj;
		}
		else if (daily.contains("Monthly")) {
			dailyMonth= obj;	

		}
	}
	public  void setInfo(String date,String info) {
		for (SubMemo subMemo:list) {
			String str ="Subject:"+subMemo.getSubject()+"->"+subMemo.getYear()+"-"+subMemo.getMonth()+"-"+subMemo.getDay();
			if (str.equals(date)) {
				String quer ="UPDATE EventCalender  SET Detail = '"+info+"' WHERE Subject = '"+subMemo.getSubject()+"' AND Day = '"+subMemo.getDay()+"' AND Month = '"+subMemo.getMonth()+"' AND Year ='"+subMemo.getYear()+"';";
				subMemo.setInfo(info);
				//System.out.println(quer);
				db.upDateDB(quer);
			}
		}
	}
	public  void removeMemo(String date) {
		for (int i=0;i<list.size();i++) {
			String str ="Subject:"+list.get(i).getSubject()+"->"+list.get(i).getYear()+"-"+list.get(i).getMonth()+"-"+list.get(i).getDay();
			String quer ="delete from EventCalender where Subject = '" +list.get(i).getSubject()+"' and Detail = '"+list.get(i).getInfo()+"' and Day = '"+list.get(i).getDay()+ "' and Month = '"+list.get(i).getMonth()+"' and Year = '"+list.get(i).getYear()+"' ;" ;
			if (str.equals(date)) {
				list.remove(i);
				db.RemoveToDB(quer);
			}
		}
	}

	public  void removeDaily(String daily) {
		if (daily.equals("Daily")) {
			dailyDay=null;
		}
		else if (daily.equals("Weekly")) {
			dailyWeek=null;
		}
		else if (daily.equals("Monthly")) {
			dailyMonth=null;
		}
		db.removeDailyDataBase(daily);
		
	}
	public  void editDaily(String text, String daily) {
		if (daily.equals("Daily")) {
			dailyDay.setInfo(text);
		}
		else if (daily.equals("Weekly")) {
			dailyWeek.setInfo(text);
		}
		else if (daily.equals("Monthly")) {
			dailyMonth.setInfo(text);	
		}
		String quer ="UPDATE EventCalender  SET Detail = '"+text+"' WHERE Form = '"+daily+"';";
//				"UPDATE EventCalender  SET Detail = '"+info+"' WHERE Subject = '"+subMemo.getSubject()+"' AND Day = '"+subMemo.getDay()+"' AND Month = '"+subMemo.getMonth()+"' AND Year ='"+subMemo.getYear()+"';";
		//System.out.println(quer);
		db.upDateDailyDataBase(quer);
		
		
	}
	public  ArrayList<SubMemo> getList() {
		return list;
	}
	public  void setList(ArrayList<SubMemo> list) {
		this.list = list;
	}
	public  ArrayList<SubMemo> getListDate() {
		return list;
	}
	
	
}
