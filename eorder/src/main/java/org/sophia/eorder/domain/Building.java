package org.sophia.eorder.domain;
// Generated 2013-7-4 0:35:54 by Hibernate Tools 3.4.0.CR1

/**
 * Building generated by hbm2java
 */
public class Building implements java.io.Serializable {

	private String buildingid;
	private String name;
	private String areaid;

	public Building() {
	}

	public Building(String buildingid, String areaid) {
		this.buildingid = buildingid;
		this.areaid = areaid;
	}

	public Building(String buildingid, String name, String areaid) {
		this.buildingid = buildingid;
		this.name = name;
		this.areaid = areaid;
	}

	public String getBuildingid() {
		return this.buildingid;
	}

	public void setBuildingid(String buildingid) {
		this.buildingid = buildingid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAreaid() {
		return this.areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

}
