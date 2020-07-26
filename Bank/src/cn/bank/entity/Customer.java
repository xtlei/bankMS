package cn.bank.entity;

import java.sql.Date;

/**
 * <p>Title: Customer</p>
 * <p>Description:普通用户实体类 </p>
 */
public class Customer{
	private String custNumber;
	private String custName;
	private String custPwd;
	private String custIdCard;
	private double custMoney;
	private Date custDate;
	public String getCustNumber() {
		return custNumber;
	}
	public void setCustNumber(String custNumber) {
		this.custNumber = custNumber;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustPwd() {
		return custPwd;
	}
	public void setCustPwd(String custPwd) {
		this.custPwd = custPwd;
	}
	public String getCustIdCard() {
		return custIdCard;
	}
	public void setCustIdCard(String custIdCard) {
		this.custIdCard = custIdCard;
	}
	public double getCustMoney() {
		return custMoney;
	}
	public void setCustMoney(double custMoney) {
		this.custMoney = custMoney;
	}
	public Date getCustDate() {
		return custDate;
	}
	public void setCustDate(Date custDate) {
		this.custDate = custDate;
	}
	
}
