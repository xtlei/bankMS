package cn.bank.service.impl;

import java.sql.SQLException;
import java.util.List;

import cn.bank.dao.BusinessDao;
import cn.bank.dao.CustomerDao;
import cn.bank.dao.impl.BusinessDaoImpl;
import cn.bank.dao.impl.CustomerDaoImpl;
import cn.bank.entity.Business;
import cn.bank.entity.Customer;
import cn.bank.service.CustomerService;
import cn.bank.util.JdbcUtil;

/**
 * <p>Title: CustomerServiceImpl</p>
 * <p>Description:顾客Service接口实现类 </p>
 */
public class CustomerServiceImpl implements CustomerService{

	CustomerDao customerDao = new CustomerDaoImpl();
	BusinessDao businessDao = new BusinessDaoImpl();
	Customer customer = new Customer();
	Business business = new Business();

	@Override
	public boolean custLogin(String custNumber, String custPwd) {
		return customerDao.pwdIfCorrect(custNumber, custPwd);
	}
	
	@Override
	public int moneyIn(String custNumber, double money) {
		customer = customerDao.queryCust(custNumber);
		business.setCustNumber(custNumber);
		business.setBusinessMoney(money);
		business.setBusinessType("存款");
		int result = 0;
		try {
			JdbcUtil.beginTran();
			result = customerDao.updateCust(customer,money);
			businessDao.addBusiness(business);
			JdbcUtil.commitTran();
		} catch (SQLException e) {
			try {
				JdbcUtil.rollBack();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return result;
	}
	
	@Override
	public int moneyOut(String custNumber, double money) {
		customer = customerDao.queryCust(custNumber);
		business.setCustNumber(custNumber);
		business.setBusinessMoney(money);
		business.setBusinessType("取款");
		int result = 0;
		try {
			JdbcUtil.beginTran();
			if(customer.getCustMoney()>=money){
				result = customerDao.updateCust(customer,-money);
				businessDao.addBusiness(business);
			}else{
				result = 0;
			}
			JdbcUtil.commitTran();
		} catch (SQLException e) {
			try {
				JdbcUtil.rollBack();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return result;
	}
	
	@Override
	public int transferMoney(String customerIn, String customerOut, double money) {
		Customer custIn = customerDao.queryCust(customerIn);
		if (custIn.getCustNumber()!=null) {
			Customer custOut = customerDao.queryCust(customerOut);
			try {
				JdbcUtil.beginTran();
				if(custOut.getCustMoney() >= money){
					System.out.println("             转账中。。。。。");
					customerDao.updateCust(custOut,-money);
					business.setCustNumber(customerOut);
					business.setBusinessMoney(money);
					business.setBusinessType("转出");
					businessDao.addBusiness(business);
					
					customerDao.updateCust(custIn,money);
					business.setCustNumber(customerIn);
					business.setBusinessMoney(money);
					business.setBusinessType("转入");
					businessDao.addBusiness(business);
				}else{
					return 0;
				}
				JdbcUtil.commitTran();
			} catch (SQLException e) {
				try {
					JdbcUtil.rollBack();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}else{
			System.out.println("             用户不存在！");
			return 0;
		}
		return 1;
	}
	
	@Override
	public int changePwd(Customer customer) {
		return customerDao.updateCust(customer,0);
	}
	
	@Override
	public List<Business> queryBill(String custNumber, String date) {
		return businessDao.queryMonthCheck(custNumber,date);
	}
	
	@Override
	public double queryMoney(String custNumber) {
		return customerDao.queryCust(custNumber).getCustMoney();
	}

	@Override
	public List<Business> showAllbusiness(String custNumber, String date) {
		return businessDao.showAllbusiness(custNumber, date);
	}

	@Override
	public Customer queryCustomer(String custNumber) {
		return customerDao.queryCust(custNumber);
	}

}
