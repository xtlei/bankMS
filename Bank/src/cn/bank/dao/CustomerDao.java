package cn.bank.dao;

import cn.bank.entity.Customer;

/**
 * <p>Title: CustomerDao</p>
 * <p>Description:普通用户dao接口</p>
 */
public interface CustomerDao {
	
	public boolean addCustomer(Customer customer);
	//更新用户信息
	public int updateCust(Customer customer,double money);
	//查询余额
	public Customer queryCust(String custNumber);
//	public double queryMoney(String custNumber);
	//判断登录账号与密码是否匹配
	public boolean pwdIfCorrect(String custNumber,String CustPwd);
	
}
