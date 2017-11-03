package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import viewAndAction.GUIDate;

public class DataBase {
	private Memo memo;
	public DataBase() {
	
	}
	public  void StartDataBase(Memo memo) {
		try {
			this.memo=memo;
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:Supanut.db";
			Connection conn =DriverManager.getConnection(dbURL);
			if(conn !=  null) {
				String query ="Select * from EventCalender";
				Statement state = conn.createStatement();
				ResultSet result = state.executeQuery(query);
				while(result.next()) {
					String form =result.getString(6)+"";
					if (form.equals("null")) {
					this.memo.getListDate().add(new SubMemo(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5)));
					}else {
					this.memo.chngeDaily(new DailyMemo(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6)),result.getString(6));
					}
				}
//				conn.close();
					//สร้างifเพื่อเช็คว่าเป็นfromไหนจะได้สร้างdailyได้ถูกต้อง
//					String subject = result.getString(1);
//					String detail = result.getString(2);
//					String day = result.getString(3);
//					String month = result.getString(4);
//					String year = result.getString(5);
//					String form =result.getString(6);
//					System.out.println(subject+detail+day+month+year+"A"+form+"B"); 
				}
		}
		catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}	
	}
	public void RemoveToDB(String quer) {
		String dbURL = "jdbc:sqlite:Supanut.db";
		try {
			Connection conn =DriverManager.getConnection(dbURL);
			Statement state = conn.createStatement();
			state.execute(quer);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public  void insertDailyDataBase(String date,String daily)  {
		String dbURL = "jdbc:sqlite:Supanut.db";
		try {
			Connection conn2 =DriverManager.getConnection(dbURL);
			//String quer1 ="insert into EventCalender (Subject , Detail , Day , Month , Year) values ('sypanut','11','10','09','2016')";
			String quer2 ="delete from EventCalender where Form = '"+daily+"';";
			Statement state2 = conn2.createStatement();
			state2.execute(quer2);
			conn2.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Connection conn1 =DriverManager.getConnection(dbURL);
			String quer1 ="insert into EventCalender (Subject , Detail , Day , Month , Year ,Form) values ("+date+")";
			Statement state1 = conn1.createStatement();
			state1.execute(quer1);
			conn1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void removeDailyDataBase(String daily) {
		String dbURL = "jdbc:sqlite:Supanut.db";
		try {
			Connection conn =DriverManager.getConnection(dbURL);
			Statement state = conn.createStatement();
			String quer ="delete from EventCalender where Form = '"+daily+"';";
			state.execute(quer);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void upDateDailyDataBase(String quer) {
		String dbURL = "jdbc:sqlite:Supanut.db";
		try {
			Connection conn =DriverManager.getConnection(dbURL);
			Statement state = conn.createStatement();
		//	String quer ="delete from EventCalender where Form = '"+daily+"';";
			state.execute(quer);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		public void upDateDB(String quer) {
		String dbURL = "jdbc:sqlite:Supanut.db";
		try {
			Connection conn =DriverManager.getConnection(dbURL);
			Statement state = conn.createStatement();
			state.execute(quer);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void insertToDB(String date) {
		String dbURL = "jdbc:sqlite:Supanut.db";
		try {
			Connection conn =DriverManager.getConnection(dbURL);
			String quer ="insert into EventCalender (Subject , Detail , Day , Month , Year) values ("+date+")";
			//String quer1 ="insert into EventCalender (Subject , Detail , Day , Month , Year) values ('sypanut','11','10','09','2016')";
			Statement state = conn.createStatement();
			state.execute(quer);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
