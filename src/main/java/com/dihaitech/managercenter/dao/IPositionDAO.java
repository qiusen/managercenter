package com.dihaitech.managercenter.dao;

import java.util.List;


import com.dihaitech.managercenter.model.Position;

/**
 * 职位 DAO 接口
 * 
 * @author cg
 * 
 * @since 2014-12-11
 */
public interface IPositionDAO {

	/**
	 * 根据条件查询职位 条数
	 * 
	 * @param position
	 * @return
	 */
	public Long getPositionCount(Position position);

	/**
	 * 分页查找职位
	 * 
	 * @param position
	 * @param page
	 * @return
	 */
	public List<Position> selectPositionLike(Position position);

	/**
	 * 添加职位
	 * 
	 * @param position
	 * @return
	 */
	public int addSavePosition(Position position);

	/**
	 * 根据ID获取指定的职位信息
	 * 
	 * @param position
	 * @return
	 */
	public Position selectPositionById(Position position);

	/**
	 * 修改职位
	 * 
	 * @param position
	 * @return
	 */
	public int editSavePosition(Position position);

	/**
	 * 根据ID删除指定的职位
	 * 
	 * @param str
	 * @return
	 */
	public int deleteByIds(String str);

	/**
	 * 查询所有职位
	 * 
	 * @return
	 */
	public List<Position> selectAll();
	
	/**
	 * 根据IDS获取职位
	 * @param position
	 * @return
	 */
	public List<Position> selectPositionByIds(Position position);
}
