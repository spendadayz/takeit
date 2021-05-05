package com.takeit.model.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
	// 상품
	private String itemTakeit;
	// 배송
	private String shipStatus;

	// 주문
	private String orderNo;
	private String receiveMethod;
	private String recipientName;
	private String recipientPostNo;
	private String recipientAddr;
	private String recipientMobile;
	private String shipRequest;
	private int orderPrice;
	private String shipStatusCode;
	private String memberId;
	// 주문상세
	private ArrayList<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
	
	
	public Order() {
	}

	/**
	 * 전체 데이터 초기화 생성자
	 * 
	 * @param itemTakeit      잇거래여부
	 * @param shipStatus      배송상태
	 * @param orderNo         주문번호
	 * @param receiveMethod   수령방법
	 * @param recipientName   수령인 이름
	 * @param recipientPostNo 수령인 우편번호
	 * @param recipientAddr   수령인 주소
	 * @param recipientMobile 수령인 연락처
	 * @param shipRequest     배송요청사항
	 * @param orderPrice      총주문금액
	 * @param shipStatusCode  배송상태코드
	 * @param memberId        주문자 아이디
	 * @param itemNos         상품번호
	 * @param itemQtys        상품수량
	 * @param itemPayPrices   상품결제가격
	 */
	public String getItemTakeit() {
		return itemTakeit;
	}

	public Order(String itemTakeit, String shipStatus, String orderNo, String receiveMethod, String recipientName,
			String recipientPostNo, String recipientAddr, String recipientMobile, String shipRequest, int orderPrice,
			String shipStatusCode, String memberId, ArrayList<OrderDetail> orderDetails) {
		super();
		this.itemTakeit = itemTakeit;
		this.shipStatus = shipStatus;
		this.orderNo = orderNo;
		this.receiveMethod = receiveMethod;
		this.recipientName = recipientName;
		this.recipientPostNo = recipientPostNo;
		this.recipientAddr = recipientAddr;
		this.recipientMobile = recipientMobile;
		this.shipRequest = shipRequest;
		this.orderPrice = orderPrice;
		this.shipStatusCode = shipStatusCode;
		this.memberId = memberId;
		this.orderDetails = orderDetails;
	}

	public String getShipStatus() {
		return shipStatus;
	}

	public void setShipStatus(String shipStatus) {
		this.shipStatus = shipStatus;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getReceiveMethod() {
		return receiveMethod;
	}

	public void setReceiveMethod(String receiveMethod) {
		this.receiveMethod = receiveMethod;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientPostNo() {
		return recipientPostNo;
	}

	public void setRecipientPostNo(String recipientPostNo) {
		this.recipientPostNo = recipientPostNo;
	}

	public String getRecipientAddr() {
		return recipientAddr;
	}

	public void setRecipientAddr(String recipientAddr) {
		this.recipientAddr = recipientAddr;
	}

	public String getRecipientMobile() {
		return recipientMobile;
	}

	public void setRecipientMobile(String recipientMobile) {
		this.recipientMobile = recipientMobile;
	}

	public String getShipRequest() {
		return shipRequest;
	}

	public void setShipRequest(String shipRequest) {
		this.shipRequest = shipRequest;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getShipStatusCode() {
		return shipStatusCode;
	}

	public void setShipStatusCode(String shipStatusCode) {
		this.shipStatusCode = shipStatusCode;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public ArrayList<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(ArrayList<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public void setItemTakeit(String itemTakeit) {
		this.itemTakeit = itemTakeit;
	}
	
	

}
