package com.dihaitech.managercenter.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.dihaitech.managercenter.dao.IAreaDAO;
import com.dihaitech.managercenter.model.Area;
import com.dihaitech.managercenter.service.IAreaService;
import com.dihaitech.managercenter.util.Page;

/**
 * 区 业务接口 IAreaService 实现类
 * 
 * @author cg
 *
 * @date 2014-08-21
 */
public class AreaServiceImpl implements IAreaService {

	@Resource
	private IAreaDAO areaDAO;

	/* (non-Javadoc)
	 * @see com.dihaitech.oa.service.IAreaService#addSave(com.dihaitech.oa.model.Area)
	 */
	public int addSave(Area area) {
		return areaDAO.addSaveArea(area);
	}
	
	
	/* (non-Javadoc)
	 * @see com.dihaitech.oa.service.IAreaService#deleteByIds(java.lang.String)
	 */
	public int deleteByIds(String str) {
		return areaDAO.deleteByIds(str);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.oa.service.IAreaService#editSave(com.dihaitech.oa.model.Area)
	 */
	public int editSave(Area area) {
		return areaDAO.editSaveArea(area);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.oa.IAreaService#selectAll()
	 */
	public List<Area> selectAll() {
		return areaDAO.selectAll();
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.oa.service.IAreaService#selectArea(com.dihaitech.oa.model.Area, int)
	 */
	public Page selectArea(Area area, int pageSize) {
		return new Page(areaDAO.getAreaCount(area), pageSize);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.oa.service.IAreaService#selectArea(com.dihaitech.oa.model.Area, com.dihaitech.oa.controller.helper.Page)
	 */
	public List<Area> selectArea(Area area, Page page) {
		area.setStart(page.getFirstItemPos());
		area.setPageSize(page.getPageSize());
		return areaDAO.selectAreaLike(area);
	}

	/* (non-Javadoc)
	 * @see com.dihaitech.oa.service.IAreaService#selectAreaById(com.dihaitech.oa.model.Area)
	 */
	public Area selectAreaById(Area area) {
		return areaDAO.selectAreaById(area);
	}
}
