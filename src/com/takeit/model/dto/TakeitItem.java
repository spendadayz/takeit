package com.takeit.model.dto;

import java.io.Serializable;

public class TakeitItem extends Item implements Serializable {
	private String takeitNo;
	private int takeitPrice;
	private int takeitCurrPrice;
	private String takeitDate;
	private double takeitCustScore;
	private String takeitAlive; // boolean으로 할지 결정해야함 문자열위주로?
	private String memberLocNo;
	private String shopLocCode;
	//남은시간을 ajax로 처리하려면 모집일자를 통해서 서버를 통해 받아서 나타낸다 setInterval(ajax)함수를  이용하므로 도메인은 넣지않음  
	
	public TakeitItem() {
	}
	
	public TakeitItem(String takeitNo, int takeitPrice, int takeitCurrPrice, String takeitDate, double takeitCustScore,
			String takeitAlive, String memberLocNo, String shopLocCode) {
		super();
		this.takeitNo = takeitNo;
		this.takeitPrice = takeitPrice;
		this.takeitCurrPrice = takeitCurrPrice;
		this.takeitDate = takeitDate;
		this.takeitCustScore = takeitCustScore;
		this.takeitAlive = takeitAlive;
		this.memberLocNo = memberLocNo;
		this.shopLocCode = shopLocCode;
	}

	public String getTakeitDate() {
		return takeitDate;
	}

	public void setTakeitDate(String takeitDate) {
		this.takeitDate = takeitDate;
	}

	public String getTakeitNo() {
		return takeitNo;
	}

	public void setTakeitNo(String takeitNo) {
		this.takeitNo = takeitNo;
	}

	public int getTakeitPrice() {
		return takeitPrice;
	}

	public void setTakeitPrice(int takeitPrice) {
		this.takeitPrice = takeitPrice;
	}

	public int getTakeitCurrPrice() {
		return takeitCurrPrice;
	}

	public void setTakeitCurrPrice(int takeitCurrPrice) {
		this.takeitCurrPrice = takeitCurrPrice;
	}

	public double getTakeitCustScore() {
		return takeitCustScore;
	}

	public void setTakeitCustScore(double takeitCustScore) {
		this.takeitCustScore = takeitCustScore;
	}

	public String getTakeitAlive() {
		return takeitAlive;
	}

	public void setTakeitAlive(String takeitAlive) {
		this.takeitAlive = takeitAlive;
	}

	public String getMemberLocNo() {
		return memberLocNo;
	}

	public void setMemberLocNo(String memberLocNo) {
		this.memberLocNo = memberLocNo;
	}

	public String getShopLocCode() {
		return shopLocCode;
	}

	public void setShopLocCode(String shopLocCode) {
		this.shopLocCode = shopLocCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(takeitNo);
		builder.append(", ");
		builder.append(takeitPrice);
		builder.append(", ");
		builder.append(takeitCurrPrice);
		builder.append(", ");
		builder.append(takeitDate);
		builder.append(", ");
		builder.append(takeitCustScore);
		builder.append(", ");
		builder.append(takeitAlive);
		builder.append(", ");
		builder.append(memberLocNo);
		builder.append(", ");
		builder.append(shopLocCode);
		return builder.toString();
	}
}
