package com.dihaitech.managercenter.service;

import java.util.List;


import com.dihaitech.managercenter.model.Department;
import com.dihaitech.managercenter.util.Page;

/**
 * 部门 业务接口
 * 
 * @author cg
 *
 * @date 2014-12-11
 */
public interface IDepartmentService {
	/**
	 * 查询 Department Page 对象
	 * @param department
	 * @param pageSize
	 * @return
	 */
	public Page selectDepartment(Department department, int pageSize);

	/**
	 * 分页查找 部门
	 * @param department
	 * @param page
	 * @return
	 */
	public List<Department> selectDepartment(Department department, Page page);
	
	/**
	 * 查询所有 部门
	 * @return
	 */
	public List<Department> selectAll();
	
	/**
	 * 根据 ID 查找 部门 
	 * @param department
	 * @return
	 */
	public Department selectDepartmentById(Department department);
	
	/**
	 * 添加 部门 
	 * @param department
	 * @return
	 */
	public int addSave(Department department);
	
	/**
	 * 修改 部门 
	 * @param department
	 * @return
	 */
	public int editSave(Department department);
	
	/**
	 * 根据 ID 删除 部门 
	 * @param str
	 * @return
	 */
	public int deleteByIds(String str);
	
	/**
	 * 修改主管邮箱
	 * @param department
	 * @return
	 */
	public int editSaveLeaderEmail(Department department);
	
	/**
	 * 根据IDS获取部门
	 * @param department
	 * @return
	 */
	public List<Department> selectDepartmentByIds(Department department);
}
