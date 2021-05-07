package com.takeit.model.dto;

import java.io.Serializable;

/**
 * 회원가입 : 판매자회원 도메인
 * @author 임우진
 * 
 */
public class Seller implements Serializable{	
	
	/**
	 * @param 멤버변수 
	 * sellerId : 아이디
	 * sellerPw : 비밀번호
	 * name : 이름
	 * mobile : 휴대폰번호
	 * email : 이메일
	 * entryDate : 가입일
	 * postNo : 우편번호
	 * address : 도로명주소
	 * addressDetail : 상세주소
	 * grade : 등급
	 * sellerNo : 사업자등록번호
	 * shopMobile : 상점연락처
	 * shopName : 상점명
	 * custScore : 고객평점
	 * shopKakaoId : 카카오톡아이디
	 * shopImg : 상점이미지
	 * shopCategoryNo : 상점카테고리번호
	 * shopLocCode : 상점구역코드
	 */
	private String sellerId;
	private String sellerPw;
	private String name;
	private String mobile;
	private String email;
	private String entryDate; // TIMESTAMP 형식으로 DB에서 처리할때 TO_CHAR 필요
	private String postNo;
	private String address;
	private String addressDetail;
	private String grade;
	private String sellerNo;
	private String shopMobile;
	private String shopName;
	private double custScore;
	private String shopKakaoId;
	private String shopImg;
	private String shopCategoryNo;
	private String shopLocCode;
	private String shopCategoryName;
	
	/* 기본 생성자 */
	public Seller() {}

	/* 사용자 입력 데이터 */
	public Seller(String sellerId, String sellerPw, String name, String mobile, String email, String postNo,
			String address, String addressDetail, String sellerNo, String shopMobile, String shopName,
			String shopKakaoId, String shopImg, String shopCategoryNo, String shopLocCode) {
		this.sellerId = sellerId;
		this.sellerPw = sellerPw;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.postNo = postNo;
		this.address = address;
		this.addressDetail = addressDetail;
		this.sellerNo = sellerNo;
		this.shopMobile = shopMobile;
		this.shopName = shopName;
		this.shopKakaoId = shopKakaoId;
		this.shopImg = shopImg;
		this.shopCategoryNo = shopCategoryNo;
		this.shopLocCode = shopLocCode;
	}

	/* 전체 데이터 */
	public Seller(String sellerId, String sellerPw, String name, String mobile, String email, String entryDate,
			String postNo, String address, String addressDetail, String grade, String sellerNo, String shopMobile,
			String shopName, double custScore, String shopKakaoId, String shopImg, String shopCategoryNo,
			String shopLocCode) {
		this.sellerId = sellerId;
		this.sellerPw = sellerPw;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.entryDate = entryDate;
		this.postNo = postNo;
		this.address = address;
		this.addressDetail = addressDetail;
		this.grade = grade;
		this.sellerNo = sellerNo;
		this.shopMobile = shopMobile;
		this.shopName = shopName;
		this.custScore = custScore;
		this.shopKakaoId = shopKakaoId;
		this.shopImg = shopImg;
		this.shopCategoryNo = shopCategoryNo;
		this.shopLocCode = shopLocCode;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerPw() {
		return sellerPw;
	}

	public void setSellerPw(String sellerPw) {
		this.sellerPw = sellerPw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getPostNo() {
		return postNo;
	}

	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSellerNo() {
		return sellerNo;
	}

	public void setSellerNo(String sellerNo) {
		this.sellerNo = sellerNo;
	}

	public String getShopMobile() {
		return shopMobile;
	}

	public void setShopMobile(String shopMobile) {
		this.shopMobile = shopMobile;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public double getCustScore() {
		return custScore;
	}

	public void setCustScore(double custScore) {
		this.custScore = custScore;
	}

	public String getShopKakaoId() {
		return shopKakaoId;
	}

	public void setShopKakaoId(String shopKakaoId) {
		this.shopKakaoId = shopKakaoId;
	}

	public String getShopImg() {
		return shopImg;
	}

	public void setShopImg(String shopImg) {
		this.shopImg = shopImg;
	}

	public String getShopCategoryNo() {
		return shopCategoryNo;
	}

	public void setShopCategoryNo(String shopCategoryNo) {
		this.shopCategoryNo = shopCategoryNo;
	}

	public String getShopLocCode() {
		return shopLocCode;
	}

	public void setShopLocCode(String shopLocCode) {
		this.shopLocCode = shopLocCode;
	}

	
	
	public String getShopCategoryName() {
		return shopCategoryName;
	}

	public void setShopCategoryName(String shopCategoryName) {
		this.shopCategoryName = shopCategoryName;
	}

	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", sellerPw=" + sellerPw + ", name=" + name + ", mobile=" + mobile
				+ ", email=" + email + ", entryDate=" + entryDate + ", postNo=" + postNo + ", address=" + address
				+ ", addressDetail=" + addressDetail + ", grade=" + grade + ", sellerNo=" + sellerNo + ", shopMobile="
				+ shopMobile + ", shopName=" + shopName + ", custScore=" + custScore + ", shopKakaoId=" + shopKakaoId
				+ ", shopImg=" + shopImg + ", shopCategoryNo=" + shopCategoryNo + ", shopCategoryName="
				+ ", shopLocCode=" + shopLocCode + "]";
	}

	
	
}

