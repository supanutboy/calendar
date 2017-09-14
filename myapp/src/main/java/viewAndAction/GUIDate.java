package viewAndAction;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.portable.ValueOutputStream;

import controller.Controller;
import model.Memo;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JRadioButton;

public class GUIDate extends JFrame {
	private Memo memo;
	private static JTextArea textArea,textDate,textAreaDaily;
	private JPanel contentPane;
	JComboBox comboBoxDay,comboBoxDaily;
	//private JTextField textField;
	private JTextField[] textField = new JTextField[42];
	private JButton[] btnDay= new JButton[42];
	//private static JTextField textDate;
	private JTextField textSubject;
	private JComboBox comboBoxMonth;
	private JRadioButton rdbtnDay,rdbtnWeekly,rdbtnMonthly;
	private JComboBox comboBoxYear;
	private static JComboBox comboBoxDate;
	private Controller control;
	private JButton btnChoose , btnEdit,btnOk,btnOkDaily,btnEditDaily,day;
	private JTextField chooseDate;
	private ButtonGroup group;
	private ArrayList<String > listMon,listSun,listTue,listWed,listThu,listFri,listSat;
	/**
	 * Launch the application.
	 */
	public  void starFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIDate frame = new GUIDate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public GUIDate() {
		listMon = new ArrayList<String>();
		listSun = new ArrayList<String>();
		listTue = new ArrayList<String>();
		listWed = new ArrayList<String>();
		listThu = new ArrayList<String>();
		listFri = new ArrayList<String>();
		listSat = new ArrayList<String>();
		setBackground(Color.PINK);
		memo=new Memo();
		control = new Controller();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(140, 450,876, 683);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDate = new JLabel("Day: ");
		lblDate.setBounds(457, 43, 36, 16);
		contentPane.add(lblDate);
		
		JLabel lblSun = new JLabel("SUN");
		lblSun.setBounds(53, 78, 61, 16);
		contentPane.add(lblSun);
		
		JLabel lblMon = new JLabel("MON");
		lblMon.setBounds(106, 78, 61, 16);
		contentPane.add(lblMon);
		
		JLabel lblTue = new JLabel("TUE");
		lblTue.setBounds(165, 78, 61, 16);
		contentPane.add(lblTue);
		
		JLabel lblNewLabel = new JLabel("WED");
		lblNewLabel.setBounds(220, 78, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblThu = new JLabel("THU");
		lblThu.setBounds(277, 78, 36, 16);
		contentPane.add(lblThu);
		
		JLabel lblFri = new JLabel("FRI");
		lblFri.setBounds(342, 78, 61, 16);
		contentPane.add(lblFri);
		
		JLabel lblSat = new JLabel("SAT");
		lblSat.setBounds(395, 78, 61, 16);
		contentPane.add(lblSat);
		
		JLabel lblMemo = new JLabel("MEMO&Calender");
		lblMemo.setBounds(298, 11, 103, 16);
		contentPane.add(lblMemo);
		
		//textField = new JTextField();
//		textField.setBounds(444, 81, 186, 225);
//		contentPane.add(textField);
//		textField.setColumns(10);
//		
		
		

		textSubject = new JTextField();
		textSubject.setBounds(510, 66, 211, 26);
		contentPane.add(textSubject);
		textSubject.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(457, 125, 390, 233);
		contentPane.add(textArea);
		
		comboBoxDay = new JComboBox();
		comboBoxDay.setBounds(489, 42, 85, 21);
		contentPane.add(comboBoxDay);
		
		comboBoxMonth = new JComboBox(getMonth());
		comboBoxMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int year = Integer.parseInt(comboBoxYear.getSelectedItem().toString());
				int month = comboBoxMonth.getSelectedIndex();
				chooseDate.setText(comboBoxMonth.getSelectedItem()+"-"+year);
				showCalender(year,month);
			}
		});
		comboBoxMonth.setBackground(Color.PINK);
		comboBoxMonth.setBounds(43, 39, 123, 27);
		contentPane.add(comboBoxMonth);
		
		comboBoxYear = new JComboBox(getYear());
		comboBoxYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int year = Integer.parseInt(comboBoxYear.getSelectedItem().toString());
				int month = comboBoxMonth.getSelectedIndex();
				chooseDate.setText(comboBoxMonth.getSelectedItem()+"-"+year);
				showCalender(year,month);
			}
		});
		comboBoxYear.setBounds(178, 39, 123, 27);
		contentPane.add(comboBoxYear);
		
		JButton btnSave = new JButton("Save to Topic\n");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDate();
				textArea.setText("");textSubject.setText("");
			}

		
		});
		btnSave.setBounds(457, 370, 117, 29);
		contentPane.add(btnSave);
		
		chooseDate = new JTextField();
		chooseDate.setBounds(576, 38, 151, 26);
		chooseDate.setEditable(false);
		contentPane.add(chooseDate);
		chooseDate.setColumns(10);
		
