package com.dihaiboyun.managercenter.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.dihaiboyun.managercenter.dao.IProvinceDAO;
import com.dihaiboyun.managercenter.model.Province;
import com.dihaiboyun.managercenter.service.IProvinceService;
import com.dihaiboyun.managercenter.util.Page;

/**
 * 省 业务接口 IProvinceService 实现类
 * 
 * @author cg
 *
 * @date 2014-08-20
 */
public class ProvinceServiceImpl implements IProvinceService {

	@Resource
	private IProvinceDAO provinceDAO;

	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IProvinceService#addSave(com.dihaiboyun.oa.model.Province)
	 */
	public int addSave(Province province) {
		return provinceDAO.addSaveProvince(province);
	}
	
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IProvinceService#deleteByIds(java.lang.String)
	 */
	public int deleteByIds(String str) {
		return provinceDAO.deleteByIds(str);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IProvinceService#editSave(com.dihaiboyun.oa.model.Province)
	 */
	public int editSave(Province province) {
		return provinceDAO.editSaveProvince(province);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.IProvinceService#selectAll()
	 */
	public List<Province> selectAll() {
		return provinceDAO.selectAll();
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IProvinceService#selectProvince(com.dihaiboyun.oa.model.Province, int)
	 */
	public Page selectProvince(Province province, int pageSize) {
		return new Page(provinceDAO.getProvinceCount(province), pageSize);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IProvinceService#selectProvince(com.dihaiboyun.oa.model.Province, com.dihaiboyun.oa.controller.helper.Page)
	 */
	public List<Province> selectProvince(Province province, Page page) {
		province.setStart(page.getFirstItemPos());
		province.setPageSize(page.getPageSize());
		return provinceDAO.selectProvinceLike(province);
	}

	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IProvinceService#selectProvinceById(com.dihaiboyun.oa.model.Province)
	 */
	public Province selectProvinceById(Province province) {
		return provinceDAO.selectProvinceById(province);
	}


	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IProvinceService#selectProvinceByCodes(com.dihaiboyun.oa.model.Province)
	 */
	@Override
	public List<Province> selectProvinceByCodes(Province province) {
		// TODO Auto-generated method stub
		return provinceDAO.selectProvinceByCodes(province);
	}
}
