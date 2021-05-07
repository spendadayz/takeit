package com.takeit.model.dto;

/**
 * 배송상태 도메인 클래스
 * @author 김태경
 */
public class Shipping {
	private String shipStatusCode;
	private String shipStatus;
	
	public Shipping() {}

	public String getShipStatusCode() {
		return shipStatusCode;
	}

	public void setShipStatusCode(String shipStatusCode) {
		this.shipStatusCode = shipStatusCode;
	}

	public String getShipStatus() {
		return shipStatus;
	}

	public void setShipStatus(String shipStatus) {
		this.shipStatus = shipStatus;
	}
	
}
