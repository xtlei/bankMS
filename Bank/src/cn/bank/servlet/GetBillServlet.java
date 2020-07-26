package cn.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bank.entity.Business;
import cn.bank.service.CustomerService;
import cn.bank.service.impl.CustomerServiceImpl;
import cn.bank.util.WebUtil;

/**
 * <p>Title: GetBillServlet</p>
 * <p>Description:获取月账单Servlet</p>
 */
@SuppressWarnings("serial")
public class GetBillServlet extends HttpServlet {
	CustomerService custService = new CustomerServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String custNumber = request.getParameter("gbs");
		String date = request.getParameter("queryDate");
		String pattern = "^\\d{4}-(0[1-9]|1[0-2])$";
		if (!date.matches(pattern)) {
			out.println("输入的日期格式错误！");
			return;
		}
		List<Business> list = custService.queryBill(custNumber, date);
		double moneySumOut = 0.0;
		double moneySumIn = 0.0;
		for (Business business : list) {
			if (business.getBusinessType().equals("取款")|business.getBusinessType().equals("转出")) {
				moneySumOut += business.getBusinessMoney();
			}
			if (business.getBusinessType().equals("存款")||business.getBusinessType().equals("转入")) {
				moneySumIn += business.getBusinessMoney();
			}
		}
		session.setAttribute("moneySumOut", String.valueOf(moneySumOut));
		session.setAttribute("moneySumIn", String.valueOf(moneySumIn));
		WebUtil.forward(request, response, "getBillResult.jsp");

	}
}