//		JButton btnShow = new JButton("SHOW");
//		btnShow.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				int year = Integer.parseInt(comboBoxYear.getSelectedItem().toString());
//				int month = comboBoxMonth.getSelectedIndex();
//				chooseDate.setText(comboBoxMonth.getSelectedItem()+"-"+year);
//				showCalender(year,month);
//			}
//		});
//		btnShow.setBounds(320, 37, 117, 29);
//		contentPane.add(btnShow);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 240, 230));
		panel.setBounds(30, 105, 403, 256);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(6,7, 0, 0));
			
		
	
		JLabel lblStep = new JLabel("Step 1:Choose Month&Year");
		lblStep.setBounds(43, 11, 204, 16);
		contentPane.add(lblStep);
		
		JLabel lblStep_1 = new JLabel("Step2:Choose Day");
		lblStep_1.setBounds(468, 11, 136, 16);
		contentPane.add(lblStep_1);
		
		textDate = new JTextArea();
		textDate.setBackground(new Color(255, 245, 238));
		textDate.setBounds(43, 462, 339, 144);
		textDate.setEditable(false);
		contentPane.add(textDate);
		
		textDate.setColumns(10);
		
		JLabel lblTodolist = new JLabel("To-do-list    date : ");
		lblTodolist.setBackground(new Color(255, 250, 205));
		lblTodolist.setBounds(43, 411, 165, 16);
		contentPane.add(lblTodolist);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(457, 71, 61, 16);
		contentPane.add(lblSubject);
		
		comboBoxDate = new JComboBox();
		comboBoxDate.setBounds(168, 411, 262, 16);
		contentPane.add(comboBoxDate);
		
		JLabel lblStepchooseDate = new JLabel("Step3:Choose date ");
		lblStepchooseDate.setBounds(43, 383, 123, 16);
		contentPane.add(lblStepchooseDate);
		
		btnChoose = new JButton("Choose");
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.calledDate(comboBoxDate.getSelectedItem()+"");
			}
		});
		btnChoose.setBounds(424, 406, 89, 29);
		contentPane.add(btnChoose);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			control.removeDate(comboBoxDate.getSelectedItem()+"");
			}
		});
		btnRemove.setBounds(30, 613, 117, 29);
		contentPane.add(btnRemove);
		
		JLabel lblDetail = new JLabel("Detail");
		
		lblDetail.setBounds(457, 97, 61, 16);
		contentPane.add(lblDetail);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textDate.setBackground(new Color(255, 255, 255));
				textDate.setEditable(true);
				btnEdit.setVisible(false);
				btnOk.setVisible(true);
			}
		});
		btnEdit.setBounds(141, 613, 129, 29);
		contentPane.add(btnEdit);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEdit.setVisible(true);
				btnOk.setVisible(false);
				textDate.setEditable(false);
				textDate.setBackground(new Color(255, 245, 238));
				control.setDate(comboBoxDate.getSelectedItem()+"",textDate.getText());
			}
		});
		btnOk.setBounds(265, 613, 117, 29);
		btnOk.setVisible(false);
		contentPane.add(btnOk);
		
		textAreaDaily = new JTextArea();
		textAreaDaily.setEditable(false);
		textAreaDaily.setColumns(10);
		textAreaDaily.setBackground(new Color(255, 245, 238));
		textAreaDaily.setBounds(438, 467, 364, 154);
		contentPane.add(textAreaDaily);
		
		JLabel lblDailyMemo = new JLabel("To do-list for \n");
		lblDailyMemo.setBounds(434, 436, 103, 26);
		contentPane.add(lblDailyMemo);
		
		JLabel lblMemoTopic = new JLabel("Memo Topic");
		lblMemoTopic.setBounds(43, 434, 89, 31);
		contentPane.add(lblMemoTopic);
		
		
		JButton btnAddToDaily = new JButton("Add to Daily");
		btnAddToDaily.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.addDaily(textSubject.getText(),textArea.getText(),comboBoxDay.getSelectedItem()+"",comboBoxMonth.getSelectedItem()+"",comboBoxYear.getSelectedItem()+"",comboBoxDaily.getSelectedItem()+"");
				//comboBoxDate.addItem("Subject:"+textSubject.getText()+"->"+comboBoxYear.getSelectedItem()+"-"+comboBoxMonth.getSelectedItem()+"-"+comboBoxDay.getSelectedItem()+"");
				textSubject.setText("");
				textArea.setText("");
			}
		});
		btnAddToDaily.setBounds(718, 370, 129, 29);
		contentPane.add(btnAddToDaily);
		
		comboBoxDaily = new JComboBox();
		comboBoxDaily.setBounds(587, 371, 123, 27);
		comboBoxDaily.addItem("Daily");
		comboBoxDaily.addItem("Weekly");
		comboBoxDaily.addItem("Monthly");
		contentPane.add(comboBoxDaily);
		
		JLabel label = new JLabel("|\n");
		label.setBounds(574, 347, 25, 73);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("|\n");
		label_1.setBounds(412, 411, 25, 73);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("|\n");
		label_2.setBounds(412, 439, 25, 73);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("|\n");
		label_3.setBounds(412, 462, 25, 73);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("|\n");
		label_4.setBounds(412, 524, 25, 26);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("|\n");
		label_5.setBounds(412, 478, 25, 73);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("|\n");
		label_6.setBounds(412, 524, 25, 73);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("|\n");
		label_7.setBounds(412, 562, 25, 26);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("|\n");
		label_8.setBounds(412, 580, 25, 26);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("|\n");
		label_9.setBounds(412, 447, 25, 26);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("|\n");
		label_10.setBounds(412, 585, 25, 26);
		contentPane.add(label_10);
	
		rdbtnDay = new JRadioButton("Daily");
		rdbtnDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.calledDaily("Daily");
			}
		});
		rdbtnDay.setBounds(527, 437, 77, 23);
		contentPane.add(rdbtnDay);
		
		rdbtnWeekly = new JRadioButton("Weekly");
		rdbtnWeekly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.calledDaily("Weekly");
			}
		});
		rdbtnWeekly.setBounds(597, 437, 89, 23);
		contentPane.add(rdbtnWeekly);
		
		rdbtnMonthly = new JRadioButton("Monthly");
		rdbtnMonthly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.calledDaily("Monthly");
			}
		});
		rdbtnMonthly.setBounds(679, 437, 91, 23);
		contentPane.add(rdbtnMonthly);
		group = new ButtonGroup();
		group.add(rdbtnMonthly);group.add(rdbtnWeekly);group.add(rdbtnDay);
		
		new JLabel("|\n");
		label_9.setBounds(412, 447, 25, 26);
		contentPane.add(label_9);
		
		JLabel label_101 = new JLabel("|\n");
		label_101.setBounds(412, 585, 25, 26);
		contentPane.add(label_101);
		
		JButton btnRemoveDaily = new JButton("Remove");
		btnRemoveDaily.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnDay.isSelected()) {
					control.removeDaily("Daily");
				}
				else if (rdbtnWeekly.isSelected()) {
					control.removeDaily("Weekly");
				}
				else if (rdbtnMonthly.isSelected()) {
					control.removeDaily("Monthly");
				}
				textAreaDaily.setText("");
				
			}
		});
		btnRemoveDaily.setBounds(437, 626, 117, 29);
		contentPane.add(btnRemoveDaily);
		
		
		btnOkDaily = new JButton("OK");
		btnOkDaily.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditDaily.setVisible(true);
				btnOkDaily.setVisible(false);
				textAreaDaily.setEditable(false);
				textAreaDaily.setBackground(new Color(255, 245, 238));
				if (rdbtnDay.isSelected()) {
					control.editDaily(textAreaDaily.getText()+"","Daily");
				}
				else if (rdbtnWeekly.isSelected()) {
					control.editDaily(textAreaDaily.getText()+"","Weekly");
				}
				else if (rdbtnMonthly.isSelected()) {
					control.editDaily(textAreaDaily.getText()+"","Monthly");
				}
			}
		});
		btnOkDaily.setBounds(685, 626, 117, 29);
		btnOkDaily.setVisible(false);
		contentPane.add(btnOkDaily);
		
		btnEditDaily = new JButton("Edit");
		btnEditDaily.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnOkDaily.setVisible(true);
				btnEditDaily.setVisible(false);
				textAreaDaily.setEditable(true);
				textAreaDaily.setBackground(new Color(255, 255, 255));
			}
		});
		btnEditDaily.setBounds(566, 626, 117, 29);
		contentPane.add(btnEditDaily);
		
	//	for(int i=0;i<textField.length;i++) { `						##
			
