package controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JTextArea;

import model.Memo;
import model.SubMemo;
import viewAndAction.GUIDate;
import viewAndAction.View;

public class Controller {
	Memo memo;
	SubMemo subMemo;
	GUIDate gui;
	public void startApplication() {
		Date currentDate = new Date();
		memo = new Memo();
//		SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
//		System.out.println(date.format(currentDate));
//		View view = new View((date.format(currentDate)));
		gui =new GUIDate();
		gui.starFrame();
	}

	public void addText(String subject,String textArea,String day,String month,String year) {//getDay Year Month  นำมาใส่เพื่อผันทึกค่า อย่าลืมคิดเคสที่เดือนวันปีเดียวกัน
		subMemo = new SubMemo (subject,textArea,day,month,year);
		//System.out.println(textArea+"-"+day+"_"+month+"_"+year);
		memo.addSub(subMemo);
//		System.out.println("Hello"+memo.getInfo("dsd","dd", "dd"));
	}
	
	public void calledDate(String date) {
		//System.out.println(listDate[1]+"   "+listDate[2]+"   "+listDate[3]);
		String info=memo.getInfo(date);
	//	System.out.println(info);
		gui.showDate(info);
	}

	public void removeDate(String date) {
		memo.removeMemo(date);
		gui.showDate(date+" <==== This date has been deleted");
		gui.deleteComboBoxDate(date);
	}

}
