package com.takeit.model.dto;

import java.io.Serializable;

public class ShopLoc implements Serializable{
	private String shopLocCode;
	private String shopLocName;
	private String shopLocLat;
	private String shopLocLng;
	
	public ShopLoc() {	}

	public ShopLoc(String shopLocCode, String shopLocName, String shopLocLat, String shopLocLng) {
		super();
		this.shopLocCode = shopLocCode;
		this.shopLocName = shopLocName;
		this.shopLocLat = shopLocLat;
		this.shopLocLng = shopLocLng;
	}

	public String getShopLocCode() {
		return shopLocCode;
	}

	public void setShopLocCode(String shopLocCode) {
		this.shopLocCode = shopLocCode;
	}

	public String getShopLocName() {
		return shopLocName;
	}

	public void setShopLocName(String shopLocName) {
		this.shopLocName = shopLocName;
	}

	public String getShopLocLat() {
		return shopLocLat;
	}

	public void setShopLocLat(String shopLocLat) {
		this.shopLocLat = shopLocLat;
	}

	public String getShopLocLng() {
		return shopLocLng;
	}

	public void setShopLocLng(String shopLocLng) {
		this.shopLocLng = shopLocLng;
	}
	
	
}
