package cn.bank.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bank.service.CustomerService;
import cn.bank.service.impl.CustomerServiceImpl;
import cn.bank.util.WebUtil;

/**
 * <p>Title: ItemsQueryVo</p>
 * <p>Description:商品包装对象 </p>
 */
@SuppressWarnings("serial")
public class queryMoneyServlet extends HttpServlet {
	CustomerService custService = new CustomerServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		String custNumber = request.getParameter("qms");
		double money = custService.queryMoney(custNumber);
		session.setAttribute("queryMoney", money);
		WebUtil.forward(request, response, "queryMoney.jsp");

		
	}

}
