package com.dihaiboyun.managercenter.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.dihaiboyun.managercenter.dao.IAreaDAO;
import com.dihaiboyun.managercenter.model.Area;
import com.dihaiboyun.managercenter.service.IAreaService;
import com.dihaiboyun.managercenter.util.Page;

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
	 * @see com.dihaiboyun.oa.service.IAreaService#addSave(com.dihaiboyun.oa.model.Area)
	 */
	public int addSave(Area area) {
		return areaDAO.addSaveArea(area);
	}
	
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IAreaService#deleteByIds(java.lang.String)
	 */
	public int deleteByIds(String str) {
		return areaDAO.deleteByIds(str);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IAreaService#editSave(com.dihaiboyun.oa.model.Area)
	 */
	public int editSave(Area area) {
		return areaDAO.editSaveArea(area);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.IAreaService#selectAll()
	 */
	public List<Area> selectAll() {
		return areaDAO.selectAll();
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IAreaService#selectArea(com.dihaiboyun.oa.model.Area, int)
	 */
	public Page selectArea(Area area, int pageSize) {
		return new Page(areaDAO.getAreaCount(area), pageSize);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IAreaService#selectArea(com.dihaiboyun.oa.model.Area, com.dihaiboyun.oa.controller.helper.Page)
	 */
	public List<Area> selectArea(Area area, Page page) {
		area.setStart(page.getFirstItemPos());
		area.setPageSize(page.getPageSize());
		return areaDAO.selectAreaLike(area);
	}

	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IAreaService#selectAreaById(com.dihaiboyun.oa.model.Area)
	 */
	public Area selectAreaById(Area area) {
		return areaDAO.selectAreaById(area);
	}
}
