package com.dihaitech.managercenter.dao;

import java.util.List;


import com.dihaitech.managercenter.model.Department;

/**
 * 部门 DAO 接口
 * 
 * @author cg
 * 
 * @since 2014-12-11
 */
public interface IDepartmentDAO {

	/**
	 * 根据条件查询部门 条数
	 * 
	 * @param department
	 * @return
	 */
	public Long getDepartmentCount(Department department);

	/**
	 * 分页查找部门
	 * 
	 * @param department
	 * @param page
	 * @return
	 */
	public List<Department> selectDepartmentLike(Department department);

	/**
	 * 添加部门
	 * 
	 * @param department
	 * @return
	 */
	public int addSaveDepartment(Department department);

	/**
	 * 根据ID获取指定的部门信息
	 * 
	 * @param department
	 * @return
	 */
	public Department selectDepartmentById(Department department);

	/**
	 * 修改部门
	 * 
	 * @param department
	 * @return
	 */
	public int editSaveDepartment(Department department);

	/**
	 * 根据ID删除指定的部门
	 * 
	 * @param str
	 * @return
	 */
	public int deleteByIds(String str);

	/**
	 * 查询所有部门
	 * 
	 * @return
	 */
	public List<Department> selectAll();
	
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
