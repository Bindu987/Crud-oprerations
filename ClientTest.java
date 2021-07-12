package com_infotech.client;

import java.sql.Connection;
import java.sql.Statement;

import com_infotech.util.DBUtil;

public class ClientTest {

	public static void main(String[] args) {
		deletestudentid();
	}

	private static void deletestudentid() {
		try(Connection connection = DBUtil.getConnection();Statement st = connection.createStatement();) {
			
			String SQLINSERT = "DELETE FROM student WHERE student_id=1";
			int executeUpdate = st.executeUpdate(SQLINSERT);
			if(executeUpdate ==1){
				System.out.println("id is deleted..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	private static void createstudent() {
		try(Connection connection = DBUtil.getConnection();Statement st = connection.createStatement();) {
			
			String SQLINSERT = "INSERT INTO student(student_id,name,country) "
					+ "VALUES('1','sree','India')";
			int executeUpdate = st.executeUpdate(SQLINSERT);
			if(executeUpdate ==1){
				System.out.println("student is created..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}