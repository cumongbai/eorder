package org.sophia.eorder.domain;
// Generated 2013-7-4 0:35:54 by Hibernate Tools 3.4.0.CR1

/**
 * Area generated by hbm2java
 */
public class Area implements java.io.Serializable {

	private String areaid;
	private String areaName;

	public Area() {
	}

	public Area(String areaid, String areaName) {
		this.areaid = areaid;
		this.areaName = areaName;
	}

	public String getAreaid() {
		return this.areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

}
