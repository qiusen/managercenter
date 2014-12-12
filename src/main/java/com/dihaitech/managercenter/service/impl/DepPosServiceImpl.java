package com.dihaitech.managercenter.service.impl;

import java.util.List;
import javax.annotation.Resource;
import com.dihaitech.managercenter.util.Page;
import com.dihaitech.managercenter.dao.IDepPosDAO;
import com.dihaitech.managercenter.model.DepPos;
import com.dihaitech.managercenter.service.IDepPosService;

/**
 * 部门职位 业务接口 IDepPosService 实现类
 * 
 * @author cg
 *
 * @date 2014-12-12
 */
public class DepPosServiceImpl implements IDepPosService {

	@Resource
	private IDepPosDAO depPosDAO;

	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IDepPosService#addSave(com.dihaitech.managercenter.model.DepPos)
	 */
	public int addSave(DepPos depPos) {
		return depPosDAO.addSaveDepPos(depPos);
	}
	
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IDepPosService#deleteByIds(java.lang.String)
	 */
	public int deleteByIds(String str) {
		return depPosDAO.deleteByIds(str);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IDepPosService#editSave(com.dihaitech.managercenter.model.DepPos)
	 */
	public int editSave(DepPos depPos) {
		return depPosDAO.editSaveDepPos(depPos);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.IDepPosService#selectAll()
	 */
	public List<DepPos> selectAll() {
		return depPosDAO.selectAll();
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IDepPosService#selectDepPos(com.dihaitech.managercenter.model.DepPos, int)
	 */
	public Page selectDepPos(DepPos depPos, int pageSize) {
		return new Page(depPosDAO.getDepPosCount(depPos), pageSize);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IDepPosService#selectDepPos(com.dihaitech.managercenter.model.DepPos, com.dihaitech.managercenter.controller.helper.Page)
	 */
	public List<DepPos> selectDepPos(DepPos depPos, Page page) {
		depPos.setStart(page.getFirstItemPos());
		depPos.setPageSize(page.getPageSize());
		return depPosDAO.selectDepPosLike(depPos);
	}

	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IDepPosService#selectDepPosById(com.dihaitech.managercenter.model.DepPos)
	 */
	public DepPos selectDepPosById(DepPos depPos) {
		return depPosDAO.selectDepPosById(depPos);
	}


	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IDepPosService#selectDepPosByDepId(com.dihaitech.managercenter.model.DepPos)
	 */
	@Override
	public List<DepPos> selectDepPosByDepId(DepPos depPos) {
		// TODO Auto-generated method stub
		return depPosDAO.selectDepPosByDepId(depPos);
	}


	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IDepPosService#deleteByDepId(com.dihaitech.managercenter.model.DepPos)
	 */
	@Override
	public int deleteByDepId(DepPos depPos) {
		// TODO Auto-generated method stub
		return depPosDAO.deleteByDepId(depPos);
	}
}
