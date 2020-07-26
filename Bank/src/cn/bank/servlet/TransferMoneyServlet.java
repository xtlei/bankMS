package cn.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bank.service.CustomerService;
import cn.bank.service.impl.CustomerServiceImpl;

/**
 * <p>Title: TransferMoneyServlet</p>
 * <p>Description:转账Servlet </p>
 */
@SuppressWarnings("serial")
public class TransferMoneyServlet extends HttpServlet {
	CustomerService custService = new CustomerServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String custOut = request.getParameter("tms");
		String custIn = request.getParameter("targerCustNumber");
		double money = Double.parseDouble(request.getParameter("transferMoney"));
		String pattern1 = "^[1-9][0-9]{18}$";
		if (!custIn.matches(pattern1)) {
			out.println("输入客户卡号格式错误！");
			return;
		}
		if(custService.queryMoney(custOut)>money){
			if(custService.queryCustomer(custIn)!=null){
				if(custService.transferMoney(custIn, custOut, money)==1){
					out.println("转账成功！");
				}
			}else {
				out.println("用户不存在");
			}
		}else {
			out.println("余额不足！");
		}
	}
}
