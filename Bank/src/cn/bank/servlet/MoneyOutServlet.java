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
 * <p>Title: MoneyOutServlet</p>
 * <p>Description:取款Servlet </p>
 */
@SuppressWarnings("serial")
public class MoneyOutServlet extends HttpServlet {
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
		String custNumber = request.getParameter("mos");
		double money = Double.parseDouble(request.getParameter("moneyOut"));
		double leftMoney = custService.queryMoney(custNumber);
		if(money>leftMoney){
			out.println("余额不足！");
		}else{
			if(custService.moneyOut(custNumber, money)==1){
				out.println("取款成功！");
			}
		}
	}
}
