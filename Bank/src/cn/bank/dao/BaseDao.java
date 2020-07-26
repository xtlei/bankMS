package cn.bank.dao;

import java.sql.SQLException;

import cn.bank.util.JdbcUtil;

/**
 * <p>Title: BaseDao</p>
 * <p>Description:数据库建立连接接口</p>
 */
public class BaseDao {
public JdbcUtil util = null;
	
	public BaseDao(){
		try {
			util = JdbcUtil.createInstance();
			util.connectDB();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void finalize() throws Throwable{
		util.closeConn();
		super.finalize();
	}

}
