package cn.bank.service.impl;

import cn.bank.dao.AdministratorDao;
import cn.bank.dao.CustomerDao;
import cn.bank.dao.impl.AdministratorDaoImpl;
import cn.bank.dao.impl.CustomerDaoImpl;
import cn.bank.entity.Customer;
import cn.bank.service.AdministratorService;

/**
 * <p>Title: AdministratorServiceImpl</p>
 * <p>Description:管理员Service接口实现类 </p>
 */
public class AdministratorServiceImpl implements AdministratorService{

	private AdministratorDao administratorDao = new AdministratorDaoImpl();
	private CustomerDao customerDao = new CustomerDaoImpl();
	
	@Override
	public boolean addCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}

	@Override
	public boolean adminLogin(String adminNumber, String adminPwd) {
		return administratorDao.pwdIfCorrect(adminNumber, adminPwd);
	}

	@Override
	public double custMoneySum() {
		return administratorDao.custMoneySum();
	}

}
