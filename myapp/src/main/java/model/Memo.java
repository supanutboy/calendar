package model;

import java.util.ArrayList;
public class Memo {
	 private static ArrayList<SubMemo> list;
	public  Memo() {
		this.setList(new ArrayList<SubMemo>());
	}
	public static void addSub(SubMemo subMemo) {
		// TODO Auto-generated method stub
		getList().add(subMemo);
	}
	public static String getInfo(String date) {
		for (SubMemo subMemo:list) {
			String str ="Subject:"+subMemo.getSubject()+"->"+subMemo.getYear()+"-"+subMemo.getMonth()+"-"+subMemo.getDay();
			
			if (str.equals(date)) {
				return subMemo.getInfo();
			}
		}
		return null;
		
	}
	public static void removeMemo(String date) {
		for (int i=0;i<list.size();i++) {
			String str ="Subject:"+list.get(i).getSubject()+"->"+list.get(i).getYear()+"-"+list.get(i).getMonth()+"-"+list.get(i).getDay();
			if (str.equals(date)) {
				list.remove(i);
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
