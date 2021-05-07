package com.takeit.model.dto;

/**
 * 잇거래 도메인 클래스
 * @author 김태경
 */
public class Takeit {
	private String takeitNo;
	private String shopLocCode;
	private String memberLocNo;
	private String takeitPrice;

	public Takeit() {
	}

	public String getMemberLocNo() {
		return memberLocNo;
	}

	public void setMemberLocNo(String memberLocNo) {
		this.memberLocNo = memberLocNo;
	}

	public String getTakeitNo() {
		return takeitNo;
	}

	public void setTakeitNo(String takeitNo) {
		this.takeitNo = takeitNo;
	}

	public String getShopLocCode() {
		return shopLocCode;
	}

	public void setShopLocCode(String shopLocCode) {
		this.shopLocCode = shopLocCode;
	}

	public String getTakeitPrice() {
		return takeitPrice;
	}

	public void setTakeitPrice(String takeitPrice) {
		this.takeitPrice = takeitPrice;
	}

}
