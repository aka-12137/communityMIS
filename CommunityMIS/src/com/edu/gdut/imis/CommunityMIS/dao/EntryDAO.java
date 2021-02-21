package com.edu.gdut.imis.CommunityMIS.dao;

import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.edu.gdut.imis.CommunityMIS.bean.Entry;

@Repository("EntryDAO")
public class EntryDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(EntryDAO.class);
	public static final String AID = "aid";
	public static final String UID = "uid";
	public static final String STATE = "state";
	public static final String NAME = "name";
	public static final String SEX = "sex";
	public static final String PHONE = "phone";
	public static final String BACKUP = "backup";

	protected void initDao() {
		
	}
	
	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	public void save(Entry transientInstance) {
		log.debug("saving Entry instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void update(Entry transientInstance) {
		log.debug("updating Entry instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public void delete(Entry persistentInstance) {
		log.debug("deleting Entry instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Entry findById(java.lang.Integer id) {
		log.debug("getting Entry instance with id: " + id);
		try {
			Entry instance = (Entry) getHibernateTemplate().get(
					"com.edu.gdut.imis.CommunityMIS.bean.Entry", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("rawtypes")
	public List findByExample(Entry instance) {
		log.debug("finding Entry instance by example");
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
		log.debug("finding Entry instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Entry as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List find(final Entry instance,final int start, final int end) {
		try {
			List results = (List) getHibernateTemplate().execute(
					new HibernateCallback() {

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							StringBuilder queryString = new StringBuilder(
									"from Entry as model where 1=1");
							if(instance.getAid()!=null){
								queryString.append(" and model.aid =")
								.append(instance.getAid())
								.append("");
							}
							
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
	public List findByAid(Object aid) {
		return findByProperty(AID, aid);
	}
	@SuppressWarnings("rawtypes")
	public List findByUid(Object uid) {
		return findByProperty(UID, uid);
	}
	@SuppressWarnings("rawtypes")
	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}
	@SuppressWarnings("rawtypes")
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}
	@SuppressWarnings("rawtypes")
	public List findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}
	@SuppressWarnings("rawtypes")
	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}
	@SuppressWarnings("rawtypes")
	public List findByBackup(Object backup) {
		return findByProperty(BACKUP, backup);
	}
	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all Entry instances");
		try {
			String queryString = "from Entry";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Entry merge(Entry detachedInstance) {
		log.debug("merging Entry instance");
		try {
			Entry result = (Entry) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Entry instance) {
		log.debug("attaching dirty Entry instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Entry instance) {
		log.debug("attaching clean Entry instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EntryDAO getFromApplicationContext(ApplicationContext ctx) {
		return (EntryDAO) ctx.getBean("EntryDAO");
	}
}
