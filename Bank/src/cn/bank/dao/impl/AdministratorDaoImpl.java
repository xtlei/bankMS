package cn.bank.dao.impl;

import java.sql.ResultSet;
import cn.bank.dao.AdministratorDao;
import cn.bank.dao.BaseDao;

/**
 * <p>Title: AdministratorDaoImpl</p>
 * <p>Description:管理员Dao接口实现类</p>
 */
public class AdministratorDaoImpl extends BaseDao implements AdministratorDao{

	@Override
	public double custMoneySum(){
		ResultSet resultSet = null;
		double sum = 0;
		String sql = "select sum(custMoney) as sumMoney from Customer";
        try {
			resultSet = util.executeQuery(sql,null);
			resultSet.next();
			sum = resultSet.getDouble("sumMoney");
//			System.out.println("custMoneySum");
			return sum;
		} catch (Exception e) {
		    e.printStackTrace();
		} 
		return sum;
	}

	@Override
	public boolean pwdIfCorrect(String adminNumber, String adminPwd) {
		ResultSet resultSet = null;
		
		String sql = "select * from Administrator where adminNumber = ? and adminPwd = ?";
		Object[] params = {adminNumber,adminPwd};
		
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