//			textField[i] = new JTextField();
//			textField[i].setEditable(false);
//			textField[i].setHorizontalAlignment(JTextField.CENTER);
	//		panel.add(textField[i]);									##
		//}
		
		for (int i=0;i<btnDay.length;i++) {
			final JButton dayB = new JButton();
			dayB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textArea.setText("");textSubject.setText("");
			//		System.out.println(dayB.getText());
					
				//	control.addText(textSubject.getText(),textArea.getText(),dayB.getName()+"",comboBoxMonth.getSelectedItem()+"",comboBoxYear.getSelectedItem()+"");
				//	comboBoxDate.addItem("Subject:"+textSubject.getText()+"->"+comboBoxYear.getSelectedItem()+"-"+comboBoxMonth.getSelectedItem()+"-"+dayB.getName()+"");
					control.calledDate(comboBoxYear.getSelectedItem()+"-"+comboBoxMonth.getSelectedItem()+"-"+dayB.getText()+"");
				}
			});
			btnDay[i] = dayB;
			panel.add(dayB);
		}	
	}
public String checkDay (String day) {
	String dailyDay ="";
	if (listMon.contains(day)) {
		dailyDay = "Monday";
	}
	else if (listFri.contains(day)) {
		dailyDay = "Friday";
	}
	else if (listSat.contains(day)) {
		dailyDay = "Sat";
	}
	else if (listSun.contains(day)) {
		dailyDay = "Sunday";
	}
	else if (listThu.contains(day)) {
		dailyDay = "Thu";
	}
	else if (listTue.contains(day)) {
		dailyDay = "Tue";
	}
	else if (listWed.contains(day)) {
		dailyDay = "Wed";
	}
	return dailyDay;
}
	
