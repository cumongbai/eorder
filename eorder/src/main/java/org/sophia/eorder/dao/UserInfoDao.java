package org.sophia.eorder.dao;


import org.sophia.eorder.domain.UserInfo;

public class UserInfoDao extends GenericDAO<UserInfo> implements IUserInfoDAO{

	
	public UserInfoDao()
	{
		super(UserInfo.class);
	}
}
