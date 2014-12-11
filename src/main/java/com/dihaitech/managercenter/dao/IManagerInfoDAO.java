package com.dihaitech.managercenter.dao;

import java.util.List;


import com.dihaitech.managercenter.model.ManagerInfo;

/**
 * 管理员详细信息 DAO 接口
 * 
 * @author cg
 * 
 * @since 2014-12-10
 */
public interface IManagerInfoDAO {

	/**
	 * 根据条件查询管理员详细信息 条数
	 * 
	 * @param managerInfo
	 * @return
	 */
	public Long getManagerInfoCount(ManagerInfo managerInfo);

	/**
	 * 分页查找管理员详细信息
	 * 
	 * @param managerInfo
	 * @param page
	 * @return
	 */
	public List<ManagerInfo> selectManagerInfoLike(ManagerInfo managerInfo);

	/**
	 * 添加管理员详细信息
	 * 
	 * @param managerInfo
	 * @return
	 */
	public int addSaveManagerInfo(ManagerInfo managerInfo);

	/**
	 * 根据ID获取指定的管理员详细信息信息
	 * 
	 * @param managerInfo
	 * @return
	 */
	public ManagerInfo selectManagerInfoById(ManagerInfo managerInfo);

	/**
	 * 修改管理员详细信息
	 * 
	 * @param managerInfo
	 * @return
	 */
	public int editSaveManagerInfo(ManagerInfo managerInfo);
	
	/**
	 * 根据EMAIL修改 管理员详细信息 
	 * @param managerInfo
	 * @return
	 */
	public int editSaveManagerInfoByEmail(ManagerInfo managerInfo);

	/**
	 * 根据ID删除指定的管理员详细信息
	 * 
	 * @param str
	 * @return
	 */
	public int deleteByIds(String str);

	/**
	 * 查询所有管理员详细信息
	 * 
	 * @return
	 */
	public List<ManagerInfo> selectAll();
	
	/**
	 * 根据邮箱查询用户详细信息
	 * @param managerInfo
	 * @return
	 */
	public ManagerInfo selectManagerInfoByEmail(ManagerInfo managerInfo);
}
