package org.sophia.eorder.domain;
// Generated 2013-7-4 0:35:54 by Hibernate Tools 3.4.0.CR1

/**
 * Orderedfood generated by hbm2java
 */
public class Orderedfood implements java.io.Serializable {

	private Integer id;
	private String orderid;
	private Short menuid;
	private Short foodCount;
	private String foodType;

	public Orderedfood() {
	}

	public Orderedfood(String orderid) {
		this.orderid = orderid;
	}

	public Orderedfood(String orderid, Short menuid, Short foodCount,
			String foodType) {
		this.orderid = orderid;
		this.menuid = menuid;
		this.foodCount = foodCount;
		this.foodType = foodType;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderid() {
		return this.orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public Short getMenuid() {
		return this.menuid;
	}

	public void setMenuid(Short menuid) {
		this.menuid = menuid;
	}

	public Short getFoodCount() {
		return this.foodCount;
	}

	public void setFoodCount(Short foodCount) {
		this.foodCount = foodCount;
	}

	public String getFoodType() {
		return this.foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

}