package newland.gtja.custdata.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.alibaba.fastjson.annotation.JSONField;

@Entity
@Table(name = "T_CUSTOMER_DATA")
public class CustomerData implements Serializable {

	private static final long serialVersionUID = 1L;

	// 主键
	@Id
	@TableGenerator(name = "T_CUSTOMER_DATA", table = "hibernate_sequences",initialValue = 10000, allocationSize = 100)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "T_CUSTOMER_DATA")
	@Column(name = "I_CUSTOMER_DATA", nullable = false)
	private Integer icustomerData;

	// 客户姓名
	@Column(name = "CUSTOMER_NAME")
	private String customerName;

	// 营业部
	@Column(name = "BUSINESS_DEPARTMENT")
	private String businessDepartment;

	// 资金账号
	@Column(name = "CAPITAL_ACCOUNT")
	private Integer capitalAccount;

	// 性别
	@Column(name = "GENDER")
	private String gender;

	// 出生年份
	@Column(name = "YEAR_OF_BIRTH")
	private Integer yearOfBirth;

	// 职业
	@Column(name = "OCCUPATION")
	private String occupation;

	// 开户时间
	@Column(name = "ACCOUNT_OPENING_DATE")
	@JSONField(format = "yyyy-MM-dd")
	private Date accountOpeningDate;

	// 司内资产
	@Column(name = "INTERNAL_ASSETS")
	private Integer internalAssets;

	// 司外资产
	@Column(name = "EXTRADIVISIONAL_ASSETS")
	private Integer extradivisionalAssets;

	// 司内资产类别
	@Column(name = "INTERNAL_ASSETS_TYPE")
	private String internalAssetsType;

	// 用户画像
	@Column(name = "USER_PROTRAIT")
	private String userProtrait;

	// 投资偏好
	@Column(name = "INVESTMENT_PREFERENCE")
	private String investmentPreference;

	// 流动性要求
	@Column(name = "LIQUIDITY_REQUIREMENTS")
	private String liquidityRequirements;

	// 外部资源
	@Column(name = "EXTERNAL_RESOURCES")
	private String externalResources;

	// 其他备注
	@Column(name = "OTHER_REMARKS")
	private String otherRemarks;

	// 子女情况
	@Column(name = "CHILDREN_SITUATION")
	private String childrenSituation;

	// 子女年龄
	@Column(name = "CHILDREN_AGE")
	private String childrenAge;

	// 前次营销内容
	@Column(name = "PREVIOUS_MARKETING_CONTENT")
	private String previousMarketingContent;

	// 前次营销时间
	@Column(name = "PREVIOUS_MARKETING_DATE")
	@JSONField(format = "yyyy-MM-dd")
	private Date previousMarketingDate;

	// 客户反馈及需求
	@Column(name = "CUSTOMER_FEEDBACK")
	private String customerFeedback;

	// 下次营销目标
	@Column(name = "NEXT_MARKETING_TARGET")
	private String nextMarketingTarget;

	// 下次营销时间
	@Column(name = "NEXT_MARKETING_DATE")
	@JSONField(format = "yyyy-MM-dd")
	private Date nextMarketingDate;

	// 营销内容
	@Column(name = "MARKETING_CONTENT")
	private String marketingContent;

	public Integer getIcustomerData() {
		return icustomerData;
	}

	public void setIcustomerData(Integer icustomerData) {
		this.icustomerData = icustomerData;
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

	public Integer getCapitalAccount() {
		return capitalAccount;
	}

	public void setCapitalAccount(Integer capitalAccount) {
		this.capitalAccount = capitalAccount;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(Integer yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Date getAccountOpeningDate() {
		return accountOpeningDate;
	}

	public void setAccountOpeningDate(Date accountOpeningDate) {
		this.accountOpeningDate = accountOpeningDate;
	}

	public Integer getInternalAssets() {
		return internalAssets;
	}

	public void setInternalAssets(Integer internalAssets) {
		this.internalAssets = internalAssets;
	}

	public Integer getExtradivisionalAssets() {
		return extradivisionalAssets;
	}

	public void setExtradivisionalAssets(Integer extradivisionalAssets) {
		this.extradivisionalAssets = extradivisionalAssets;
	}

	public String getInternalAssetsType() {
		return internalAssetsType;
	}

	public void setInternalAssetsType(String internalAssetsType) {
		this.internalAssetsType = internalAssetsType;
	}

	public String getUserProtrait() {
		return userProtrait;
	}

	public void setUserProtrait(String userProtrait) {
		this.userProtrait = userProtrait;
	}

	public String getInvestmentPreference() {
		return investmentPreference;
	}

	public void setInvestmentPreference(String investmentPreference) {
		this.investmentPreference = investmentPreference;
	}

	public String getLiquidityRequirements() {
		return liquidityRequirements;
	}

	public void setLiquidityRequirements(String liquidityRequirements) {
		this.liquidityRequirements = liquidityRequirements;
	}

	public String getExternalResources() {
		return externalResources;
	}

	public void setExternalResources(String externalResources) {
		this.externalResources = externalResources;
	}

	public String getOtherRemarks() {
		return otherRemarks;
	}

	public void setOtherRemarks(String otherRemarks) {
		this.otherRemarks = otherRemarks;
	}

	public String getChildrenSituation() {
		return childrenSituation;
	}

	public void setChildrenSituation(String childrenSituation) {
		this.childrenSituation = childrenSituation;
	}

	public String getChildrenAge() {
		return childrenAge;
	}

	public void setChildrenAge(String childrenAge) {
		this.childrenAge = childrenAge;
	}

	public String getPreviousMarketingContent() {
		return previousMarketingContent;
	}

	public void setPreviousMarketingContent(String previousMarketingContent) {
		this.previousMarketingContent = previousMarketingContent;
	}

	public Date getPreviousMarketingDate() {
		return previousMarketingDate;
	}

	public void setPreviousMarketingDate(Date previousMarketingDate) {
		this.previousMarketingDate = previousMarketingDate;
	}

	public String getCustomerFeedback() {
		return customerFeedback;
	}

	public void setCustomerFeedback(String customerFeedback) {
		this.customerFeedback = customerFeedback;
	}

	public String getNextMarketingTarget() {
		return nextMarketingTarget;
	}

	public void setNextMarketingTarget(String nextMarketingTarget) {
		this.nextMarketingTarget = nextMarketingTarget;
	}

	public Date getNextMarketingDate() {
		return nextMarketingDate;
	}

	public void setNextMarketingDate(Date nextMarketingDate) {
		this.nextMarketingDate = nextMarketingDate;
	}

	public String getMarketingContent() {
		return marketingContent;
	}

	public void setMarketingContent(String marketingContent) {
		this.marketingContent = marketingContent;
	}
	
}
