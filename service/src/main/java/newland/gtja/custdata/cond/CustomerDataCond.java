package newland.gtja.custdata.cond;

import java.util.Date;

import commons.query.criterion.Condition;
import commons.query.criterion.annotation.ConditionClass;
import commons.query.criterion.annotation.Expression;
import commons.query.criterion.annotation.Operator;
import newland.gtja.custdata.model.CustomerData;


@ConditionClass(CustomerData.class)
public class CustomerDataCond extends Condition {

	
	private static final long serialVersionUID = 1L;

	// 完全匹配id
	@Expression(operator = Operator.eq, propertyName = "icustomerData")
	private Integer icustomerData;
		
	// 模糊匹配客户姓名
	@Expression(operator = Operator.like, propertyName = "customerName")
	private String customerName;

	// 完全匹配营业部
	@Expression(operator = Operator.eq, propertyName = "businessDepartment")
	private String businessDepartment;

	// 完全匹配资金账号
	@Expression(operator = Operator.eq, propertyName = "capitalAccount")
	private Integer capitalAccount;

	// 司内最低资产
	@Expression(operator = Operator.ge, propertyName = "internalAssets")
	private Integer startInternalAssets;
	// 司内最高资产
	@Expression(operator = Operator.le, propertyName = "internalAssets")
	private Integer endInternalAssets;

	// 司外最低资产
	@Expression(operator = Operator.ge, propertyName = "extradivisionalAssets")
	private Integer startExtradivisionalAssets;
	// 司外最高资产
	@Expression(operator = Operator.le, propertyName = "extradivisionalAssets")
	private Integer endExtradivisionalAssets;

	// 前次起始营销时间
	@Expression(operator = Operator.ge, propertyName = "previousMarketingDate")
	private Date startPreviousMarketingDate;
	// 前次结束营销时间
	@Expression(operator = Operator.le, propertyName = "previousMarketingDate")
	private Date endPreviousMarketingDate;

	// 下次起始营销时间
	@Expression(operator = Operator.ge, propertyName = "nextMarketingDate")
	private Date startNextMarketingDate;
	// 下次结束营销时间
	@Expression(operator = Operator.le, propertyName = "nextMarketingDate")
	private Date endNextMarketingDate;
	
	public Integer getIcustomerData() {
		return icustomerData;
	}
	public void setIcustomerData(Integer icustomerData) {
		this.icustomerData = icustomerData;
	}
	public Integer getCapitalAccount() {
		return capitalAccount;
	}
	public void setCapitalAccount(Integer capitalAccount) {
		this.capitalAccount = capitalAccount;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getBusinessDepartment() {
		return businessDepartment;
	}
	public void setBusinessDepartment(String businessDepartment) {
		this.businessDepartment = businessDepartment;
	}
	public Integer getStartInternalAssets() {
		return startInternalAssets;
	}
	public void setStartInternalAssets(Integer startInternalAssets) {
		this.startInternalAssets = startInternalAssets;
	}
	public Integer getEndInternalAssets() {
		return endInternalAssets;
	}
	public void setEndInternalAssets(Integer endInternalAssets) {
		this.endInternalAssets = endInternalAssets;
	}
	public Integer getStartExtradivisionalAssets() {
		return startExtradivisionalAssets;
	}
	public void setStartExtradivisionalAssets(Integer startExtradivisionalAssets) {
		this.startExtradivisionalAssets = startExtradivisionalAssets;
	}
	public Integer getEndExtradivisionalAssets() {
		return endExtradivisionalAssets;
	}
	public void setEndExtradivisionalAssets(Integer endExtradivisionalAssets) {
		this.endExtradivisionalAssets = endExtradivisionalAssets;
	}
	public Date getStartPreviousMarketingDate() {
		return startPreviousMarketingDate;
	}
	public void setStartPreviousMarketingDate(Date startPreviousMarketingDate) {
		this.startPreviousMarketingDate = startPreviousMarketingDate;
	}
	public Date getEndPreviousMarketingDate() {
		return endPreviousMarketingDate;
	}
	public void setEndPreviousMarketingDate(Date endPreviousMarketingDate) {
		this.endPreviousMarketingDate = endPreviousMarketingDate;
	}
	public Date getStartNextMarketingDate() {
		return startNextMarketingDate;
	}
	public void setStartNextMarketingDate(Date startNextMarketingDate) {
		this.startNextMarketingDate = startNextMarketingDate;
	}
	public Date getEndNextMarketingDate() {
		return endNextMarketingDate;
	}
	public void setEndNextMarketingDate(Date endNextMarketingDate) {
		this.endNextMarketingDate = endNextMarketingDate;
	}
	
	
}
