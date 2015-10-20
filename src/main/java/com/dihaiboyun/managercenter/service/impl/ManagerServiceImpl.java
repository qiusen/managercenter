package com.dihaiboyun.managercenter.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.dihaiboyun.managercenter.dao.IManagerDAO;
import com.dihaiboyun.managercenter.model.Manager;
import com.dihaiboyun.managercenter.service.IManagerService;
import com.dihaiboyun.managercenter.util.Page;

/**
 * 管理员 业务接口 IManagerService 实现类
 * 
 * @author cg
 *
 * @date 2014-08-18
 */
public class ManagerServiceImpl implements IManagerService {

	@Resource
	private IManagerDAO managerDAO;

	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IManagerService#addSave(com.dihaiboyun.oa.model.Manager)
	 */
	public int addSave(Manager manager) {
		return managerDAO.addSaveManager(manager);
	}
	
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IManagerService#deleteByIds(java.lang.String)
	 */
	public int deleteByIds(String str) {
		return managerDAO.deleteByIds(str);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IManagerService#editSave(com.dihaiboyun.oa.model.Manager)
	 */
	public int editSave(Manager manager) {
		return managerDAO.editSaveManager(manager);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.IManagerService#selectAll()
	 */
	public List<Manager> selectAll() {
		return managerDAO.selectAll();
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IManagerService#selectManager(com.dihaiboyun.oa.model.Manager, int)
	 */
	public Page selectManager(Manager manager, int pageSize) {
		return new Page(managerDAO.getManagerCount(manager), pageSize);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IManagerService#selectManager(com.dihaiboyun.oa.model.Manager, com.dihaiboyun.oa.controller.helper.Page)
	 */
	public List<Manager> selectManager(Manager manager, Page page) {
		manager.setStart(page.getFirstItemPos());
		manager.setPageSize(page.getPageSize());
		return managerDAO.selectManagerLike(manager);
	}

	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IManagerService#selectManagerById(com.dihaiboyun.oa.model.Manager)
	 */
	public Manager selectManagerById(Manager manager) {
		return managerDAO.selectManagerById(manager);
	}


	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IManagerService#login(com.dihaiboyun.oa.model.Manager)
	 */
	@Override
	public Manager login(Manager manager) {
		// TODO Auto-generated method stub
		return managerDAO.loginByEmailPassword(manager);
	}


	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IManagerService#editSaveManager(com.dihaiboyun.oa.model.Manager)
	 */
	@Override
	public int editSaveManager(Manager manager) {
		// TODO Auto-generated method stub
		return this.managerDAO.editSaveManagerById(manager);
	}


	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IManagerService#editSaveUser(com.dihaiboyun.oa.model.Manager)
	 */
	@Override
	public int editSaveUser(Manager manager) {
		// TODO Auto-generated method stub
		return this.managerDAO.editSaveUser(manager);
	}


	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IManagerService#editSavePassword(com.dihaiboyun.oa.model.Manager)
	 */
	@Override
	public int editSavePassword(Manager manager) {
		// TODO Auto-generated method stub
		return this.managerDAO.editSavePassword(manager);
	}


	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IManagerService#selectCountByRoleId(com.dihaiboyun.oa.model.Manager)
	 */
	@Override
	public Long selectCountByRoleId(Manager manager) {
		// TODO Auto-generated method stub
		return this.managerDAO.getManagerCount(manager);
	}


	/* (non-Javadoc)
	 * @see com.dihaiboyun.managercenter.service.IManagerService#selectManagerByDepId(com.dihaiboyun.managercenter.model.Manager)
	 */
	@Override
	public List<Manager> selectManagerByDepId(Manager manager) {
		// TODO Auto-generated method stub
		return this.managerDAO.selectManagerByDepId(manager);
	}


	/* (non-Javadoc)
	 * @see com.dihaiboyun.managercenter.service.IManagerService#selectManagerByEmails(com.dihaiboyun.managercenter.model.Manager)
	 */
	@Override
	public List<Manager> selectManagerByEmails(Manager manager) {
		// TODO Auto-generated method stub
		return this.managerDAO.selectManagerByEmails(manager);
	}


}
