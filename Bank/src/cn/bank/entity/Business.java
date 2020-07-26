package cn.bank.entity;

import java.util.Date;

/**
 * <p>Title: Business</p>
 * <p>Description:银行流水实体类 </p>
 */
public class Business {
	int businessNumber;
	String custNumber;
	String businessType;
	double businessMoney;
	Date businessDate;
	public int getBusinessNumber() {
		return businessNumber;
	}
	public void setBusinessNumber(int businessNumber) {
		this.businessNumber = businessNumber;
	}
	public String getCustNumber() {
		return custNumber;
	}
	public void setCustNumber(String custNumber) {
		this.custNumber = custNumber;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	public double getBusinessMoney() {
		return businessMoney;
	}
	public void setBusinessMoney(double businessMoney) {
		this.businessMoney = businessMoney;
	}
	public Date getBusinessDate() {
		return businessDate;
	}
	public void setBusinessDate(Date businessDate) {
		this.businessDate = businessDate;
	}
	@Override
	public String toString() {
		return "Business [businessNumber=" + businessNumber + ", custNumber="
				+ custNumber + ", businessType=" + businessType
				+ ", businessMoney=" + businessMoney + ", businessDate="
				+ businessDate + "]";
	}
}
