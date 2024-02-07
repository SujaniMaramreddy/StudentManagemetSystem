package com.DBcon;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.Model.Student;
import com.palle.Admin;

import com.Model.LoginModel;

public class AdminDao {
	public static String url = "jdbc:mysql://localhost:3306/SM ";
	public static String username = "root";
	public static String password = "admin@1014";
	public static Connection cn = null;
	public static PreparedStatement ps = null;
	public static Statement st = null;
	public static ResultSet rs = null;

	public void insertStudentdetails(Student s) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url, username, password);
			ps = cn.prepareStatement("insert into JavaStudent(sname,sub,gender,email,education) values(?,?,?,?,?)");
			ps.setString(1, s.getSname());

			ps.setString(2, s.getSub());
			ps.setString(3, s.getGender());
			ps.setString(4, s.getSemail());
			ps.setString(5, s.getEducation());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				
				ps.close();
				cn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public String checkLogin(LoginModel lm) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url, username, password);
			rs = st.executeQuery("select * from Login");
			while (rs.next()) {
				String demail = rs.getString("L_email");
				String dpassword = rs.getString("L_password");
				if (demail.equals(lm.getEmail()) && dpassword.equals(lm.getPassword())) {
					return "Success";
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				cn.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return "Failure";
	}
}
