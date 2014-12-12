package com.dihaitech.managercenter.service;

import java.util.List;


import com.dihaitech.managercenter.model.DepPos;
import com.dihaitech.managercenter.util.Page;

/**
 * 部门职位 业务接口
 * 
 * @author cg
 *
 * @date 2014-12-12
 */
public interface IDepPosService {
	/**
	 * 查询 DepPos Page 对象
	 * @param depPos
	 * @param pageSize
	 * @return
	 */
	public Page selectDepPos(DepPos depPos, int pageSize);

	/**
	 * 分页查找 部门职位
	 * @param depPos
	 * @param page
	 * @return
	 */
	public List<DepPos> selectDepPos(DepPos depPos, Page page);
	
	/**
	 * 查询所有 部门职位
	 * @return
	 */
	public List<DepPos> selectAll();
	
	/**
	 * 根据 ID 查找 部门职位 
	 * @param depPos
	 * @return
	 */
	public DepPos selectDepPosById(DepPos depPos);
	
	/**
	 * 添加 部门职位 
	 * @param depPos
	 * @return
	 */
	public int addSave(DepPos depPos);
	
	/**
	 * 修改 部门职位 
	 * @param depPos
	 * @return
	 */
	public int editSave(DepPos depPos);
	
	/**
	 * 根据 ID 删除 部门职位 
	 * @param str
	 * @return
	 */
	public int deleteByIds(String str);
	
	/**
	 * 根据部门ID，获取职位
	 * @param depPos
	 * @return
	 */
	public List<DepPos> selectDepPosByDepId(DepPos depPos);
	
	/**
	 * 根据部门ID，删除所有对应关系
	 * @param depPos
	 * @return
	 */
	public int deleteByDepId(DepPos depPos);
}
