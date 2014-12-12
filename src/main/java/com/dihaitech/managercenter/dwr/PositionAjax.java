package com.dihaitech.managercenter.dwr;

import java.util.List;

import com.dihaitech.managercenter.model.DepPos;
import com.dihaitech.managercenter.model.Position;
import com.dihaitech.managercenter.service.IDepPosService;
import com.dihaitech.managercenter.service.IPositionService;

/**
 * 职位AJAX
 * @author qiusen
 *
 */
public class PositionAjax {

	private IDepPosService depPosService;
	
	private IPositionService positionService;
	
	public IDepPosService getDepPosService() {
		return depPosService;
	}

	public void setDepPosService(IDepPosService depPosService) {
		this.depPosService = depPosService;
	}

	public IPositionService getPositionService() {
		return positionService;
	}

	public void setPositionService(IPositionService positionService) {
		this.positionService = positionService;
	}

	/**
	 * 根据部门ID，获取所有关联的职位
	 * @param depId
	 * @return
	 */
	public List<Position> getPositionByDepId(Integer depId){
		List<Position> positionList = null;
		
		DepPos depPos = new DepPos();
		depPos.setDepartmentId(depId);
		List<DepPos> depPosList = depPosService.selectDepPosByDepId(depPos);
		if(depPosList!=null && depPosList.size()>0){
			DepPos depPosTemp = null;
			StringBuffer strbuf = new StringBuffer();
			
			for(int i=0;i<depPosList.size();i++){
				depPosTemp = depPosList.get(i);
				if(i==0){
					strbuf.append(depPosTemp.getPositionId());
				}else{
					strbuf.append("," + depPosTemp.getPositionId());
				}
			}
			Position position = new Position();
			position.setIdStr(strbuf.toString());
			positionList = positionService.selectPositionByIds(position);
		}
		
		return positionList;
	}
}
