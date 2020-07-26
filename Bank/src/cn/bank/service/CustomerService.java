package cn.bank.service;

import java.util.List;

import cn.bank.entity.Business;
import cn.bank.entity.Customer;

/**
 * <p>Title: CustomerService</p>
 * <p>Description:顾客service接口类 </p>
 */
public interface CustomerService {
	//登录
	public boolean custLogin(String custNumber,String custPwd);
	//查询余额
	public double queryMoney(String custNumber);
	//查询用户
	public Customer queryCustomer(String custNumber);
	//存款
	public int moneyIn(String custNumber,double money);
	//取款
	public int moneyOut(String custNumber,double money);
	//转账
	public int transferMoney(String custIn,String custOut,double money);
	//修改密码
	public int changePwd(Customer customer);
	//查询月账单
	public List<Business> queryBill(String custNumber,String date);
	//查询月账单明细
	public List<Business> showAllbusiness(String custNumber, String date);
}
