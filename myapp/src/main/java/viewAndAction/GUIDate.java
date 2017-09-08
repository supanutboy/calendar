package viewAndAction;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.portable.ValueOutputStream;

import controller.Controller;
import model.Memo;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JTextArea;
import java.awt.Color;

public class GUIDate extends JFrame {
	private Memo memo;
	private static JTextArea textArea,textDate;
	private JPanel contentPane;
	JComboBox comboBoxDay;
	//private JTextField textField;
	private JTextField[] textField = new JTextField[42];
	//private static JTextField textDate;
	private JTextField textSubject;
	private JComboBox comboBoxMonth;
	private JComboBox comboBoxYear;
	private static JComboBox comboBoxDate;
	private Controller control;
	private JButton btnChoose , btnEdit,btnOk;
	private JTextField chooseDate;

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
		setBackground(Color.PINK);
		memo=new Memo();
		control = new Controller();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(140, 450,760, 670);
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
		textArea.setBounds(457, 125, 286, 233);
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
		
		JButton btnSave = new JButton("save");
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
		
		JButton btnShow = new JButton("SHOW");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int year = Integer.parseInt(comboBoxYear.getSelectedItem().toString());
				int month = comboBoxMonth.getSelectedIndex();
				chooseDate.setText(comboBoxMonth.getSelectedItem()+"-"+year);
				showCalender(year,month);
			}
		});
		btnShow.setBounds(320, 37, 117, 29);
		contentPane.add(btnShow);
		
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
		textDate.setBounds(30, 439, 650, 144);
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
		comboBoxDate.setBounds(168, 411, 490, 16);
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
		btnChoose.setBounds(654, 406, 89, 29);
		contentPane.add(btnChoose);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			control.removeDate(comboBoxDate.getSelectedItem()+"");
			}
		});
		btnRemove.setBounds(30, 587, 117, 29);
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
		btnEdit.setBounds(147, 587, 129, 29);
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
		btnOk.setBounds(277, 587, 117, 29);
		btnOk.setVisible(false);
		contentPane.add(btnOk);
		for(int i=0;i<textField.length;i++) {
			textField[i] = new JTextField();
			textField[i].setEditable(false);
			textField[i].setHorizontalAlignment(JTextField.CENTER);
			panel.add(textField[i]);
		}
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
		for (int i=0;i<textField.length;i++) {
			textField[i].setText("");
		}
		int lastValue =monthDay[monthSelect];	
		if (monthSelect==1 && leapYear(yearSelect)) {
			lastValue++;
		}
		this.updateDay(lastValue);
		for (int i=1,j=day;i<=lastValue;i++,j++) {
			textField[j].setText(String.valueOf(i));
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
//	if (year %100==0) {
//		ans =false;	
//	}
	if (year %400==0) {
		ans=true;
	}
	}
	return ans;
}
private void addDate() {
	control.addText(textSubject.getText(),textArea.getText(),comboBoxDay.getSelectedItem()+"",comboBoxMonth.getSelectedItem()+"",comboBoxYear.getSelectedItem()+"");
	//textArea ใส่ในmethod
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
}
