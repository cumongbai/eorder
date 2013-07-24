package org.sophia.eorder.dao;

import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 通用dao类，包含基本的数据库操作，如插入、更新、删除、通过id查询、分页查询等。
 * 
 * @author Administrator
 * 
 * @param <T>
 * 
 */
public class GenericDAO<T> implements IGenericDAO<T>{

	protected final Logger logger = Logger.getLogger(this.getClass());
	private Class<T> entityClass;  
	  
    public GenericDAO(Class<T> clazz) {  
        this.entityClass = clazz;
    }  
  
    public GenericDAO()
    {
    	
    }
    @Autowired
    @Qualifier("sessionFactory") 
    private SessionFactory sessionFactory;      
    
    @Override
    public void insert(T t) {
    	logger.info("Insert data:\n"+t);
        sessionFactory.getCurrentSession().save(t);  
    }  
  
    @Override
    public void delete(T t) {  
        sessionFactory.getCurrentSession().delete(t);  
    }  
  
    @Override
    public void update(T t) {  
        sessionFactory.getCurrentSession().update(t);  
    }  
  
    @SuppressWarnings("unchecked")  
    @Override
    public T queryById(String id) {
        return (T) sessionFactory.getCurrentSession().get(entityClass, id);  
    }  
  
    @Override
    public List<T> queryAll() {  
        String hql = "from " + entityClass.getSimpleName();  
        return queryForList(hql, null);  
    }  
  
    @SuppressWarnings("unchecked")  
    protected T queryForObject(String hql, Object[] params) {  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        setQueryParams(query, params);  
        return (T) query.uniqueResult();  
    }  
  
    @SuppressWarnings("unchecked")  
    protected T queryForTopObject(String hql, Object[] params) {  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        setQueryParams(query, params);  
        return (T) query.setFirstResult(0).setMaxResults(1).uniqueResult();  
    }  
  
    @SuppressWarnings("unchecked")  
    public List<T> queryForList(String hql, Object[] params) {  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        setQueryParams(query, params);  
        return query.list();  
    }  
  
    @SuppressWarnings("unchecked")  
    protected List<T> queryForList(final String hql, final Object[] params,  
            final int recordNum) {  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        setQueryParams(query, params);  
        return query.setFirstResult(0).setMaxResults(recordNum).list();  
    }  
    
    @Override
    @SuppressWarnings("unchecked")  
    public List<T> queryForPage(final String hql, final Object[] params,  
            final int recordNum, final int startNum) {  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        setQueryParams(query, params);  
        return query.setFirstResult(startNum).setMaxResults(recordNum).list();  
    } 
  
    private void setQueryParams(Query query, Object[] params) {  
        if (null == params) {  
            return;  
        }  
        for (int i = 0; i < params.length; i++) {  
            query.setParameter(i, params[i]);  
        }  
    }   
}
