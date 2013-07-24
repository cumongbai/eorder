package org.sophia.eorder.service;

import java.util.List;

/**
 * 通用service接口
 * @author Administrator
 *
 * @param <T>
 */
public interface IGenericService<T> {

	void add(T t);  
	  
    void delete(T t);  
  
    void update(T t);  
  
    T queryById(String id);  
  
    List<T> queryAll(); 
    
    List<T> queryForPage(String hql, Object[] params, int recordNum, int startNum);
    
    List<T> queryForList(String hql, Object[] params);
}
