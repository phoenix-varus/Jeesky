package org.iskycode.jeesky.sys.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

@Component
public class BaseDao<T> {

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

    public void flush() {
        hibernateTemplate.flush();
    }

    public void clear() {
        hibernateTemplate.clear();
    }


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
