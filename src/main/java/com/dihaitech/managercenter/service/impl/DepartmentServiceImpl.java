package com.dihaitech.managercenter.service.impl;

import java.util.List;
import javax.annotation.Resource;
import com.dihaitech.managercenter.util.Page;
import com.dihaitech.managercenter.dao.IDepartmentDAO;
import com.dihaitech.managercenter.model.Department;
import com.dihaitech.managercenter.service.IDepartmentService;

/**
 * 部门 业务接口 IDepartmentService 实现类
 * 
 * @author cg
 *
 * @date 2014-12-11
 */
public class DepartmentServiceImpl implements IDepartmentService {

	@Resource
	private IDepartmentDAO departmentDAO;

	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IDepartmentService#addSave(com.dihaitech.managercenter.model.Department)
	 */
	public int addSave(Department department) {
		return departmentDAO.addSaveDepartment(department);
	}
	
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IDepartmentService#deleteByIds(java.lang.String)
	 */
	public int deleteByIds(String str) {
		return departmentDAO.deleteByIds(str);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IDepartmentService#editSave(com.dihaitech.managercenter.model.Department)
	 */
	public int editSave(Department department) {
		return departmentDAO.editSaveDepartment(department);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.IDepartmentService#selectAll()
	 */
	public List<Department> selectAll() {
		return departmentDAO.selectAll();
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IDepartmentService#selectDepartment(com.dihaitech.managercenter.model.Department, int)
	 */
	public Page selectDepartment(Department department, int pageSize) {
		return new Page(departmentDAO.getDepartmentCount(department), pageSize);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IDepartmentService#selectDepartment(com.dihaitech.managercenter.model.Department, com.dihaitech.managercenter.controller.helper.Page)
	 */
	public List<Department> selectDepartment(Department department, Page page) {
		department.setStart(page.getFirstItemPos());
		department.setPageSize(page.getPageSize());
		return departmentDAO.selectDepartmentLike(department);
	}

	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IDepartmentService#selectDepartmentById(com.dihaitech.managercenter.model.Department)
	 */
	public Department selectDepartmentById(Department department) {
		return departmentDAO.selectDepartmentById(department);
	}


	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IDepartmentService#editSaveLeaderEmail(com.dihaitech.managercenter.model.Department)
	 */
	@Override
	public int editSaveLeaderEmail(Department department) {
		// TODO Auto-generated method stub
		return departmentDAO.editSaveLeaderEmail(department);
	}


	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IDepartmentService#selectDepartmentByIds(com.dihaitech.managercenter.model.Department)
	 */
	@Override
	public List<Department> selectDepartmentByIds(Department department) {
		// TODO Auto-generated method stub
		return departmentDAO.selectDepartmentByIds(department);
	}
}
