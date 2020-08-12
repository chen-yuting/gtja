package newland.gtja.sys.role.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import commons.query.criterion.Page;
import newland.gtja.sys.role.cond.RoleCond;
import newland.gtja.sys.role.dao.RoleDao;
import newland.gtja.sys.role.model.Role;
import newland.gtja.sys.role.service.RoleService;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

	@Resource(name = "roleDao")
	private RoleDao roleDao;

	@Override
	public void addRole(Role role) {
		// TODO Auto-generated method stub
		roleDao.save(role);
	}

	@Override
	public void deleteRole(Role role) {
		// TODO Auto-generated method stub
		roleDao.delete(role);
	}

	@Override
	public void batchDelRole(List<Role> roles) {
		// TODO Auto-generated method stub
		roleDao.getHibernateTemplate().deleteAll(roles);
	}

	@Override
	public void updateRole(Role role) {
		// TODO Auto-generated method stub
		roleDao.update(role);
	}

	@Override
	public List<Role> findRoleByPage(RoleCond roleCond, Page page) {
		// TODO Auto-generated method stub
		return roleDao.findByCond(roleCond, page);
	}

	@Override
	public List<Role> findRoleByCond(RoleCond roleCond) {
		// TODO Auto-generated method stub
		return roleDao.findByCond(roleCond);
	}

	@Override
	public Role findFirstCond(RoleCond roleCond) {
		// TODO Auto-generated method stub
		return roleDao.getFirstByCond(roleCond);
	}

}
