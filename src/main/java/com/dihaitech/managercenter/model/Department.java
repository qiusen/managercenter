package com.dihaitech.managercenter.model;

import java.util.Date;

/**
 * 部门
 * 
 * @author cg
 *
 * @date 2014-12-11
 */
@SuppressWarnings("serial")
public class Department extends BaseModel{
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 代号
	 */
	private String code;
	
	/**
	 * 类型：1、公司；2、部门；3、项目组
	 */
	private Integer type;
	
	/**
	 * 主管EMAIL
	 */
	private String leaderEmail;
	
	/**
	 * 上级部门ID
	 */
	private Integer superId;
	
	/**
	 * 创建人
	 */
	private String creator;
	
	/**
	 * 创建时间
	 */
	private Date createtime;
	
	/**
	 * 修改人
	 */
	private String updator;
	
	/**
	 * 修改时间
	 */
	private Date updatetime;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getSuperId() {
		return superId;
	}
	public void setSuperId(Integer superId) {
		this.superId = superId;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getUpdator() {
		return updator;
	}
	public void setUpdator(String updator) {
		this.updator = updator;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public String getLeaderEmail() {
		return leaderEmail;
	}
	public void setLeaderEmail(String leaderEmail) {
		this.leaderEmail = leaderEmail;
	}
	
}
