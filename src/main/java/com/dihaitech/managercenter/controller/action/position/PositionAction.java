package com.dihaitech.managercenter.controller.action.position;

import java.util.Date;
import java.util.List;

import com.dihaitech.managercenter.common.Property;
import com.dihaitech.managercenter.controller.action.BaseAction;
import com.dihaitech.managercenter.util.Page;
import com.dihaitech.managercenter.util.TypeUtil;
import com.dihaitech.managercenter.util.json.JSONUtil;
import com.dihaitech.managercenter.model.Manager;
import com.dihaitech.managercenter.model.Position;
import com.dihaitech.managercenter.service.IPositionService;

/**
 * 职位Action
 * 
 * @author cg
 *
 * @date 2014-12-11
 */
 @SuppressWarnings("serial")
public class PositionAction extends BaseAction {
	private Position position = new Position();
	private IPositionService positionService;
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	public IPositionService getPositionService() {
		return positionService;
	}

	public void setPositionService(IPositionService positionService) {
		this.positionService = positionService;
	}
	/* 
	 * 职位查询
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

			Page pageInfo = positionService.selectPosition(position,this.getManagerPageSize());
			
			if (pageNo > 0) {
				pageInfo.setPage(pageNo);
			} else {
				pageInfo.setPage(0);
			}
			
			List<Position> resultList = this.positionService.selectPosition(position,pageInfo);
			
			this.getRequest().setAttribute("pageInfo", pageInfo);
			this.getRequest().setAttribute("resultList", resultList);
			this.getRequest().setAttribute("actionName","positionAction");

			String json = "\"Rows\":" + JSONUtil.objectArrayToJson(resultList)+", \"Total\":" + pageInfo.getResultCount();
			System.out.println("Position json:::::::::::::::::::" + json);
			this.getRequest().setAttribute("json", json);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 添加 职位
	 * @return
	 */
	public String add(){
		return "add";
	}
	
	/**
	 * 保存添加 职位
	 * @return
	 */
	public String addSave(){
		Manager managerVO = (Manager)this.getSession().getAttribute("manager");
		
		position.setCreator(managerVO.getEmail());
		position.setCreatetime(new Date());
		position.setUpdator(managerVO.getEmail());
		position.setUpdatetime(new Date());
		positionService.addSave(position);
		return "addSave";
	}
	
	/**
	 * 修改 职位
	 * @return
	 */
	public String edit(){
		String idStr = this.getRequest().getParameter("id");
		int id = 0;
		id = TypeUtil.stringToInt(idStr);
		if(id>0){
			position.setId(id);
		}else{
			return null;
		}
		
		Position positionVO = positionService.selectPositionById(position);
		this.getRequest().setAttribute("position", positionVO);
		return "edit";
	}
	
	/**
	 * 保存修改 职位
	 * @return
	 */
	public String editSave(){
		Manager managerVO = (Manager)this.getSession().getAttribute("manager");
		
		position.setUpdator(managerVO.getEmail());
		position.setUpdatetime(new Date());
		positionService.editSave(position);
		return "editSave";
	}
	
	/**
	 * 删除 职位
	 * @return
	 */
	public String delete(){
		String id = this.getRequest().getParameter("id");
		StringBuffer strbuf = new StringBuffer(" where id =");
		strbuf.append(id);
		positionService.deleteByIds(strbuf.toString());
		return "deleteSuccess";
	}

	/**
	 * 删除 职位
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
			positionService.deleteByIds(strbuf.toString());
			return "deleteSuccess";
		}
		return "deleteFailure";
	}
}