package cn.bank.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bank.util.WebUtil;

/**
 * <p>Title: BaseServlet</p>
 * <p>Description:基本页面转换Servlet </p>
 */
@SuppressWarnings("serial")
public class BaseServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		//获取不同jsp上传的id
		String p = request.getParameter("p");
		String custNumber = request.getParameter("mis");
		String custNumber1 = request.getParameter("mos");
		String custNumber2 = request.getParameter("tms");
		String custNumber3 = request.getParameter("gbs");
		String custNumber4 = request.getParameter("cps");
		if(p!=null&&!p.equals("")){
			WebUtil.forward(request, response, "addCust.jsp");
		}
				
		else if(custNumber!=null&&!custNumber.equals("")){
			session.setAttribute("custNumber", custNumber);
			WebUtil.forward(request, response, "moneyIn.jsp");
		}
				
		else if(custNumber1!=null&&!custNumber1.equals("")){
			session.setAttribute("custNumber1", custNumber1);
			WebUtil.forward(request, response, "moneyOut.jsp");
		}
				
		else if(custNumber2!=null&&!custNumber2.equals("")){
			session.setAttribute("custNumber2", custNumber2);
			WebUtil.forward(request, response, "transferMoney.jsp");
		}
				
		else if(custNumber3!=null&&!custNumber3.equals("")){
			session.setAttribute("custNumber3", custNumber3);
			WebUtil.forward(request, response, "getBill.jsp");
		}	
		
		else if(custNumber4!=null&&!custNumber4.equals("")){
			session.setAttribute("custNumber4", custNumber4);
			WebUtil.forward(request, response, "changePwd.jsp");
		}		
	}
}
