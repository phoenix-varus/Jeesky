package org.iskycode.jeesky.sys.dao;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author phoenix
 *
 * @param <T>
 * 
 *            公共数据操作类
 */
@Component
public class BaseDao<T> {

	@Autowired
	SessionFactory sf;

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * java反射获取泛型类型
	 *
	 * @param
	 * @return Class<?>
	 */
	public Class<?> getEntityClass() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		return (Class<?>) params[0];
	}

	// ---------------------------------------hibernate-session---------------------------------------

	public Object save(Object entity) {
		getSession().getTransaction().begin();
		Object obj = getSession().save(entity);
		getSession().getTransaction().commit();
		return obj;
	}

	public void update(Object entity) {
		getSession().getTransaction().begin();
		getSession().update(entity);
		getSession().getTransaction().commit();
	}

	public void saveOrUpdate(Object entity) {
		getSession().getTransaction().begin();
		getSession().saveOrUpdate(entity);
		getSession().getTransaction().commit();
	}

	public void merge(Object entity) {
		getSession().getTransaction().begin();
		getSession().merge(entity);
		getSession().getTransaction().commit();
	}

	public void delete(Object entity) {
		getSession().getTransaction().begin();
		getSession().delete(entity);
		getSession().getTransaction().commit();
	}

	public void flush() {
		getSession().flush();
	}

	public void clear() {
		getSession().clear();
	}

	@SuppressWarnings("deprecation")
	public Session getSession() {
		sf.getCurrentSession().setFlushMode(FlushMode.AUTO);
		return sf.getCurrentSession();
	}

	// ---------------------------------------hibernateTemplate---------------------------------------

	public Object load(String id) {
		return hibernateTemplate.load(getEntityClass(), id);
	}

	@SuppressWarnings("unchecked")
	public List<T> loadAll() {
		return hibernateTemplate.loadAll((Class<T>) getEntityClass());
	}

	public List<?> find(String sql, Object... params) {
		return hibernateTemplate.find(sql, params);
	}

	public List<T> findByExample(T entity) {
		return hibernateTemplate.findByExample(entity);
	}

	// ---------------------------------------jdbcTemplate---------------------------------------

	@SuppressWarnings("rawtypes")
	public Map queryForMap(String sql) {
		return jdbcTemplate.queryForMap(sql);
	}

	@SuppressWarnings("rawtypes")
	public List queryForList(String sql) {
		return jdbcTemplate.queryForList(sql);
	}

	public void execute(String sql) {
		jdbcTemplate.execute(sql);
	}

	public int[] batchUpdate() {
		return jdbcTemplate.batchUpdate();
	}
}
