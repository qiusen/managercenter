package com.dihaiboyun.managercenter.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.dihaiboyun.managercenter.dao.IModuleDAO;
import com.dihaiboyun.managercenter.model.Module;
import com.dihaiboyun.managercenter.service.IModuleService;
import com.dihaiboyun.managercenter.util.Page;

/**
 * 模块 业务接口 IModuleService 实现类
 * 
 * @author cg
 *
 * @date 2014-08-19
 */
public class ModuleServiceImpl implements IModuleService {

	@Resource
	private IModuleDAO moduleDAO;

	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IModuleService#addSave(com.dihaiboyun.oa.model.Module)
	 */
	public int addSave(Module module) {
		return moduleDAO.addSaveModule(module);
	}
	
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IModuleService#deleteByIds(java.lang.String)
	 */
	public int deleteByIds(String str) {
		return moduleDAO.deleteByIds(str);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IModuleService#editSave(com.dihaiboyun.oa.model.Module)
	 */
	public int editSave(Module module) {
		return moduleDAO.editSaveModule(module);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.IModuleService#selectAll()
	 */
	public List<Module> selectAll() {
		return moduleDAO.selectAll();
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IModuleService#selectModule(com.dihaiboyun.oa.model.Module, int)
	 */
	public Page selectModule(Module module, int pageSize) {
		return new Page(moduleDAO.getModuleCount(module), pageSize);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IModuleService#selectModule(com.dihaiboyun.oa.model.Module, com.dihaiboyun.oa.controller.helper.Page)
	 */
	public List<Module> selectModule(Module module, Page page) {
		module.setStart(page.getFirstItemPos());
		module.setPageSize(page.getPageSize());
		return moduleDAO.selectModuleLike(module);
	}

	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IModuleService#selectModuleById(com.dihaiboyun.oa.model.Module)
	 */
	public Module selectModuleById(Module module) {
		return moduleDAO.selectModuleById(module);
	}


	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IModuleService#selectModuleByIdStr(com.dihaiboyun.oa.model.Module)
	 */
	@Override
	public List<Module> selectModuleByIdStr(Module module) {
		// TODO Auto-generated method stub
		return moduleDAO.selectModuleByIdStr(module);
	}


	/* (non-Javadoc)
	 * @see com.dihaiboyun.oa.service.IModuleService#selectAllByStatus(com.dihaiboyun.oa.model.Module)
	 */
	@Override
	public List<Module> selectAllByStatus(Module module) {
		// TODO Auto-generated method stub
		return moduleDAO.selectAllByStatus(module);
	}
}
