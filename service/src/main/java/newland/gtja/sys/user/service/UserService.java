package newland.gtja.sys.user.service;

import java.util.List;

import commons.query.criterion.Page;
import newland.gtja.sys.user.cond.UserCond;
import newland.gtja.sys.user.model.User;

public interface UserService {
	/**
	 * 登陆
	 */
	public User checkUserLogin(String accounts,String password);
	
	/**
	 * 保存用户信息
	 */
	public void save(User user);
	
	/**
	 * 删除用户信息
	 */
	public void delete(User user);
	
	/**
	 * 修改用户信息
	 */
	public void update(User user);
	
	
	
	/**
	 * 分页条件查询用户信息
	 * 
	 * @param cond
	 *            查询条件
	 * 
	 * @param page
	 *            分页条件
	 */
	public List<User> findByPage(UserCond cond, Page page);
	
	
	
	/**
	 * 根据条件查询用户信息
	 */
	public List<User> findByCond(UserCond cond);
	
	public User findByAccounts(String accounts);
	
	public void batchdel(List<User> users);
	
	public User findFirstCond(UserCond userCond);
}
