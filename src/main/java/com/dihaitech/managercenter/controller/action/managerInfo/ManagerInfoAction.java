package com.dihaitech.managercenter.controller.action.managerInfo;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dihaitech.managercenter.controller.action.BaseAction;
import com.dihaitech.managercenter.controller.action.common.UserAction;
import com.dihaitech.managercenter.model.Manager;
import com.dihaitech.managercenter.model.ManagerInfo;
import com.dihaitech.managercenter.model.Role;
import com.dihaitech.managercenter.service.IDepPosService;
import com.dihaitech.managercenter.service.IDepartmentService;
import com.dihaitech.managercenter.service.IManagerInfoService;
import com.dihaitech.managercenter.service.IPositionService;
import com.dihaitech.managercenter.service.IRoleService;

/**
 * 管理员详细信息Action
 * 
 * @author cg
 *
 * @date 2014-12-10
 */
 @SuppressWarnings("serial")
public class ManagerInfoAction extends BaseAction {
	 
	private static final Log logger = LogFactory.getLog(UserAction.class);
	private ManagerInfo managerInfo = new ManagerInfo();
	private IManagerInfoService managerInfoService;
	
	private IRoleService roleService;
	
	private IDepartmentService departmentService;
	
	private IPositionService positionService;
	
	private IDepPosService depPosService;
	
	public ManagerInfo getManagerInfo() {
		return managerInfo;
	}

	public void setManagerInfo(ManagerInfo managerInfo) {
		this.managerInfo = managerInfo;
	}
	public IManagerInfoService getManagerInfoService() {
		return managerInfoService;
	}

	public void setManagerInfoService(IManagerInfoService managerInfoService) {
		this.managerInfoService = managerInfoService;
	}
	
	public IRoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
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

	/* 
	 * 管理员详细信息查询
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute(){
		Manager managerVO = (Manager)this.getSession().getAttribute("manager");
		managerInfo.setEmail(managerVO.getEmail());
		System.out.println("********" +managerVO.getEmail());
		Object o = managerInfoService.selectManagerInfoByEmail(managerInfo);
		if(o!=null){
			ManagerInfo managerInfoVO = (ManagerInfo)o;
					this.getRequest().setAttribute("managerInfo", managerInfoVO);
		}
		
		
		
		Role role = new Role();
		role.setStatus(1);
		List<Role> roleList = roleService.selectAllByStatus(role);
		this.getRequest().setAttribute("roleList", roleList);
		
		return SUCCESS;
	}
	
	/**
	 * 保存修改 管理员详细信息
	 * @return
	 */
	public String editSave(){
		Manager managerVO = (Manager)this.getSession().getAttribute("manager");
		managerInfo.setEmail(managerVO.getEmail());
		
		managerInfo.setUpdatetime(new Date());
		int i = managerInfoService.editSaveByEmail(managerInfo);
		if(i<=0){
			managerInfoService.addSave(managerInfo);
		}
		
		this.getRequest().setAttribute("edit", 1);
		this.getRequest().setAttribute("managerInfo", managerInfo);
		
		this.recordLogs(logger, "changeInfo", managerInfo.getEmail() + "chane info");

		Role role = new Role();
		role.setStatus(1);
		List<Role> roleList = roleService.selectAllByStatus(role);
		this.getRequest().setAttribute("roleList", roleList);
		
		return SUCCESS;
	}
	
}