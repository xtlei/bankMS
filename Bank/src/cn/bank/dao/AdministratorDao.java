package cn.bank.dao;

/**
 * <p>Title: AdministratorDao</p>
 * <p>Description:管理员Dao接口</p>
 */
public interface AdministratorDao {
	
	//计算储蓄总额
	public double custMoneySum();
	//判断登录账号与密码是否匹配
	public boolean pwdIfCorrect(String adminNumber,String adminPwd);

}
