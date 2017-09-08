package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import viewAndAction.GUIDate;

public class DataBase {

	public  void StartDataBase(Memo memo,GUIDate gui) {
		try {
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:Supanut.db";
			Connection conn =DriverManager.getConnection(dbURL);
			if(conn !=  null) {
				String query ="Select * from EventCalender";
				Statement state = conn.createStatement();
				ResultSet result = state.executeQuery(query);
				while(result.next()) {
					memo.getListDate().add(new SubMemo(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5)));
					gui.getComboBoxDate().addItem("Subject:"+result.getString(1)+"->"+result.getString(5)+"-"+result.getString(4)+"-"+result.getString(3)+"");
					
					
					//String subject = result.getString(1);
//					String detail = result.getString(2);
//					String day = result.getString(3);
//					String month = result.getString(4);
//					String year = result.getString(5);
//					System.out.println(subject+detail+day+month+year); 
				}
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
