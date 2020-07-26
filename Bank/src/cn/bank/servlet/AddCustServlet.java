package cn.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bank.entity.Customer;
import cn.bank.service.AdministratorService;
import cn.bank.service.impl.AdministratorServiceImpl;

/**
 * <p>Title: AddCustServlet</p>
 * <p>Description:增加用户Servlet</p>
 */
@SuppressWarnings("serial")
public class AddCustServlet extends HttpServlet {
	
	AdministratorService adminService = new AdministratorServiceImpl();
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
	
		String pattern1 = "^[a-zA-Z\u4e00-\u9fa5]{1,}$";
  		String pattern = "^[0-9]{6}$";
  		String pattern3 = "[1-9][0-9]{16}[0-9X]$";
  		String custName = request.getParameter("custName");
  		String custPwd = request.getParameter("custPwd");
  		String custId = request.getParameter("custId");
  		double custMoney = Double.parseDouble(request.getParameter("custMoney"));
		if (!custName.matches(pattern1)) {
			out.println("客户名格式错误！");
			return;
		}
		if (!custPwd.matches(pattern)) {
			out.println("客户密码格式错误！");
			return;
		}
		if (!custId.matches(pattern3)) {
			out.println("客户身份证号格式错误");
			return;
		}
  		cust.setCustName(custName);
		cust.setCustPwd(custPwd);
		cust.setCustIdCard(custId);
		cust.setCustMoney(custMoney);
	
		if(adminService.addCustomer(cust)==true){
			out.print("添加成功~");
		}else{
			out.print("添加失败!!!");
		}
	}
}
