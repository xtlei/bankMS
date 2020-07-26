package cn.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bank.entity.Administrator;
import cn.bank.entity.Customer;
import cn.bank.service.AdministratorService;
import cn.bank.service.CustomerService;
import cn.bank.service.impl.AdministratorServiceImpl;
import cn.bank.service.impl.CustomerServiceImpl;
import cn.bank.util.WebUtil;
/**
 * <p>Title: LoginServlet</p>
 * <p>Description:登录servlet </p>
 */

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	CustomerService customerService = new CustomerServiceImpl();
	AdministratorService adminService = new AdministratorServiceImpl();
	Customer cust = new Customer();
	Administrator admin = new Administrator();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unused")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String userNumber = request.getParameter("userNumber");
		String userPwd = request.getParameter("password");
		if(customerService.custLogin(userNumber, userPwd)==true){
			cust = customerService.queryCustomer(userNumber);
			System.out.println("进入顾客界面");
			session.setAttribute("current_user", cust);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		else if(adminService.adminLogin(userNumber, userPwd)==true){
			admin.setAdminName(userNumber);
			admin.setAdminPwd(userPwd);
			System.out.println("进入管理员页面");
			session.setAttribute("current_user", admin);
			WebUtil.forward(request, response, "admin.jsp");
		}
		else {
			WebUtil.forward(request, response, "loginFiled.jsp");
		}
	}
}