protected void showCalender(int yearSelect,int monthSelect) {
		int[] monthDay = {31,28,31,30,31,30,31,31,30,31,30,31};
		int year=2000;
		int month=0;
		int day = 0;
		while (check(yearSelect,monthSelect,year,month)) {
		if (month==1 && leapYear(year)) {
			day=day+29;
		}
		else {
			day =day+monthDay[month];
		}
		month++;
		if(month == 12) {
			month=0;
			year++;
		}
		day=day%7;
		}	
		for (int i=0;i<btnDay.length;i++) {	
			btnDay[i].setText("");
		}
		int lastValue =monthDay[monthSelect];	
		if (monthSelect==1 && leapYear(yearSelect)) {
			lastValue++;
		}
		this.updateDay(lastValue);
		int count=0;
		for (int i=1,j=day;i<=lastValue;i++,j++) {
			if (count%7==0) {
				listSun.add(i+"");
			}
			else if (count%7==1) {
				listMon.add(i+"");
			}
			else if (count%7==2) {
				listTue.add(i+"");
			}
			else if (count%7==3) {
				listWed.add(i+"");
			}
			else if (count%7==4) {
				listTue.add(i+"");
			}
			else if (count%7==5) {
				listFri.add(i+"");
			}
			else if (count%7==6) {
				listSat.add(i+"");
			}
//			for (String q: listMon) {
//				System.out.println(q);
//			}
			btnDay[j].setText(String.valueOf(i));
		//	System.out.println(btnDay[j].getText());
			count=count+1;
		}
		
	}
private void updateDay(int lastday) {
	int[] list = new int[lastday];
	comboBoxDay.removeAllItems();
	for (int i=1;i<lastday+1;i++) {
		comboBoxDay.addItem(i);
	}
}
private boolean leapYear(int year) {
	boolean ans = false;
	if (year % 4==0 && year %100 != 0) {
		ans=true;
	if (year %400==0) {
		ans=true;
	}
	}
	return ans;
}
private void addDate() {
	control.addText(textSubject.getText(),textArea.getText(),comboBoxDay.getSelectedItem()+"",comboBoxMonth.getSelectedItem()+"",comboBoxYear.getSelectedItem()+"");
	comboBoxDate.addItem("Subject:"+textSubject.getText()+"->"+comboBoxYear.getSelectedItem()+"-"+comboBoxMonth.getSelectedItem()+"-"+comboBoxDay.getSelectedItem()+"");
	
}
private boolean check(int comboBoxYear, int comboBoxMonth, int year, int month) {
	if (comboBoxYear==year && comboBoxMonth==month) {
		return false;
	}
	return true;
}


	private String[] getYear() {
		String[] str = new String[201];
		for(int i=2000,j=0;i<=2100;i++,j++) {
			str[j]=String.valueOf(i);
		}
		return str;
		}


	private String[] getMonth() {
		String[] str = {"January","Febryary","Match","April","May","June","July","August","September","October","November","December"};
		return str;
	}
	public static  void showDate(String info) {
		textDate.setText(info);
	}
	public static void deleteComboBoxDate(String date) {
		for (int i=0 ;i<comboBoxDate.getItemCount();i++) {
			String str =comboBoxDate.getItemAt(i)+"";
			if ((str).equals(date)) {
			comboBoxDate.removeItemAt(i);
			}
			
		}
	}
	public JComboBox getComboBoxDate() {
		return this.comboBoxDate;
	}
	public static void showDateDaily(String info) {
		textAreaDaily.setText(info);
	}
	public static void showTextButton() {
		
	}
}
