package newland.gtja.base.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import commons.query.support.GenericDaoExSupport;


public class GenericBaseDao<T> extends GenericDaoExSupport<T> {
	/**
	 * add for 声明式配置
	 */
	@Resource(name = "sessionFactory")
	final public void setInjectSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

}
