package com.dihaiboyun.managercenter.service.impl;

import java.util.List;
import javax.annotation.Resource;
import com.dihaiboyun.managercenter.util.Page;
import com.dihaiboyun.managercenter.dao.IPositionDAO;
import com.dihaiboyun.managercenter.model.Position;
import com.dihaiboyun.managercenter.service.IPositionService;

/**
 * 职位 业务接口 IPositionService 实现类
 * 
 * @author cg
 *
 * @date 2014-12-11
 */
public class PositionServiceImpl implements IPositionService {

	@Resource
	private IPositionDAO positionDAO;

	/* (non-Javadoc)
	 * @see com.dihaiboyun.managercenter.service.IPositionService#addSave(com.dihaiboyun.managercenter.model.Position)
	 */
	public int addSave(Position position) {
		return positionDAO.addSavePosition(position);
	}
	
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.managercenter.service.IPositionService#deleteByIds(java.lang.String)
	 */
	public int deleteByIds(String str) {
		return positionDAO.deleteByIds(str);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.managercenter.service.IPositionService#editSave(com.dihaiboyun.managercenter.model.Position)
	 */
	public int editSave(Position position) {
		return positionDAO.editSavePosition(position);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.managercenter.IPositionService#selectAll()
	 */
	public List<Position> selectAll() {
		return positionDAO.selectAll();
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.managercenter.service.IPositionService#selectPosition(com.dihaiboyun.managercenter.model.Position, int)
	 */
	public Page selectPosition(Position position, int pageSize) {
		return new Page(positionDAO.getPositionCount(position), pageSize);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.managercenter.service.IPositionService#selectPosition(com.dihaiboyun.managercenter.model.Position, com.dihaiboyun.managercenter.controller.helper.Page)
	 */
	public List<Position> selectPosition(Position position, Page page) {
		position.setStart(page.getFirstItemPos());
		position.setPageSize(page.getPageSize());
		return positionDAO.selectPositionLike(position);
	}

	/* (non-Javadoc)
	 * @see com.dihaiboyun.managercenter.service.IPositionService#selectPositionById(com.dihaiboyun.managercenter.model.Position)
	 */
	public Position selectPositionById(Position position) {
		return positionDAO.selectPositionById(position);
	}


	/* (non-Javadoc)
	 * @see com.dihaiboyun.managercenter.service.IPositionService#selectPositionByIds(com.dihaiboyun.managercenter.model.Position)
	 */
	@Override
	public List<Position> selectPositionByIds(Position position) {
		// TODO Auto-generated method stub
		return positionDAO.selectPositionByIds(position);
	}
}
