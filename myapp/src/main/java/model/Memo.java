package model;

import java.util.ArrayList;


public class Memo {
	private static ArrayList<SubMemo> list;
	//private static ArrayList<DailyMemo> listDaily;
	private static DailyMemo dailyDay    ;
	private static DailyMemo dailyMonth ;
	private static DailyMemo dailyWeek ;
	private static DataBase db;
	public   Memo() {
		list= new ArrayList<SubMemo>();
		db = new DataBase();
		dailyDay  = new DailyMemo("","","","","","");
		dailyMonth = new DailyMemo("","","","","","");
		dailyWeek = new DailyMemo("","","","","","");
	}
	public static void addSub(SubMemo subMemo) {
		list.add(subMemo);
		String str ="'"+subMemo.getSubject()+"','"+subMemo.getInfo()+"','"+subMemo.getDay()+"','"+subMemo.getMonth()+"','"+subMemo.getYear()+"'";
		db.insertToDB(str);
	}
	public static String getInfo(String date) {
	//	System.out.println(list.size());
		for (SubMemo subMemo:list) {
			String str = subMemo.getYear()+"-"+subMemo.getMonth()+"-"+subMemo.getDay();
		//	System.out.println(str);
			if (str.equals(date)) {
				return subMemo.getInfo();
			}
		}
		return "Hello";	
	}
	public static void chngeDaily(DailyMemo obj,String daily) {
		if (daily.equals("Daily")) {
			dailyDay = obj;
		}
		else if (daily.equals("Weekly")) {
			dailyWeek = obj;
		}
		else if (daily.equals("Monthly")) {
			dailyMonth= obj;	
		}
	}
	public static void setInfo(String date,String info) {
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
	public static String showInfoDaily(String daily) {
		String information ="";
		if (daily.equals("Daily")) {
			information = dailyDay.getInfo();
		}
		else if (daily.equals("Weekly")) {
			information =dailyWeek.getInfo();
		}
		else if (daily.equals("Monthly")) {
			information  =dailyMonth.getInfo();
		}
			return information;
	}
	public static void addDaily(String subject,String info,String day,String month,String year,String daily) {
		String str  = "";
		if (daily.equals("Daily")) {
			dailyDay.newSet(subject,info,day,month,year,daily);
			str ="'"+dailyDay.getSubject()+"','"+dailyDay.getInfo()+"','"+dailyDay.getDay()+"','"+dailyDay.getMonth()+"','"+dailyDay.getYear()+"','Daily'";
			//System.out.println(str);
		}
		else if (daily.equals("Weekly")) {
			dailyWeek.newSet(subject,info,day,month,year,daily);
			str ="'"+dailyWeek.getSubject()+"','"+dailyWeek.getInfo()+"','"+dailyWeek.getDay()+"','"+dailyWeek.getMonth()+"','"+dailyWeek.getYear()+"','Weekly'";

		}
		else if (daily.equals("Monthly")) {
			dailyMonth.newSet(subject,info,day,month,year,daily);
			str ="'"+dailyMonth.getSubject()+"','"+dailyMonth.getInfo()+"','"+dailyMonth.getDay()+"','"+dailyMonth.getMonth()+"','"+dailyMonth.getYear()+"','Monthly'";

		}
		db.insertDailyDataBase(str,daily);
	}
	
	public static void removeMemo(String date) {
		for (int i=0;i<list.size();i++) {
			String str ="Subject:"+list.get(i).getSubject()+"->"+list.get(i).getYear()+"-"+list.get(i).getMonth()+"-"+list.get(i).getDay();
			String quer ="delete from EventCalender where Subject = '" +list.get(i).getSubject()+"' and Detail = '"+list.get(i).getInfo()+"' and Day = '"+list.get(i).getDay()+ "' and Month = '"+list.get(i).getMonth()+"' and Year = '"+list.get(i).getYear()+"' ;" ;
			if (str.equals(date)) {
				list.remove(i);
				db.RemoveToDB(quer);
			}
		}
	}
	static ArrayList<SubMemo> getList() {
		return list;
	}
	static void setList(ArrayList<SubMemo> list) {
		Memo.list = list;
	}
	public static ArrayList<SubMemo> getListDate() {
		return list;
	}
	public static void removeDaily(String daily) {
		if (daily.equals("Daily")) {
			dailyDay.newSet("","","","","","");
		}
		else if (daily.equals("Weekly")) {
			dailyWeek.newSet("","","","","","");
		}
		else if (daily.equals("Monthly")) {
			dailyMonth.newSet("","","","","","");	
		}
		db.removeDailyDataBase(daily);
		
	}
	public static void editDaily(String text, String daily) {
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
	
}
