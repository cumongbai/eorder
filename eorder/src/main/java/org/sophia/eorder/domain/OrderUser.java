package org.sophia.eorder.domain;
// Generated 2013-7-4 0:35:54 by Hibernate Tools 3.4.0.CR1

/**
 * OrderUser generated by hbm2java
 */
public class OrderUser implements java.io.Serializable {

	private String userid;
	private String username;
	private String password;
	private String roleid;

	public OrderUser() {
	}

	public OrderUser(String userid, String username, String password,
			String roleid) {
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.roleid = roleid;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoleid() {
		return this.roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

}
