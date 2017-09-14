package org.iskycode.jeesky.sys.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

@Transactional
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

    //---------------------------------------hibernate---------------------------------------

    public Object save(Object entity) {
        return hibernateTemplate.save(entity);
    }

    public void update(Object entity) {
        hibernateTemplate.update(entity);
    }

    public void saveOrUpdate(Object entity) {
        hibernateTemplate.saveOrUpdate(entity);
    }

    public void delete(Object entity) {
        hibernateTemplate.delete(entity);
    }

    public void flush() {
        getSession().flush();
    }

    public void clear() {
        getSession().clear();
    }

    public Session getSession() {
        return sf.getCurrentSession();
    }

    //---------------------------------------hibernate---------------------------------------

    public Object load(String id) {
        return hibernateTemplate.load(getEntityClass(), id);
    }

    public List<T> loadAll() {
        return hibernateTemplate.loadAll((Class<T>) getEntityClass());
    }

    public List<?> find(String sql, Object... params) {
        return hibernateTemplate.find(sql, params);
    }

    public List<T> findByExample(T entity) {
        return hibernateTemplate.findByExample(entity);
    }

    //---------------------------------------jdbcTemplate---------------------------------------

    public Map queryForMap(String sql) {
        return jdbcTemplate.queryForMap(sql);
    }

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
