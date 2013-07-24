package org.sophia.eorder.service;

import java.util.List;

import org.sophia.eorder.dao.IGenericDAO;
import org.sophia.eorder.dao.IUserInfoDAO;
import org.sophia.eorder.domain.Page;
import org.sophia.eorder.domain.UserInfo;
import org.springframework.transaction.annotation.Transactional;
@Transactional   
public class UserInfoSrv extends GenericService<UserInfo> implements IUserInfoSrv{

	private IUserInfoDAO iUserInfoDAO;
	public UserInfoSrv()
	{
		super(UserInfo.class);
	}
	public void setIUserInfoDAO(IUserInfoDAO iUserInfoDAO)
	{
		this.iUserInfoDAO = iUserInfoDAO;
		this.iGenericDAO = iUserInfoDAO;
	}
	
	@Override
	public UserInfo getUserInfoById(String id) {
		// TODO Auto-generated method stub
		return iUserInfoDAO.queryById(id);
	}
	@Override
	public void saveUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		iUserInfoDAO.insert(userInfo);
	}
	@Override
	public void deleteUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		iUserInfoDAO.delete(userInfo);
	}
	@Override
	public void queryPage(String hql, Object[] params, Page pageValue) {
		// TODO Auto-generated method stub
		int startNum = pageValue.getPageSize()*(pageValue.getCurrentPageNo() - 1);
		pageValue.setData(iUserInfoDAO.queryForPage(hql, params, pageValue.getPageSize(), startNum));
		
	}
	@Override
	public List<UserInfo> queryForList(String hql, Object[] params) {
		// TODO Auto-generated method stub
		return iUserInfoDAO.queryForList(hql, params);
	}

}
