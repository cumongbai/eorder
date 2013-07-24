package org.sophia.eorder.dao;

import java.io.Serializable;  
import java.sql.SQLException;  
import java.util.List;  
import java.util.Map;  
import java.util.Set;  
import org.hibernate.Criteria;  
import org.hibernate.HibernateException;  
import org.hibernate.Query;  
import org.hibernate.Session;  
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Expression;  
import org.hibernate.criterion.Order;  
import org.hibernate.type.DateType;  
import org.hibernate.type.FloatType;  
import org.hibernate.type.IntegerType;  
import org.hibernate.type.StringType;  
import org.hibernate.type.Type;  
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;  
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;  
  
/** 
 * 通用的操作类 dao 
 *  
 *  
 */  
public class CommDao<T> extends HibernateDaoSupport {  
    // logger日志对象  
    protected Logger log = Logger.getLogger(this.getClass());  
    private SessionFactory sessionFactory; 
    
    public CommDao() {  
    	Configuration config=new Configuration().configure(); 
    	sessionFactory=config.buildSessionFactory(); 
    	setSessionFactoryOverride(sessionFactory);
    }  
  
    /** 
     * 添加一个对象 
     */  
    public T addObject(T obj) {  
        this.getHibernateTemplate().save(obj);  
        return obj;  
    }  
  
    /** 
     * 删除一个对象 
     */  
    public T deleteObject(T obj) {  
        this.getHibernateTemplate().delete(obj);  
        return obj;  
    }  
  
    /** 
     * 更新一个对象 
     */  
    public T updateObject(T obj) {  
        this.getHibernateTemplate().update(obj);  
        return obj;  
    }  
  
    /** 
     * 排序+分页功能+条件查询 
     *  
     * @param <E> 
     * @param cl 
     * @param map 
     *            条件参数 
     * @param orderstr 
     *            排序字段 如果为null不排序 
     * @param beginpos 
     *            分页起点 如果为null不分页 
     * @param count 
     *            每页的记录总数 如果为null不分页 
     * @return 返回List集合 
     */  
    public <E> List<E> getOrderObjects(final Class cl, final Map map,  
            final String orderstr, final Integer beginpos, final Integer count) {  
        List<E> list = this.getHibernateTemplate().executeFind(  
                new HibernateCallback() {  
                    public Object doInHibernate(Session session)  
                            throws HibernateException, SQLException {  
                        Criteria cri = session.createCriteria(cl);  
                        if (map != null) {  
                            Set keyset = map.keySet();  
                            for (Object key : keyset) {  
                                if (key == null || map.get(key) == null) {  
                                    continue;  
                                }  
                                // 如果对应的值是字符串类型，我就是用like匹配  
                                if (map.get(key).getClass() == String.class) {  
                                    cri.add(Expression.like(key.toString(), map  
                                            .get(key)));  
                                } else {  
                                    cri.add(Expression.eq(key.toString(), map  
                                            .get(key)));  
                                }  
                            }  
                        }  
                        if (orderstr != null) {  
                            cri.addOrder(Order.desc(orderstr));  
                        }  
                        if (beginpos != null) {  
                            cri.setFirstResult(beginpos);  
                        } else {  
                            cri.setFirstResult(0);  
                        }  
                        if (count != null) {  
                            cri.setMaxResults(count);  
                        }  
                        return (List<E>) cri.list();  
                    }  
                });  
        return list;  
    }  
  
    /** 
     * 分页查询 ，传一个hql语句. 和一个参数数组. 
     *  
     * @param hql 
     *            hql语句 
     * @param bindValue 
     *            数组参数 
     * @param first 
     *            分页起点 
     * @param count 
     *            每页的记录总数 
     * @return 返回List集合 
     */  
    public List pageQuery(final String hql, final Object[] bindValue,  
            final Integer first, final Integer count) {  
        List list = this.getHibernateTemplate().executeFind(  
                new HibernateCallback() {  
                    public Object doInHibernate(Session session)  
                            throws HibernateException, SQLException {  
                        Query query = session.createQuery(hql);  
  
                        if (bindValue != null && bindValue.length >= 1) {  
                            Type[] types = typesFactory(bindValue);  
                            query.setParameters(bindValue, types);  
                        }  
                        if (first != null && first.intValue() >= 0) {  
                            query.setFirstResult(first);  
                            if (count != null && count.intValue() >= 0)  
                                query.setMaxResults(count);  
                        }  
                        List result = query.list();  
                        return result;  
                    }  
                });  
        return list;  
    }  
  
    /** 
     * 获取对象对应参数的类型 
     *  
     * @param bindValue 
     * @return 
     */  
    private final Type[] typesFactory(Object[] bindValue) {  
        int count = bindValue.length;  
        Type[] types = new Type[count];  
        for (int i = 0; i < count; i++) {  
            if (bindValue[i].getClass().getName().endsWith("String")) {  
                types[i] = new StringType();  
            } else if (bindValue[i].getClass().getName().endsWith("Integer")) {  
                types[i] = new IntegerType();  
            } else if (bindValue[i].getClass().getName().endsWith("Float")) {  
                types[i] = new FloatType();  
            } else if (bindValue[i].getClass().getName().endsWith("Date")) {  
                types[i] = new DateType();  
            }  
        }  
        return types;  
    }  
  
