package org.sophia.eorder.service;

import java.util.List;

import org.sophia.eorder.dao.IGenericDAO;
import org.springframework.transaction.annotation.Transactional;

/**
 * 通用Service类，主要调用通用dao类暴露的方法。
 * 
 * @author Administrator
 *
 * @param <T>
 */
@Transactional  
public class GenericService<T> implements IGenericService<T>{

	private Class<T> entityClass;  
	protected IGenericDAO<T> iGenericDAO;
	
	 public GenericService()
	 {
	    	
	 }
	 
    public GenericService(Class<T> clazz) {  
        this.entityClass = clazz;
    }  
        
    public void setIGenericService(IGenericDAO iGenericDAO)
	{
		this.iGenericDAO = iGenericDAO;
	}
    
	@Override
	public void add(T t) {
		// TODO Auto-generated method stub
		iGenericDAO.insert(t);
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		iGenericDAO.delete(t);
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		iGenericDAO.update(t);
	}

	@Override
	public T queryById(String id) {
		// TODO Auto-generated method stub
		T t = iGenericDAO.queryById(id);
		return t;
	}

	@Override
	public List<T> queryAll() {
		// TODO Auto-generated method stub
		return iGenericDAO.queryAll();
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public List<T> queryForPage(String hql, Object[] params, int recordNum,
			int startNum) {
		// TODO Auto-generated method stub
		return iGenericDAO.queryForPage(hql, params, recordNum, startNum);
	}

	@Override
	public List<T> queryForList(String hql, Object[] params) {
		// TODO Auto-generated method stub
		return iGenericDAO.queryForList(hql, params);
	}

}
