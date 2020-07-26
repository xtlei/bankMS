package cn.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bank.entity.Customer;
import cn.bank.service.CustomerService;
import cn.bank.service.impl.CustomerServiceImpl;

/**
 * <p>Title: ChangePwdServlet</p>
 * <p>Description:修改密码Servlet </p>
 */
@SuppressWarnings("serial")
public class ChangePwdServlet extends HttpServlet {
	CustomerService custService = new CustomerServiceImpl();
	Customer cust = new Customer();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String custNumber = request.getParameter("cps");
		cust = custService.queryCustomer(custNumber);
		String pwd = request.getParameter("pwd");
		String pattern2 = "^[0-9]{6}$";
		if (!pwd.matches(pattern2)) {
			out.println("输入当前密码格式错误！");
			return;
		}
		if (cust.getCustPwd().equals(pwd)) {
			String newPwd = request.getParameter("newPwd");
			if (!newPwd.matches(pattern2)) {
				out.println("新密码格式错误");
				return;
			}
			cust.setCustPwd(newPwd);
			if(custService.changePwd(cust)==1){
				out.println("修改密码成功！");
			}
		}else {
			out.println("当前密码输入错误！");
		}
		

	}
}
