package com.dihaitech.managercenter.dao;

import java.util.List;


import com.dihaitech.managercenter.model.DepPos;

/**
 * 部门职位 DAO 接口
 * 
 * @author cg
 * 
 * @since 2014-12-12
 */
public interface IDepPosDAO {

	/**
	 * 根据条件查询部门职位 条数
	 * 
	 * @param depPos
	 * @return
	 */
	public Long getDepPosCount(DepPos depPos);

	/**
	 * 分页查找部门职位
	 * 
	 * @param depPos
	 * @param page
	 * @return
	 */
	public List<DepPos> selectDepPosLike(DepPos depPos);

	/**
	 * 添加部门职位
	 * 
	 * @param depPos
	 * @return
	 */
	public int addSaveDepPos(DepPos depPos);

	/**
	 * 根据ID获取指定的部门职位信息
	 * 
	 * @param depPos
	 * @return
	 */
	public DepPos selectDepPosById(DepPos depPos);

	/**
	 * 修改部门职位
	 * 
	 * @param depPos
	 * @return
	 */
	public int editSaveDepPos(DepPos depPos);

	/**
	 * 根据ID删除指定的部门职位
	 * 
	 * @param str
	 * @return
	 */
	public int deleteByIds(String str);

	/**
	 * 查询所有部门职位
	 * 
	 * @return
	 */
	public List<DepPos> selectAll();
	
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
