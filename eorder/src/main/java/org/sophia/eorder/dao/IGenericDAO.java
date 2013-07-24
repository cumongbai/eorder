package org.sophia.eorder.dao;

import java.util.List;

/**
 * 通用dao接口
 * @author Administrator
 *
 * @param <T>
 */
public interface IGenericDAO<T> {
	void insert(T t);  
	  
    void delete(T t);  
  
    void update(T t);  
  
    T queryById(String id);  
  
    List<T> queryAll(); 
    
    List<T> queryForPage(String hql, Object[] params, int recordNum, int startNum);
    
    List<T> queryForList(String hql, Object[] params);
}
