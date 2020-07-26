package cn.bank.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.bank.dao.BaseDao;
import cn.bank.dao.CustomerDao;
import cn.bank.entity.Customer;
/**
 * <p>Title: CustomerDaoImpl</p>
 * <p>Description:普通用户Dao接口实现类 </p>
 */
public class CustomerDaoImpl extends BaseDao implements CustomerDao{

	@Override
	public boolean addCustomer(Customer customer) {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String custNumber = "62684" + sdf.format(date);
		
		String sql = "insert into customer VALUES (?, ?, ?, ?, ?, ?) ";
	   	Object[] params = {custNumber,customer.getCustName(),customer.getCustPwd(),customer.getCustIdCard(),customer.getCustMoney(),date};
        int result = 0;
		try {
			result = util.executeUpdate(sql, params);
			if (result > 0) {
//				System.out.println("addCustomer_insertok");
				return true;
			} 
		} catch (SQLException e1) {
			e1.printStackTrace();
		} 
		return true;
	}
	
	@Override
	public int updateCust(Customer customer,double money) {
		
		String sql = "update customer set custPwd=?,custMoney=? where custNumber = ?";
		try {
			Object [] params = {customer.getCustPwd(),customer.getCustMoney()+money,customer.getCustNumber()};
			if(util.executeUpdate(sql, params) > 0){
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Customer queryCust(String custNumber) {
		ResultSet resultSet = null;
		Customer customer = null;
		String sql="select * from customer where custNumber=?";
		Object[] params = {custNumber};
		try {
			customer = new Customer();
			resultSet = util.executeQuery(sql, params);
			
			while (resultSet.next())
			{
				customer.setCustNumber(resultSet.getString("custNumber"));
				customer.setCustName(resultSet.getString("custName"));
				customer.setCustPwd(resultSet.getString("custPwd"));
				customer.setCustIdCard(resultSet.getString("custIdCard"));
				customer.setCustMoney(resultSet.getDouble("custMoney"));
				customer.setCustDate(resultSet.getDate("custDate"));
			}
//			System.out.println("custQuery_ok");
			return customer;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public boolean pwdIfCorrect(String custNumber, String custPwd) {
		ResultSet resultSet = null;
		String sql = "select * from Customer where custNumber = ? and custPwd = ?";
		Object[] params = {custNumber,custPwd};
		
		try {
			resultSet = util.executeQuery(sql,params);
			resultSet.last();//指针移动到ResultSet的最后一行
			int i = resultSet.getRow();//返回当前行数
			if (i != 0) {
				return true;
			}
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return false;
	}

}
