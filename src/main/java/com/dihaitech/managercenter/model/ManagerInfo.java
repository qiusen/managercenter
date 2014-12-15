package com.dihaitech.managercenter.model;

import java.util.Date;

/**
 * 管理员详细信息
 * 
 * @author cg
 *
 * @date 2014-12-10
 */
@SuppressWarnings("serial")
public class ManagerInfo extends BaseModel{
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 座机
	 */
	private String tel;
	
	/**
	 * 手机
	 */
	private String mobile;
	
	/**
	 * 性别：0、保密；1、男；2、女
	 */
	private Integer sex;
	
	/**
	 * 联系地址
	 */
	private String address;
	
	/**
	 * QQ
	 */
	private String qq;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
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
}
