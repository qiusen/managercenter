package com.dihaiboyun.managercenter.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.dihaiboyun.managercenter.dao.IMenuDAO;
import com.dihaiboyun.managercenter.model.Menu;
import com.dihaiboyun.managercenter.service.IMenuService;
import com.dihaiboyun.managercenter.util.Page;

/**
 * 菜单 业务接口 IMenuService 实现类
 * 
 * @author cg
 *
 * @date 2014-08-18
 */
public class MenuServiceImpl implements IMenuService {

	@Resource
	private IMenuDAO menuDAO;

	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IMenuService#addSave(com.dihaiboyun.oa.model.Menu)
	 */
	public int addSave(Menu menu) {
		return menuDAO.addSaveMenu(menu);
	}
	
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IMenuService#deleteByIds(java.lang.String)
	 */
	public int deleteByIds(String str) {
		return menuDAO.deleteByIds(str);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IMenuService#editSave(com.dihaiboyun.oa.model.Menu)
	 */
	public int editSave(Menu menu) {
		return menuDAO.editSaveMenu(menu);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.IMenuService#selectAll()
	 */
	public List<Menu> selectAll() {
		return menuDAO.selectAll();
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IMenuService#selectMenu(com.dihaiboyun.oa.model.Menu, int)
	 */
	public Page selectMenu(Menu menu, int pageSize) {
		return new Page(menuDAO.getMenuCount(menu), pageSize);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IMenuService#selectMenu(com.dihaiboyun.oa.model.Menu, com.dihaiboyun.oa.controller.helper.Page)
	 */
	public List<Menu> selectMenu(Menu menu, Page page) {
		menu.setStart(page.getFirstItemPos());
		menu.setPageSize(page.getPageSize());
		return menuDAO.selectMenuLike(menu);
	}

	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IMenuService#selectMenuById(com.dihaiboyun.oa.model.Menu)
	 */
	public Menu selectMenuById(Menu menu) {
		return menuDAO.selectMenuById(menu);
	}


	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IMenuService#selectMenuByIdsStatus(com.dihaiboyun.oa.model.Menu)
	 */
	@Override
	public List<Menu> selectMenuByIdsStatus(Menu menu) {
		// TODO Auto-generated method stub
		return menuDAO.selectMenuByIdsStatus(menu);
	}


	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IMenuService#selectAllByStatus(com.dihaiboyun.oa.model.Menu)
	 */
	@Override
	public List<Menu> selectAllByStatus(Menu menu) {
		// TODO Auto-generated method stub
		return menuDAO.selectAllByStatus(menu);
	}
}
