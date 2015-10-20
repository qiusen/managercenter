package com.dihaiboyun.managercenter.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.dihaiboyun.managercenter.dao.ICatalogDAO;
import com.dihaiboyun.managercenter.model.Catalog;
import com.dihaiboyun.managercenter.service.ICatalogService;
import com.dihaiboyun.managercenter.util.Page;

/**
 * 目录 业务接口 ICatalogService 实现类
 * 
 * @author cg
 *
 * @date 2014-08-18
 */
public class CatalogServiceImpl implements ICatalogService {

	@Resource
	private ICatalogDAO catalogDAO;

	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.ICatalogService#addSave(com.dihaiboyun.oa.model.Catalog)
	 */
	public int addSave(Catalog catalog) {
		return catalogDAO.addSaveCatalog(catalog);
	}
	
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.ICatalogService#deleteByIds(java.lang.String)
	 */
	public int deleteByIds(String str) {
		return catalogDAO.deleteByIds(str);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.ICatalogService#editSave(com.dihaiboyun.oa.model.Catalog)
	 */
	public int editSave(Catalog catalog) {
		return catalogDAO.editSaveCatalog(catalog);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.ICatalogService#selectAll()
	 */
	public List<Catalog> selectAll() {
		return catalogDAO.selectAll();
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.ICatalogService#selectCatalog(com.dihaiboyun.oa.model.Catalog, int)
	 */
	public Page selectCatalog(Catalog catalog, int pageSize) {
		return new Page(catalogDAO.getCatalogCount(catalog), pageSize);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.ICatalogService#selectCatalog(com.dihaiboyun.oa.model.Catalog, com.dihaiboyun.oa.controller.helper.Page)
	 */
	public List<Catalog> selectCatalog(Catalog catalog, Page page) {
		catalog.setStart(page.getFirstItemPos());
		catalog.setPageSize(page.getPageSize());
		return catalogDAO.selectCatalogLike(catalog);
	}

	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.ICatalogService#selectCatalogById(com.dihaiboyun.oa.model.Catalog)
	 */
	public Catalog selectCatalogById(Catalog catalog) {
		return catalogDAO.selectCatalogById(catalog);
	}


	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.ICatalogService#selectCatalogByIdsStatus(com.dihaiboyun.oa.model.Catalog)
	 */
	@Override
	public List<Catalog> selectCatalogByIdsStatus(Catalog catalog) {
		// TODO Auto-generated method stub
		return catalogDAO.selectCatalogByIdsStatus(catalog);
	}


	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.ICatalogService#selectAllByStatus(com.dihaiboyun.oa.model.Catalog)
	 */
	@Override
	public List<Catalog> selectAllByStatus(Catalog catalog) {
		// TODO Auto-generated method stub
		return catalogDAO.selectAllByStatus(catalog);
	}


	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.ICatalogService#selectAllByMenuStatus(com.dihaiboyun.oa.model.Catalog)
	 */
	@Override
	public List<Catalog> selectAllByMenuStatus(Catalog catalog) {
		// TODO Auto-generated method stub
		return catalogDAO.selectAllByMenuStatus(catalog);
	}
}
