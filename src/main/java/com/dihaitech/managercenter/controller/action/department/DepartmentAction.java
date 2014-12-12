package com.dihaitech.managercenter.controller.action.department;

import java.util.Date;
import java.util.List;

import com.dihaitech.managercenter.common.Property;
import com.dihaitech.managercenter.controller.action.BaseAction;
import com.dihaitech.managercenter.model.DepPos;
import com.dihaitech.managercenter.model.Department;
import com.dihaitech.managercenter.model.Manager;
import com.dihaitech.managercenter.model.Position;
import com.dihaitech.managercenter.service.IDepPosService;
import com.dihaitech.managercenter.service.IDepartmentService;
import com.dihaitech.managercenter.service.IManagerService;
import com.dihaitech.managercenter.service.IPositionService;
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
 /**
 * @author qiusen
 *
 */
/**
 * @author qiusen
 *
 */
@SuppressWarnings("serial")
public class DepartmentAction extends BaseAction {
	private Department department = new Department();
	private IDepartmentService departmentService;
	
	private IPositionService positionService;
	
	private IDepPosService depPosService;
	
	private IManagerService managerService;
	
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
	
	public IPositionService getPositionService() {
		return positionService;
	}

	public void setPositionService(IPositionService positionService) {
		this.positionService = positionService;
	}

	public IDepPosService getDepPosService() {
		return depPosService;
	}

	public void setDepPosService(IDepPosService depPosService) {
		this.depPosService = depPosService;
	}

	public IManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(IManagerService managerService) {
		this.managerService = managerService;
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
			
			if(resultList!=null && resultList.size()>0){
				StringBuffer strbuf = new StringBuffer();
				Department departmentTemp = null;
				for(int i=0;i<resultList.size();i++){
					departmentTemp = resultList.get(i);
					if(i==0){
						strbuf.append("'"+departmentTemp.getLeaderEmail()+"'");
					}else{
						strbuf.append(", '"+departmentTemp.getLeaderEmail()+"'");
					}
				}
				Manager manager = new Manager();
				manager.setIdStr(strbuf.toString());	//使用IDS字段代替
				List<Manager> managerList = managerService.selectManagerByEmails(manager);
				this.getRequest().setAttribute("managerList", managerList);
			}
			
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
			strbuf.append(", ischecked:true");
		}
		strbuf.append(", type:0 }");
		if(departmentList!=null && departmentList.size()>0){
			for(Department department : departmentList){
				if(department.getId()!=departmentVO.getId()){	//去掉自己
					strbuf.append(",{id:"+department.getId()+", pid:"+department.getSuperId()+", text:'"+department.getName()+"' ");
					if(departmentVO.getSuperId()==department.getId()){
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
	 * 编辑主管
	 * @return
	 */
	public String editLeader(){
		
		String idStr = this.getRequest().getParameter("id");
		int id = 0;
		id = TypeUtil.stringToInt(idStr);
		if(id<=0){
			return null;
		}
		
		department.setId(id);
		Department departmentVO = departmentService.selectDepartmentById(department);
		this.getRequest().setAttribute("department", departmentVO);
		
		Manager manager = new Manager();
		manager.setDepartmentId(id);
		
		List<Manager> managerList = managerService.selectManagerByDepId(manager);
		
		this.getRequest().setAttribute("managerList", managerList);
		return "editLeader";
	}
	
	/**
	 * 保存编辑主管
	 * @return
	 */
	public String editSaveLeader(){
		
		String leaderEmail = this.getRequest().getParameter("leaderEmail");
//		System.out.println("leaderEmail--------" +leaderEmail);
		department.setLeaderEmail(leaderEmail);
		
		Manager managerVO = (Manager)this.getSession().getAttribute("manager");
		
		department.setUpdator(managerVO.getEmail());
		department.setUpdatetime(new Date());
		
		departmentService.editSaveLeaderEmail(department);
		
		return "editSaveLeader";
	}
	
	/**
	 * 修改部门与职位对应关系
	 * @return
	 */
	public String editPosition(){
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
		
		List<Position> positionList = positionService.selectAll();
		
		DepPos depPos = new DepPos();
		depPos.setDepartmentId(id);
		List<DepPos> depPosList = depPosService.selectDepPosByDepId(depPos);
		
		if(positionList!=null && positionList.size()>0 && depPosList!=null && depPosList.size()>0){
			for(Position pos : positionList){
				for(DepPos depPosTemp : depPosList){
					if(pos.getId()==depPosTemp.getPositionId()){
						pos.setIsChecked(1);
						break;
					}
				}
			}
		}
		this.getRequest().setAttribute("positionList", positionList);
		
		return "editPosition";
	}
	
	/**
	 * 保存修改部门与职位对应关系
	 * @return
	 */
	public String editSavePosition(){
		
		Manager manager = (Manager)this.getSession().getAttribute("manager");
		
		String depIdStr = this.getRequest().getParameter("depId");
		int depId = TypeUtil.stringToInt(depIdStr);
		if(depId<=0){
			return null;
		}
		
		DepPos depPosTemp = new DepPos();
		depPosTemp.setDepartmentId(depId);
		
		depPosService.deleteByDepId(depPosTemp);	//删除所有相对应的职位数据 
		
		String[] posIds = this.getRequest().getParameterValues("posId");
		if(posIds!=null && posIds.length>0){
			DepPos depPos = null;
			for(int i=0;i<posIds.length;i++){
				int posId = TypeUtil.stringToInt(posIds[i]);
				if(posId>0){
					depPos = new DepPos();
					depPos.setDepartmentId(depId);
					depPos.setPositionId(posId);
					depPos.setCreator(manager.getEmail());
					depPos.setCreatetime(new Date());
					depPos.setUpdator(manager.getEmail());
					depPos.setUpdatetime(new Date());
					depPosService.addSave(depPos);
				}
				
				
			}
		}
		
		return "editSavePosition";
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