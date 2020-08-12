package newland.gtja.sys.role.model;

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

/**
 * 角色表
 * 
 * @author
 *
 */
@Entity
@Table(name = "T_ROLE")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/***
	 * 主键
	 */
	@Id
	@TableGenerator(name = "T_ROLE", table = "hibernate_sequences", initialValue = 10000, allocationSize = 100)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "T_ROLE")
	@Column(name = "I_ROLE", nullable = false)
	private Integer irole;

	/***
	 * 角色名
	 */
	@Column(name = "ROLE_NAME")
	private String roleName;

	/***
	 * 描述
	 */
	@Column(name = "DESCRIPTION")
	private String description;

	/***
	 * 创建时间
	 */
	@JSONField(format = "yyyy-MM-dd")
	@Column(name = "CRT_TIME")
	private Date crtTime;

	/***
	 * 修改时间
	 */
	@JSONField(format = "yyyy-MM-dd")
	@Column(name = "UPD_TIME")
	private Date updTime;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}

	public Date getUpdTime() {
		return updTime;
	}

	public void setUpdTime(Date updTime) {
		this.updTime = updTime;
	}

}
