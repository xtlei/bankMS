package cn.bank.dao;

import java.util.List;

import cn.bank.entity.Business;

/**
 * <p>Title: BusinessDao</p>
 * <p>Description:银行流水Dao接口 </p>
 */
public interface BusinessDao {
	//添加账单
	public boolean addBusiness(Business business);
	//查询月账单
	public List<Business> queryMonthCheck(String custNumber, String date);
	//查询月账单明细
	public List<Business> showAllbusiness(String custNumber, String date);

}
