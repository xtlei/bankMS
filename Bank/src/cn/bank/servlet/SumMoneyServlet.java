package cn.bank.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bank.service.AdministratorService;
import cn.bank.service.impl.AdministratorServiceImpl;
import cn.bank.util.WebUtil;

/**
 * <p>Title: SumMoneyServlet</p>
 * <p>Description:计算储蓄总额Servlet </p>
 */
@SuppressWarnings("serial")
public class SumMoneyServlet extends HttpServlet {

	AdministratorService adminService = new AdministratorServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		
		double sumMoney = adminService.custMoneySum();
		session.setAttribute("sumMoney", sumMoney);
		WebUtil.forward(request, response, "sumMoney.jsp");
	}
}
