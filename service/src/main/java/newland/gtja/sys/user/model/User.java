package newland.gtja.sys.user.model;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * 系统用户表
 * 
 * @author 
 *
 */
@Entity
@Table(name="T_USER")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	/***
	 * 主键
	 */
	@TableGenerator(name = "T_USER", table = "hibernate_sequences",initialValue = 10000, allocationSize = 100)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "T_USER")
	@Column(name="I_USER",nullable = false)
	private Integer iuser;
	
	/***
	 * 账号
	 */
	@Column(name="ACCOUNTS")
	private String accounts;
	
	/***
	 * 密码
	 */
	@Column(name="PASSWORD")
	private String password;
	
	/***
	 * 部门
	 */
	@Column(name="DEPARTMENT")
	private String department;
	
	/***
	 * 职位
	 */
	@Column(name="POSITION")
	private String position;
	
	/***
	 * 姓名
	 */
	@Column(name="NAME")
	private String name;
	
	/***
	 * 用户类型
	 */
	@Column(name="USER_TYPE")
	private String userType;
	
	
	
	/***
	 * 角色
	 */
	@Column(name="ROLE")
	private String role;

	public Integer getIuser() {
		return iuser;
	}

	public void setIuser(Integer iuser) {
		this.iuser = iuser;
	}

	public String getAccounts() {
		return accounts;
	}

	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}
