package com.dihaiboyun.managercenter.controller.action.city;

import java.util.List;

import com.dihaiboyun.managercenter.common.Property;
import com.dihaiboyun.managercenter.controller.action.BaseAction;
import com.dihaiboyun.managercenter.model.City;
import com.dihaiboyun.managercenter.model.Province;
import com.dihaiboyun.managercenter.service.ICityService;
import com.dihaiboyun.managercenter.service.IProvinceService;
import com.dihaiboyun.managercenter.util.Page;
import com.dihaiboyun.managercenter.util.TypeUtil;
import com.dihaiboyun.managercenter.util.json.JSONUtil;

/**
 * 市Action
 * 
 * @author cg
 *
 * @date 2014-03-01
 */
 @SuppressWarnings("serial")
public class CityAction extends BaseAction {
	private City city = new City();
	private ICityService cityService;
	
	private IProvinceService provinceService;
	
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	public ICityService getCityService() {
		return cityService;
	}

	public void setCityService(ICityService cityService) {
		this.cityService = cityService;
	}
	
	public IProvinceService getProvinceService() {
		return provinceService;
	}

	public void setProvinceService(IProvinceService provinceService) {
		this.provinceService = provinceService;
	}

	/* 
	 * 市查询
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

			Page pageInfo = cityService.selectCity(city,this.getManagerPageSize());
			
			if (pageNo > 0) {
				pageInfo.setPage(pageNo);
			} else {
				pageInfo.setPage(0);
			}
			
			List<City> resultList = this.cityService.selectCity(city,pageInfo);
			
			this.getRequest().setAttribute("pageInfo", pageInfo);
			this.getRequest().setAttribute("resultList", resultList);
			this.getRequest().setAttribute("actionName","cityAction");

			String json = "\"Rows\":" + JSONUtil.objectArrayToJson(resultList)+", \"Total\":" + pageInfo.getResultCount();
			System.out.println("City json:::::::::::::::::::" + json);
			this.getRequest().setAttribute("json", json);
			
			if(resultList!=null && resultList.size()>0){
				City city = null;
				StringBuffer strbuf = new StringBuffer();
				for(int i=0;i<resultList.size();i++){
					city = resultList.get(i);
					if(i==0){
						strbuf.append("'" + city.getProvinceCode() + "'");
					}else{
						strbuf.append(", '" + city.getProvinceCode() + "'");
					}
				}
				
				Province province = new Province();
				province.setIdStr(strbuf.toString());
				List<Province> provinceList = provinceService.selectProvinceByCodes(province);
				this.getRequest().setAttribute("provinceList", provinceList);
			}
			
			List<Province> pList = provinceService.selectAll();
			this.getRequest().setAttribute("pList", pList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 添加 市
	 * @return
	 */
	public String add(){
		List<Province> provinceList = provinceService.selectAll();
		this.getRequest().setAttribute("provinceList", provinceList);
		
		return "add";
	}
	
	/**
	 * 保存添加 市
	 * @return
	 */
	public String addSave(){
		cityService.addSave(city);
		return "addSave";
	}
	
	/**
	 * 修改 市
	 * @return
	 */
	public String edit(){
		String idStr = this.getRequest().getParameter("id");
		int id = 0;
		id = TypeUtil.stringToInt(idStr);
		if(id>0){
			city.setId(id);
		}else{
			return null;
		}
		
		City cityVO = cityService.selectCityById(city);
		this.getRequest().setAttribute("city", cityVO);
		
		List<Province> provinceList = provinceService.selectAll();
		this.getRequest().setAttribute("provinceList", provinceList);
		return "edit";
	}
	
	/**
	 * 保存修改 市
	 * @return
	 */
	public String editSave(){
		cityService.editSave(city);
		return "editSave";
	}
	
	/**
	 * 删除 市
	 * @return
	 */
	public String delete(){
		String id = this.getRequest().getParameter("id");
		StringBuffer strbuf = new StringBuffer(" where id =");
		strbuf.append(id);
		cityService.deleteByIds(strbuf.toString());
		return "deleteSuccess";
	}

	/**
	 * 删除 市
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
			cityService.deleteByIds(strbuf.toString());
			return "deleteSuccess";
		}
		return "deleteFailure";
	}
}