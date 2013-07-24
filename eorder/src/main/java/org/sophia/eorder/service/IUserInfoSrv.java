package org.sophia.eorder.service;

import java.util.List;

import org.sophia.eorder.domain.Page;
import org.sophia.eorder.domain.UserInfo;

public interface IUserInfoSrv extends IGenericService<UserInfo>{
	public UserInfo getUserInfoById(String id);
	public void saveUserInfo(UserInfo userInfo);
	public void deleteUserInfo(UserInfo userInfo);
	public void queryPage(String hql, Object[] params, Page pageValue);
	public List<UserInfo> queryForList(String hql, Object[] params);
}
