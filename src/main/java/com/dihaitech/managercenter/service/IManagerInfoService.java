package com.dihaitech.managercenter.service;

import java.util.List;


import com.dihaitech.managercenter.model.ManagerInfo;
import com.dihaitech.managercenter.util.Page;

/**
 * 管理员详细信息 业务接口
 * 
 * @author cg
 *
 * @date 2014-12-10
 */
public interface IManagerInfoService {
	/**
	 * 查询 ManagerInfo Page 对象
	 * @param managerInfo
	 * @param pageSize
	 * @return
	 */
	public Page selectManagerInfo(ManagerInfo managerInfo, int pageSize);

	/**
	 * 分页查找 管理员详细信息
	 * @param managerInfo
	 * @param page
	 * @return
	 */
	public List<ManagerInfo> selectManagerInfo(ManagerInfo managerInfo, Page page);
	
	/**
	 * 查询所有 管理员详细信息
	 * @return
	 */
	public List<ManagerInfo> selectAll();
	
	/**
	 * 根据 ID 查找 管理员详细信息 
	 * @param managerInfo
	 * @return
	 */
	public ManagerInfo selectManagerInfoById(ManagerInfo managerInfo);
	
	/**
	 * 添加 管理员详细信息 
	 * @param managerInfo
	 * @return
	 */
	public int addSave(ManagerInfo managerInfo);
	
	/**
	 * 修改 管理员详细信息 
	 * @param managerInfo
	 * @return
	 */
	public int editSave(ManagerInfo managerInfo);
	
	/**
	 * 根据EMAIL修改 管理员详细信息 
	 * @param managerInfo
	 * @return
	 */
	public int editSaveByEmail(ManagerInfo managerInfo);
	
	/**
	 * 根据 ID 删除 管理员详细信息 
	 * @param str
	 * @return
	 */
	public int deleteByIds(String str);
	
	/**
	 * 根据邮箱查询用户详细信息
	 * @param managerInfo
	 * @return
	 */
	public ManagerInfo selectManagerInfoByEmail(ManagerInfo managerInfo);
}
