package com_infotech.main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import studentclass.Student;
import com_infotech.jdbc.DB.JDBCMySQLConnection;
public class Mysql {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter the Student_id:");
     
    int Student_id ;{
    try {
    	Student_id = Integer.parseInt(br.readLine());
        Mysql demo = new Mysql();
        Student student = demo.getStudent(Student_id);
        System.out.println(student);           
    } catch (NumberFormatException e) {
        e.printStackTrace();
    } catch (IOException p) {
        p.printStackTrace();
    }       
    }
public Student getStudent(int student_id )  {      
    ResultSet rs = null;
    Connection connection = null;
    Statement statement = null; 
     
    Student student = null;
    String query = "SELECT * FROM student WHERE student_id=" + student_id;
    try {           
        connection = JDBCMySQLConnection.getConnection();
        statement = connection.createStatement();
        rs = statement.executeQuery(query);
         
        if (rs.next()) {
        	student = new Student();
        	student.setStudentId(rs.getInt("student_id"));
        	student.setName(rs.getString("name"));
           
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    return student ;}
}
}

