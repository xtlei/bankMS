package cn.bank.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.bank.dao.BaseDao;
import cn.bank.dao.BusinessDao;
import cn.bank.entity.Business;
/**
 * <p>Title: BusinessDaoImpl</p>
 * <p>Description:银行流水dao接口实现类 </p>
 */

public class BusinessDaoImpl extends BaseDao implements BusinessDao{

	@Override
	public boolean addBusiness(Business business){
		int result = 0;
		Date date = new Date();
		@SuppressWarnings("unused")
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String sql=" insert into business(custNumber,businessType,businessMoney,businessDate) "
				+ "values(?,?,?,?)";
		Object [] params = {business.getCustNumber(),business.getBusinessType(),business.getBusinessMoney(),date};
		try {
				result = util.executeUpdate(sql, params);
				if(result > 0){
//					System.out.println("addBusiness_ok");
					return true;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return false;
	}

	@Override
	public List<Business> queryMonthCheck(String custNumber, String date){
		ResultSet resultSet = null;
		Business business = null;
		List<Business> businessList = null;
		
		String sql = " select businessType ,sum(businessMoney) as money from business "
				+"where left(businessDate,7)=? and custNumber=? "
				+"GROUP BY businessType";
		Object []params = {date,custNumber};
		try {
			resultSet = util.executeQuery(sql,params);
			businessList = new ArrayList<>();
			
			while(resultSet.next())
			{
				business = new Business();
				business.setBusinessType(resultSet.getString("businessType"));
				business.setBusinessMoney(resultSet.getDouble("money"));
				businessList.add(business);
			}
			return businessList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return businessList;
	}

	@Override
	public List<Business> showAllbusiness(String custNumber, String date){
		ResultSet resultSet = null;
		List<Business> businessList = null;
		Business business = null;
		
		String sql = "select * from business where custNumber=? and left(businessDate,7)=?";
		Object [] params = {custNumber,date};
		try {
			resultSet =util.executeQuery(sql,params);
			businessList = new ArrayList<>();
			
			while(resultSet.next())
			{
				business=new Business();
				business.setCustNumber(resultSet.getString("custNumber"));
				business.setBusinessType(resultSet.getString("businessType"));
				business.setBusinessMoney(resultSet.getDouble("businessMoney"));
				business.setBusinessDate(resultSet.getDate("businessDate"));
				businessList.add(business);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return businessList;
	}

}
