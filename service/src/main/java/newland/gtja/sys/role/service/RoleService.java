package newland.gtja.sys.role.service;

import java.util.List;

import commons.query.criterion.Page;
import newland.gtja.sys.role.cond.RoleCond;
import newland.gtja.sys.role.model.Role;

public interface RoleService {

	/**
	 * 增加
	 */
	public void addRole(Role role);

	/**
	 * 删除
	 */
	public void deleteRole(Role role);

	/**
	 * 批量删除
	 */
	public void batchDelRole(List<Role> roles);

	/**
	 * 修改
	 */
	public void updateRole(Role role);

	/**
	 * 分页查询
	 */
	public List<Role> findRoleByPage(RoleCond roleCond, Page page);

	/**
	 * 根据条件查询系统用户信息
	 */
	public List<Role> findRoleByCond(RoleCond roleCond);
	
	
	/**
	 * 根据条件查询第一个系统用户信息
	 */
	public Role findFirstCond(RoleCond roleCond);
}
