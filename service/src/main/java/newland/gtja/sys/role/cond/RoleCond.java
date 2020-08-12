package newland.gtja.sys.role.cond;

import java.util.Date;

import commons.query.criterion.Condition;
import commons.query.criterion.annotation.ConditionClass;
import commons.query.criterion.annotation.Expression;
import commons.query.criterion.annotation.Operator;
import newland.gtja.sys.role.model.Role;

/**
 * 系统用户表查询实体
 */
@ConditionClass(Role.class)
public class RoleCond extends Condition {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 完全匹配id
	@Expression(operator = Operator.eq, propertyName = "irole")
	private Integer irole;

	// 模糊匹配角色名
	@Expression(operator = Operator.like, propertyName = "roleName")
	private String roleName;

	// 大于创建时间
	@Expression(operator = Operator.ge, propertyName = "crtTime")
	private Date beginCrtTime;

	// 小于创建时间
	@Expression(operator = Operator.le, propertyName = "crtTime")
	private Date endCrtTime;

	public Integer getIrole() {
		return irole;
	}

	public void setIrole(Integer irole) {
		this.irole = irole;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public Date getBeginCrtTime() {
		return beginCrtTime;
	}

	public void setBeginCrtTime(Date beginCrtTime) {
		this.beginCrtTime = beginCrtTime;
	}

	public Date getEndCrtTime() {
		return endCrtTime;
	}

	public void setEndCrtTime(Date endCrtTime) {
		this.endCrtTime = endCrtTime;
	}

}