    /** 
     * 查询某个类的全部对象 
     *  
     * @param <E> 
     * @param c 
     *            查询类的class 
     * @return 
     */  
    public <E> List<E> selectAllObject(final Class c) {  
        List<E> list = this.getHibernateTemplate().executeFind(  
                new HibernateCallback() {  
                    public Object doInHibernate(Session session)  
                            throws HibernateException, SQLException {  
                        Criteria cri = session.createCriteria(c);  
                        List<E> list = cri.list();  
                        return list;  
                    }  
                });  
        return list;  
    }  
  
    /** 
     * 根据 主键 查询某个对象 
     *  
     * @param <E> 
     * @param c 
     * @param id 
     * @return 
     */  
    public <E> E selectObjectById(final Class c, final Serializable id) {  
        E e = (E) this.getHibernateTemplate().execute(new HibernateCallback() {  
            public Object doInHibernate(Session session)  
                    throws HibernateException, SQLException {  
                E aa = (E) session.get(c, id);  
                return aa;  
            }  
        });  
        return e;  
    }  
  
    /** 
     * 根据条件,查询一个对象. 
     *  
     * @param <E> 
     * @param c 
     * @param map 
     *            map放条件查询参数 调用的时候?: String username="xiejin" ; 
     *            map.put("username",username); 
     * @return 
     */  
    public <E> E selectUniqueObject(final Class c, final Map map) {  
        E e = (E) this.getHibernateTemplate().execute(new HibernateCallback() {  
            public Object doInHibernate(Session session)  
                    throws HibernateException, SQLException {  
                Criteria cri = session.createCriteria(c);  
                cri.add(Expression.allEq(map));  
                return (E) cri.uniqueResult();  
            }  
        });  
        return e;  
    }  
  
    /** 
     * 带条件的查询.返回list集合 
     *  
     * @param <E> 
     * @param c 
     * @param map 
     *            根据map里面放置的参数 
     * @return 返回一个list对象集合 
     */  
    public <E> List<E> seletcObjectByMap(final Class c, final Map map) {  
        List<E> list = this.getHibernateTemplate().executeFind(  
                new HibernateCallback() {  
                    public Object doInHibernate(Session session)  
                            throws HibernateException, SQLException {  
                        Criteria cri = session.createCriteria(c);  
                        cri.add(Expression.allEq(map));  
                        List<E> e = cri.list();  
                        return e;  
                    }  
                });  
        return list;  
    }  
  
    /** 
     * 一个泛型方法:支持条件查询,排序,分页查询. 
     *  
     * @param <E> 
     *            类别 
     * @param cl 
     *            需要查询的类 
     * @param map 
     *            map中put("uname","谢晋"); null or map 
     *            模糊查询用("uname","%"+uname+"%") 
     * @param orderStr 
     *            是否需要排序(升序) null or "属性字段" 
     * @param beginIndex 
     *            分页开始位置 null or Integer 
     * @param count 
     *            记录条数 null or Integer 
     * @return 
     */  
    @SuppressWarnings("unchecked")  
    public <E> List<E> selectObjInfoByMapCondtionAndOrderAndPageQuery(  
            final Class cl, final Map map, final String orderStr,  
            final Integer beginIndex, final Integer count) {  
        List e = this.getHibernateTemplate().executeFind(  
                new HibernateCallback() {  
                    public Object doInHibernate(Session session)  
                            throws HibernateException, SQLException {  
                        // 使用 Criteria查询 代替复杂得hql语句;  
                        Criteria cri = session.createCriteria(cl);  
                        // 对map进行判断  
                        if (map != null) {  
                            Set keyset = map.keySet();  
                            for (Object key : keyset) {  
                                // 如果为空则继续遍历  
                                if (key == null || map.get(key) == null) {  
                                    continue;  
                                }  
                                // 如果是参数值是字符串则用模糊查询. like 匹配  
                                if (map.get(key).getClass() == String.class) {  
                                    cri.add(Expression.like(key.toString(), map  
                                            .get(key)));  
                                } else {  
                                    cri.add(Expression.eq(key.toString(), map  
                                            .get(key)));  
                                }  
                            }  
                        }  
                        // 对orderStr 进行判断  
                        if (orderStr != null) {  
                            cri.addOrder(Order.asc(orderStr));// 升序  
                        }  
                        // 对分页 进行判断  
                        if (beginIndex != null && beginIndex.intValue() >= 0) {  
                            cri.setFirstResult(beginIndex.intValue());  
                            if (count != null && count.intValue() >= 0) {  
                                cri.setMaxResults(count.intValue());  
                            }  
                        }  
                        return (List<E>) cri.list();  
                    }  
                });  
        return e;  
    }  
    
    public void setSessionFactoryOverride(SessionFactory sessionFactory)   
    {   
  
        super.setSessionFactory(sessionFactory);   
    }  
}  
