package newland.gtja.sys.user.cond;

import commons.query.criterion.Condition;
import commons.query.criterion.annotation.ConditionClass;
import commons.query.criterion.annotation.Expression;
import commons.query.criterion.annotation.Operator;
import newland.gtja.sys.user.model.User;

/**
 * 系统用户表查询实体
 */
@ConditionClass(User.class)
public class UserCond extends Condition {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// 完全匹配id
	@Expression(operator = Operator.eq, propertyName = "iuser")
	private Integer iuser;
	
	// 完全匹配账号
	@Expression(operator = Operator.eq, propertyName = "accounts")
	private String accounts;

	// 完全匹配姓名
	@Expression(operator = Operator.eq, propertyName = "name")
	private String name;

	// 完全匹配用户类型
	@Expression(operator = Operator.eq, propertyName = "userType")
	private String userType;

	// 完全匹配角色
	@Expression(operator = Operator.eq, propertyName = "role")
	private String role;

	public String getAccounts() {
		return accounts;
	}

	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getIuser() {
		return iuser;
	}

	public void setIuser(Integer iuser) {
		this.iuser = iuser;
	}

	
}