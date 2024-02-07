package com.palle;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBcon.AdminDao;
import com.Model.Student;

import com.Model.LoginModel;

@WebServlet("/")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		switch (path) {
		case "/Validate":
			adminValidate(request, response);
			break;
		case "/studentpage":
			getStudentpage(request, response);
			break;
		case "/insert":
			insertStudent(request, response);
			break;

		default:
			getLoginpage(request, response);

		}
	}

	private void insertStudent(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String sname = request.getParameter("sname");
		String sub = request.getParameter("sub");
		String gender = request.getParameter("gender");
		String email = request.getParameter("semail");
		String education = request.getParameter("education");
		Student s = new Student(sname, email, sub, gender, education);
		AdminDao a = new AdminDao();
		a.insertStudentdetails(s);

	}

	private void getStudentpage(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rd = request.getRequestDispatcher("Student.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO: handle exception
			e.printStackTrace();

		}
	}

	private void adminValidate(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		LoginModel lm = new LoginModel(email, password);
		AdminDao ad = new AdminDao();
		String status = ad.checkLogin(lm);
		if (status.equals("Success")) {
			RequestDispatcher rd = request.getRequestDispatcher("adminstration.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO: handle exception
				e.printStackTrace();

			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO: handle exception
				e.printStackTrace();

			}
		}

	}

	private void getLoginpage(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO: handle exception
			e.printStackTrace();

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
