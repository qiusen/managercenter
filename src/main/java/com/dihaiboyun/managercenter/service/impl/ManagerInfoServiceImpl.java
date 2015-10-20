package com.dihaiboyun.managercenter.service.impl;

import java.util.List;
import javax.annotation.Resource;
import com.dihaiboyun.managercenter.util.Page;
import com.dihaiboyun.managercenter.dao.IManagerInfoDAO;
import com.dihaiboyun.managercenter.model.ManagerInfo;
import com.dihaiboyun.managercenter.service.IManagerInfoService;

/**
 * 管理员详细信息 业务接口 IManagerInfoService 实现类
 * 
 * @author cg
 *
 * @date 2014-12-10
 */
public class ManagerInfoServiceImpl implements IManagerInfoService {

	@Resource
	private IManagerInfoDAO managerInfoDAO;

	/* (non-Javadoc)
	 * @see com.dihaiboyun.managercenter.service.IManagerInfoService#addSave(com.dihaiboyun.managercenter.model.ManagerInfo)
	 */
	public int addSave(ManagerInfo managerInfo) {
		return managerInfoDAO.addSaveManagerInfo(managerInfo);
	}
	
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.managercenter.service.IManagerInfoService#deleteByIds(java.lang.String)
	 */
	public int deleteByIds(String str) {
		return managerInfoDAO.deleteByIds(str);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.managercenter.service.IManagerInfoService#editSave(com.dihaiboyun.managercenter.model.ManagerInfo)
	 */
	public int editSave(ManagerInfo managerInfo) {
		return managerInfoDAO.editSaveManagerInfo(managerInfo);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.managercenter.IManagerInfoService#selectAll()
	 */
	public List<ManagerInfo> selectAll() {
		return managerInfoDAO.selectAll();
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.managercenter.service.IManagerInfoService#selectManagerInfo(com.dihaiboyun.managercenter.model.ManagerInfo, int)
	 */
	public Page selectManagerInfo(ManagerInfo managerInfo, int pageSize) {
		return new Page(managerInfoDAO.getManagerInfoCount(managerInfo), pageSize);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.managercenter.service.IManagerInfoService#selectManagerInfo(com.dihaiboyun.managercenter.model.ManagerInfo, com.dihaiboyun.managercenter.controller.helper.Page)
	 */
	public List<ManagerInfo> selectManagerInfo(ManagerInfo managerInfo, Page page) {
		managerInfo.setStart(page.getFirstItemPos());
		managerInfo.setPageSize(page.getPageSize());
		return managerInfoDAO.selectManagerInfoLike(managerInfo);
	}

	/* (non-Javadoc)
	 * @see com.dihaiboyun.managercenter.service.IManagerInfoService#selectManagerInfoById(com.dihaiboyun.managercenter.model.ManagerInfo)
	 */
	public ManagerInfo selectManagerInfoById(ManagerInfo managerInfo) {
		return managerInfoDAO.selectManagerInfoById(managerInfo);
	}


	/* (non-Javadoc)
	 * @see com.dihaiboyun.managercenter.service.IManagerInfoService#selectManagerInfoByEmail(com.dihaiboyun.managercenter.model.ManagerInfo)
	 */
	@Override
	public ManagerInfo selectManagerInfoByEmail(ManagerInfo managerInfo) {
		// TODO Auto-generated method stub
		return managerInfoDAO.selectManagerInfoByEmail(managerInfo);
	}


	/* (non-Javadoc)
	 * @see com.dihaiboyun.managercenter.service.IManagerInfoService#editSaveByEmail(com.dihaiboyun.managercenter.model.ManagerInfo)
	 */
	@Override
	public int editSaveByEmail(ManagerInfo managerInfo) {
		// TODO Auto-generated method stub
		return managerInfoDAO.editSaveManagerInfoByEmail(managerInfo);
	}
}
