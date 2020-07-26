package cn.bank.service;

import cn.bank.entity.Customer;

/**
 * <p>Title: AdministratorService</p>
 * <p>Description:管理员Service接口 </p>
 */
public interface AdministratorService {
	//增加用户
	public boolean addCustomer(Customer customer);
	//计算储蓄总额
	public double custMoneySum();
	//判断登录账号与密码是否匹配
	public boolean adminLogin(String adminNumber,String adminPwd);
}
