package newland.gtja.base.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import commons.query.support.DaoExSupport;

public class BaseDao extends DaoExSupport {
	/**
	 * add for 声明式配置
	 */
	@Resource(name = "sessionFactory")
	public void setInjectSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

}
