package newland.gtja.sys.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import commons.query.criterion.Page;
import newland.gtja.sys.user.cond.UserCond;
import newland.gtja.sys.user.dao.UserDao;
import newland.gtja.sys.user.model.User;
import newland.gtja.sys.user.service.UserService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zsn
 *
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Resource(name = "userDao")
	private UserDao userDao;

	@Override
	public User checkUserLogin(String accounts, String password) {
		// TODO Auto-generated method stub

		// 根据传入的用户账号查找数据库是否存在
		UserCond userCond = new UserCond();
		userCond.setAccounts(accounts);
		List<User> users = userDao.findByCond(userCond);
		// 如果size=0，说明不存在，而且符合条件的用户就只有一个
		if (users.size() != 0) {
			User user = users.get(0);
			if (user.getPassword().equals(password)) {
				return user;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);

	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		userDao.delete(user);

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);

	}

	@Override
	public List<User> findByPage(UserCond cond, Page page) {
		// TODO Auto-generated method stub

		return userDao.findByCond(cond, page);
	}

	@Override
	public List<User> findByCond(UserCond cond) {
		// TODO Auto-generated method stub
		return userDao.findByCond(cond);
	}

	@Override
	public User findByAccounts(String accounts) {
		// TODO Auto-generated method stub
		UserCond userCond = new UserCond();
		userCond.setAccounts(accounts);
		List<User> users = findByCond(userCond);
		if (users.size() == 0) {
			return null;
		} else {
			// accounts唯一，能查到只能查到一个
			return users.get(0);
		}
	}

	@Override
	public void batchdel(List<User> users) {
		// TODO Auto-generated method stub
		userDao.getHibernateTemplate().deleteAll(users);
	}

	@Override
	public User findFirstCond(UserCond userCond) {
		// TODO Auto-generated method stub
		return userDao.getFirstByCond(userCond);
	}

}
