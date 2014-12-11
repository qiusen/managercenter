package com.dihaitech.managercenter.controller.action.department;

import java.util.Date;
import java.util.List;

import com.dihaitech.managercenter.common.Property;
import com.dihaitech.managercenter.controller.action.BaseAction;
import com.dihaitech.managercenter.model.Department;
import com.dihaitech.managercenter.model.Manager;
import com.dihaitech.managercenter.service.IDepartmentService;
import com.dihaitech.managercenter.util.Page;
import com.dihaitech.managercenter.util.TypeUtil;
import com.dihaitech.managercenter.util.json.JSONUtil;

/**
 * 部门Action
 * 
 * @author cg
 *
 * @date 2014-12-11
 */
 @SuppressWarnings("serial")
public class DepartmentAction extends BaseAction {
	private Department department = new Department();
	private IDepartmentService departmentService;
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	public IDepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	/* 
	 * 部门查询
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute(){
		try {
			String pageSizeStr = this.getRequest().getParameter("pageSize");
			String pageNoStr = this.getRequest().getParameter("pageNo");
			int pageSize = 0;
			int pageNo = 0;
			
			pageSize = TypeUtil.stringToInt(pageSizeStr);
			if (pageSize <= 0) {
				pageSize = Property.PAGESIZE;
			}

			pageNo = TypeUtil.stringToInt(pageNoStr);
			if (pageSize > 0) {
				this.setManagerPageSize(pageSize);
			}else{
				this.setManagerPageSize(Property.PAGESIZE);
			}

			Page pageInfo = departmentService.selectDepartment(department,this.getManagerPageSize());
			
			if (pageNo > 0) {
				pageInfo.setPage(pageNo);
			} else {
				pageInfo.setPage(0);
			}
			
			List<Department> resultList = this.departmentService.selectDepartment(department,pageInfo);
			
			this.getRequest().setAttribute("pageInfo", pageInfo);
			this.getRequest().setAttribute("resultList", resultList);
			this.getRequest().setAttribute("actionName","departmentAction");

			String json = "\"Rows\":" + JSONUtil.objectArrayToJson(resultList)+", \"Total\":" + pageInfo.getResultCount();
			System.out.println("Department json:::::::::::::::::::" + json);
			this.getRequest().setAttribute("json", json);
			
			List<Department> departmentList = departmentService.selectAll();
			this.getRequest().setAttribute("departmentList", departmentList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 添加 部门
	 * @return
	 */
	public String add(){
		
		List<Department> departmentList = departmentService.selectAll();
		StringBuffer strbuf = new StringBuffer("[");
		
		strbuf.append("{ id: '0', pid: -1, text: '"+Property.COMP_NAME+"' , type:0 }");
		if(departmentList!=null && departmentList.size()>0){
			for(Department department : departmentList){
				strbuf.append(",{id:"+department.getId()+", pid:"+department.getSuperId()+", text:'"+department.getName()+"', type:1}");
			}
		}
		strbuf.append("]");
		
		this.getRequest().setAttribute("data", strbuf.toString());
		
		return "add";
	}
	
	/**
	 * 保存添加 部门
	 * @return
	 */
	public String addSave(){
		Manager managerVO = (Manager)this.getSession().getAttribute("manager");
		
		department.setCreator(managerVO.getEmail());
		department.setCreatetime(new Date());
		department.setUpdator(managerVO.getEmail());
		department.setUpdatetime(new Date());
		
		departmentService.addSave(department);
		return "addSave";
	}
	
	/**
	 * 修改 部门
	 * @return
	 */
	public String edit(){
		String idStr = this.getRequest().getParameter("id");
		int id = 0;
		id = TypeUtil.stringToInt(idStr);
		if(id>0){
			department.setId(id);
		}else{
			return null;
		}
		
		Department departmentVO = departmentService.selectDepartmentById(department);
		this.getRequest().setAttribute("department", departmentVO);
		
		List<Department> departmentList = departmentService.selectAll();
		StringBuffer strbuf = new StringBuffer("[");
		
		strbuf.append("{ id: '0', pid: -1, text: '"+Property.COMP_NAME+"' ");
		if(departmentVO.getSuperId()==0){
			strbuf.append(", selected:true");
		}
		strbuf.append(", type:0 }");
		if(departmentList!=null && departmentList.size()>0){
			for(Department department : departmentList){
				if(department.getId()!=departmentVO.getId()){	//去掉自己
					strbuf.append(",{id:"+department.getId()+", pid:"+department.getSuperId()+", text:'"+department.getName()+"' ");
					if(departmentVO.getSuperId()==department.getId()){
						strbuf.append(", isselected:true");
						strbuf.append(", ischecked: true");
					}
					strbuf.append(", type:0 }");
				}
				
				
			}
		}
		strbuf.append("]");
		
		this.getRequest().setAttribute("data", strbuf.toString());
		
		return "edit";
	}
	
	/**
	 * 保存修改 部门
	 * @return
	 */
	public String editSave(){
		Manager managerVO = (Manager)this.getSession().getAttribute("manager");
		
		department.setUpdator(managerVO.getEmail());
		department.setUpdatetime(new Date());
		
		departmentService.editSave(department);
		return "editSave";
	}
	
	/**
	 * 删除 部门
	 * @return
	 */
	public String delete(){
		String id = this.getRequest().getParameter("id");
		StringBuffer strbuf = new StringBuffer(" where id =");
		strbuf.append(id);
		departmentService.deleteByIds(strbuf.toString());
		return "deleteSuccess";
	}

	/**
	 * 删除 部门
	 * @return
	 */
	public String deleteByIds(){
		String[] ids = this.getRequest().getParameterValues("id");
		StringBuffer strbuf = new StringBuffer(" where id in(");
		if (ids != null && ids.length > 0) {
			for (int i = 0; i < ids.length; i++) {
				if (i != 0) {
					strbuf.append("," + ids[i]);
				} else {
					strbuf.append(ids[i]);
				}
			}
			strbuf.append(")");
			departmentService.deleteByIds(strbuf.toString());
			return "deleteSuccess";
		}
		return "deleteFailure";
	}
}