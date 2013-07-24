package org.sophia.eorder.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sophia.eorder.domain.Page;
import org.sophia.eorder.domain.UserInfo;
import org.sophia.eorder.service.IUserInfoSrv;
import org.sophia.eorder.service.UserInfoSrv;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MysqlTest {

//	private static MysqlTest instance = null;
//    private Connection conn;
//    private String connectString = "jdbc:mysql://localhost:3306/eorder?&useUnicode=true&characterEncoding=UTF-8";
//
//    protected Connection getConnection() {
//	if (conn == null) {
//	    init();
//	}
//	return conn;
//    }
//
//    public static synchronized MysqlTest getInstance() {
//	if (instance == null) {
//	    instance = new MysqlTest();
//	    // instance.
//	}
//	return instance;
//    }
//
//    private MysqlTest() {
//	init();
//    }
//
//    public static void closeConnection(Connection conn) {
//	try {
//	    if (conn != null && !conn.isClosed()) {
//		conn.close();
//	    }
//	} catch (SQLException e) {
//	    e.printStackTrace();
//	    conn = null;
//	} finally {
//	    try {
//		if (conn != null && !conn.isClosed()) {
//		    conn.close();
//		}
//	    } catch (Exception e) {
//		e.printStackTrace();
//		conn = null;
//	    }
//	}
//    }
//
//    private void init() {
//	try {
//	    Class.forName("com.mysql.jdbc.Driver");
//	    conn = DriverManager.getConnection(connectString, "root", "123456");
//	} catch (SQLException e) {
//	    e.printStackTrace();
//	} catch (ClassNotFoundException e) {
//	    e.printStackTrace();
//	}
//    }
//    
//    public void clear(){
//	try {
//	    if (conn != null && !conn.isClosed()) {
//		conn.close();
//	    }
//	} catch (SQLException e) {
//	    e.printStackTrace();
//	    conn = null;
//	} finally {
//	    try {
//		if (conn != null && !conn.isClosed()) {
//		    conn.close();
//		}
//	    } catch (Exception e) {
//		e.printStackTrace();
//		conn = null;
//	    }
//	}
//	instance = null;
//    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MysqlTest test = MysqlTest.getInstance();
//		test.getConnection();
//		System.out.println("ok");
//		test.clear();
		ApplicationContext context =
			    new ClassPathXmlApplicationContext("application.xml");
		//System.out.println(context.getBean("userInfoSrv"));
		UserInfoSrv userInfoSrv = context.getBean("userInfoSrv",UserInfoSrv.class);
		//UserInfoDao userInfoDao = context.getBean("userInfoDao", UserInfoDao.class);
		//UserInfo userInfo = (UserInfo)userInfoSrv.getUserInfoById("1232137251104");
//		UserInfo userInfo2 = userInfoSrv.queryById("0001");
//		System.out.println(userInfo2);
		UserInfo userInfo2 = new UserInfo();
		userInfo2.setUserid("0007");
		userInfo2.setMobileNum("13876540987");
		userInfo2.setAddress("阿拉斯加大山深处");
		userInfoSrv.saveUserInfo(userInfo2);
		
//		Page<UserInfo> pageValue = new Page(1,2);
//		userInfoSrv.queryPage("from UserInfo", null, pageValue);
//		List<UserInfo> list = pageValue.getData();
//		System.out.println(list.size());
//		System.out.println(list.get(0));
		
		//List<UserInfo> userInfos = userInfoDao.findAllUser();
		//System.out.println(userInfo);
	}

}
