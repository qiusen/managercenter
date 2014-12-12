package com.dihaitech.managercenter.service;

import java.util.List;


import com.dihaitech.managercenter.model.Position;
import com.dihaitech.managercenter.util.Page;

/**
 * 职位 业务接口
 * 
 * @author cg
 *
 * @date 2014-12-11
 */
public interface IPositionService {
	/**
	 * 查询 Position Page 对象
	 * @param position
	 * @param pageSize
	 * @return
	 */
	public Page selectPosition(Position position, int pageSize);

	/**
	 * 分页查找 职位
	 * @param position
	 * @param page
	 * @return
	 */
	public List<Position> selectPosition(Position position, Page page);
	
	/**
	 * 查询所有 职位
	 * @return
	 */
	public List<Position> selectAll();
	
	/**
	 * 根据 ID 查找 职位 
	 * @param position
	 * @return
	 */
	public Position selectPositionById(Position position);
	
	/**
	 * 添加 职位 
	 * @param position
	 * @return
	 */
	public int addSave(Position position);
	
	/**
	 * 修改 职位 
	 * @param position
	 * @return
	 */
	public int editSave(Position position);
	
	/**
	 * 根据 ID 删除 职位 
	 * @param str
	 * @return
	 */
	public int deleteByIds(String str);
	
	/**
	 * 根据IDS获取职位
	 * @param position
	 * @return
	 */
	public List<Position> selectPositionByIds(Position position);
}
