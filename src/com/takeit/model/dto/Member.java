package com.takeit.model.dto;

import java.io.Serializable;

/**
 * 회원가입 : 일반회원 도메인
 * @author 임우진
 * 
 */
public class Member implements Serializable{	
	
	/**
	 * @param 멤버변수 
	 * memberId : 아이디
	 * memberPw : 비밀번호
	 * name : 이름
	 * mobile : 이메일
	 * entryDate : 생일
	 * postNo : 우편번호
	 * roadAddrPart1 : 도로명 주소
	 * addrDetail : 상세 주소
	 * point : 적릭금
	 * birth : 생일
	 * grade : 등급
	 * memberLocNo : 회원구역번호
	 * shopLocCode : 상점구역코드
	 */
	private String memberId;
	private String memberPw;
	private String name;
	private String mobile;
	private String email;
	private String entryDate; // TIMESTAMP 형식으로 DB에서 처리할때 TO_CHAR 필요
	private String postNo;
	private String address;
	private String addressDetail;
	private int point;
	private String birth;
	private String grade;
	private String memberLocNo;
	private String shopLocCode;
	
	/* 기본 생성자 */
	public Member() {}



	/* 사용자 입력 데이터 */
	public Member(String memberId, String memberPw, String name, String mobile, String email, String postNo,
			String address, String addressDetail, String birth) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.postNo = postNo;
		this.address = address;
		this.addressDetail = addressDetail;
		this.birth = birth;
	}

	/* 전체 데이터 */
	public Member(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String postNo, String address, String addressDetail, int point, String birth, String grade,
			String memberLocNo, String shopLocCode) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.entryDate = entryDate;
		this.postNo = postNo;
		this.address = address;
		this.addressDetail = addressDetail;
		this.point = point;
		this.birth = birth;
		this.grade = grade;
		this.memberLocNo = memberLocNo;
		this.shopLocCode = shopLocCode;
	}



	public String getMemberId() {
		return memberId;
	}



	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}



	public String getMemberPw() {
		return memberPw;
	}



	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
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



	public int getPoint() {
		return point;
	}



	public void setPoint(int point) {
		this.point = point;
	}



	public String getBirth() {
		return birth;
	}



	public void setBirth(String birth) {
		this.birth = birth;
	}



	public String getGrade() {
		return grade;
	}



	public void setGrade(String grade) {
		this.grade = grade;
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
		return "Member [memberId=" + memberId + ", memberPw=" + memberPw + ", name=" + name + ", mobile=" + mobile
				+ ", email=" + email + ", entryDate=" + entryDate + ", postNo=" + postNo + ", address=" + address
				+ ", addressDetail=" + addressDetail + ", point=" + point + ", birth=" + birth + ", grade=" + grade
				+ ", memberLocNo=" + memberLocNo + ", shopLocCode=" + shopLocCode + "]";
	}

	
}
