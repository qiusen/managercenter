package com.dihaiboyun.managercenter.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.dihaiboyun.managercenter.dao.ICityDAO;
import com.dihaiboyun.managercenter.model.City;
import com.dihaiboyun.managercenter.service.ICityService;
import com.dihaiboyun.managercenter.util.Page;

/**
 * 市 业务接口 ICityService 实现类
 * 
 * @author cg
 *
 * @date 2014-08-20
 */
public class CityServiceImpl implements ICityService {

	@Resource
	private ICityDAO cityDAO;

	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.ICityService#addSave(com.dihaiboyun.oa.model.City)
	 */
	public int addSave(City city) {
		return cityDAO.addSaveCity(city);
	}
	
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.ICityService#deleteByIds(java.lang.String)
	 */
	public int deleteByIds(String str) {
		return cityDAO.deleteByIds(str);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.ICityService#editSave(com.dihaiboyun.oa.model.City)
	 */
	public int editSave(City city) {
		return cityDAO.editSaveCity(city);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.ICityService#selectAll()
	 */
	public List<City> selectAll() {
		return cityDAO.selectAll();
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.ICityService#selectCity(com.dihaiboyun.oa.model.City, int)
	 */
	public Page selectCity(City city, int pageSize) {
		return new Page(cityDAO.getCityCount(city), pageSize);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.ICityService#selectCity(com.dihaiboyun.oa.model.City, com.dihaiboyun.oa.controller.helper.Page)
	 */
	public List<City> selectCity(City city, Page page) {
		city.setStart(page.getFirstItemPos());
		city.setPageSize(page.getPageSize());
		return cityDAO.selectCityLike(city);
	}

	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.ICityService#selectCityById(com.dihaiboyun.oa.model.City)
	 */
	public City selectCityById(City city) {
		return cityDAO.selectCityById(city);
	}


	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.ICityService#selectCityByProvinceCode(com.dihaiboyun.oa.model.City)
	 */
	@Override
	public List<City> selectCityByProvinceCode(City city) {
		// TODO Auto-generated method stub
		return cityDAO.selectCityByProvinceCode(city);
	}


	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.ICityService#selectCityByCodes(com.dihaiboyun.oa.model.City)
	 */
	@Override
	public List<City> selectCityByCodes(City city) {
		// TODO Auto-generated method stub
		return cityDAO.selectCityByCodes(city);
	}


	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.ICityService#selectCityByCode(com.dihaiboyun.oa.model.City)
	 */
	@Override
	public City selectCityByCode(City city) {
		// TODO Auto-generated method stub
		return cityDAO.selectCityByCode(city);
	}
}
