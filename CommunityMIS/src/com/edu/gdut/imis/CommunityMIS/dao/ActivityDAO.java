package com.edu.gdut.imis.CommunityMIS.dao;

import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import com.edu.gdut.imis.CommunityMIS.bean.Activity;

@Repository("ActivityDAO")
public class ActivityDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(ActivityDAO.class);
	public static final String TITLE = "title";
	public static final String LITITLE = "lititle";
	public static final String CONTENT = "content";
	public static final String IS_TOP = "isTop";
	public static final String IS_TUIJIAN = "isTuijian";
	public static final String TID = "tid";
	public static final String PID = "pid";
	public static final String THEME = "theme";

	protected void initDao() {
	
	}
	
	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}
	public void save(Activity transientInstance) {
		log.debug("saving Activity instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void update(Activity transientInstance) {
		log.debug("updating Activity instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public void delete(Activity persistentInstance) {
		log.debug("deleting Activity instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Activity findById(java.lang.Integer id) {
		log.debug("getting Activity instance with id: " + id);
		try {
			Activity instance = (Activity) getHibernateTemplate().get(
					"com.edu.gdut.imis.CommunityMIS.bean.Activity", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	@SuppressWarnings("rawtypes")
	public List findByExample(Activity instance) {
		log.debug("finding Activity instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	@SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Activity instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Activity as model where model."
					+ propertyName + "= ?  order by model.isTop desc,model.shunxu asc,model.createdate desc";
			getHibernateTemplate().setCacheQueries(true); 
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List find(final Activity instance,final int start, final int end) {
		try {
			List results = (List) getHibernateTemplate().execute(
					new HibernateCallback() {

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							StringBuilder queryString = new StringBuilder(
									"from Activity as model where 1=1");
							queryString.append(" order by model.createdate desc");
							Query query = session.createQuery(queryString
									.toString());
							return query.setFirstResult(start)
									.setMaxResults(end).list();
						}
					});

			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	@SuppressWarnings("rawtypes")
	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}
	@SuppressWarnings("rawtypes")
	public List findByLititle(Object lititle) {
		return findByProperty(LITITLE, lititle);
	}
	@SuppressWarnings("rawtypes")
	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}
	@SuppressWarnings("rawtypes")
	public List findByIsTop(Object isTop) {
		return findByProperty(IS_TOP, isTop);
	}
	@SuppressWarnings("rawtypes")
	public List findByIsTuijian(Object isTuijian) {
		return findByProperty(IS_TUIJIAN, isTuijian);
	}
	@SuppressWarnings("rawtypes")
	public List findByTid(Object tid) {
		return findByProperty(TID, tid);
	}
	@SuppressWarnings("rawtypes")
	public List findlistByTid(Object tid) {
		log.debug("finding all Activity instances");
		try {
			String queryString = "from Activity where tid=?  order by model.isTop desc,model.shunxu asc,model.createdate desc";
			return getHibernateTemplate().find(queryString,tid);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@SuppressWarnings("rawtypes")
	public List findByPid(Object pid) {
		return findByProperty(PID, pid);
	}
	
	@SuppressWarnings("rawtypes")
	public List findByTheme(Object theme) {
		return findByProperty(THEME, theme);
	}
	
	@SuppressWarnings("rawtypes")
	public List findlistByTheme(Object theme) {
		log.debug("finding all Activity instances");
		try {
			String queryString = "from Activity where theme=? ";
			return getHibernateTemplate().find(queryString,theme);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	
	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all Activity instances");
		try {
			String queryString = "from Activity";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Activity merge(Activity detachedInstance) {
		log.debug("merging Activity instance");
		try {
			Activity result = (Activity) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Activity instance) {
		log.debug("attaching dirty Activity instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Activity instance) {
		log.debug("attaching clean Activity instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ActivityDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ActivityDAO) ctx.getBean("ActivityDAO");
	}
}
