package model;

import java.util.ArrayList;
public class Memo {
	private static ArrayList<SubMemo> list;
	private static DataBase db;
	public   Memo() {
		list= new ArrayList<SubMemo>();
		db = new DataBase();
	}
	public static void addSub(SubMemo subMemo) {
		list.add(subMemo);
		String str ="'"+subMemo.getSubject()+"','"+subMemo.getInfo()+"','"+subMemo.getDay()+"','"+subMemo.getMonth()+"','"+subMemo.getYear()+"'";
		db.insertToDB(str);
	}
	public static String getInfo(String date) {
	//	System.out.println(list.size());
		for (SubMemo subMemo:list) {
			String str ="Subject:"+subMemo.getSubject()+"->"+subMemo.getYear()+"-"+subMemo.getMonth()+"-"+subMemo.getDay();
		//	System.out.println(str);
			if (str.equals(date)) {
				return subMemo.getInfo();
			}
		}
		return "Hello";	
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
}
