package com.takeit.model.dto;

public class Search {
	//상품
	private String packTypeNo;
	private String packTypeName;
	
	private String itemCategoryNo;
	private String itemCategoryName;
	private String expirationDate;
	private String notice;
	private int freshPercent;
	private String itemNo;
	
	private String itemName;
	private int itemPrice;
	private String salesUnit;
	private String itemOrigin;
	private int itemStock;
	private String itemImg;
	private double itemCustScore;
	private String itemInputDate;
	private int discRate;
	private String itemTakeit;
	
	//판매자
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
	
	public Search() {}
	
	
	/**상품검색*/
	public Search(String itemCategoryName, String itemNo, String itemName, double itemCustScore, String sellerId,
			String itemImg, String name) {
		super();
		this.itemCategoryName = itemCategoryName;
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.itemCustScore = itemCustScore;
		this.sellerId = sellerId;
		this.name = name;
		this.itemImg = itemImg;
	}
	
	/**판매자검색*/
	public Search(String itemNo, String itemName, String sellerId, String name, String sellerNo, String shopName,
			double custScore) {
		super();
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.sellerId = sellerId;
		this.name = name;
		this.sellerNo = sellerNo;
		this.shopName = shopName;
		this.custScore = custScore;
	}


	public String getPackTypeNo() {
		return packTypeNo;
	}
	public void setPackTypeNo(String packTypeNo) {
		this.packTypeNo = packTypeNo;
	}
	public String getPackTypeName() {
		return packTypeName;
	}
	public void setPackTypeName(String packTypeName) {
		this.packTypeName = packTypeName;
	}
	public String getItemCategoryNo() {
		return itemCategoryNo;
	}
	public void setItemCategoryNo(String itemCategoryNo) {
		this.itemCategoryNo = itemCategoryNo;
	}
	public String getItemCategoryName() {
		return itemCategoryName;
	}
	public void setItemCategoryName(String itemCategoryName) {
		this.itemCategoryName = itemCategoryName;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public int getFreshPercent() {
		return freshPercent;
	}
	public void setFreshPercent(int freshPercent) {
		this.freshPercent = freshPercent;
	}
	public String getItemNo() {
		return itemNo;
	}
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getSalesUnit() {
		return salesUnit;
	}
	public void setSalesUnit(String salesUnit) {
		this.salesUnit = salesUnit;
	}
	public String getItemOrigin() {
		return itemOrigin;
	}
	public void setItemOrigin(String itemOrigin) {
		this.itemOrigin = itemOrigin;
	}
	public int getItemStock() {
		return itemStock;
	}
	public void setItemStock(int itemStock) {
		this.itemStock = itemStock;
	}
	public String getItemImg() {
		return itemImg;
	}
	public void setItemImg(String itemImg) {
		this.itemImg = itemImg;
	}
	public double getItemCustScore() {
		return itemCustScore;
	}
	public void setItemCustScore(double itemCustScore) {
		this.itemCustScore = itemCustScore;
	}
	public String getItemInputDate() {
		return itemInputDate;
	}
	public void setItemInputDate(String itemInputDate) {
		this.itemInputDate = itemInputDate;
	}
	public int getDiscRate() {
		return discRate;
	}
	public void setDiscRate(int discRate) {
		this.discRate = discRate;
	}
	public String getItemTakeit() {
		return itemTakeit;
	}
	public void setItemTakeit(String itemTakeit) {
		this.itemTakeit = itemTakeit;
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


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(packTypeNo);
		builder.append(", ");
		builder.append(packTypeName);
		builder.append(", ");
		builder.append(itemCategoryNo);
		builder.append(", ");
		builder.append(itemCategoryName);
		builder.append(", ");
		builder.append(expirationDate);
		builder.append(", ");
		builder.append(notice);
		builder.append(", ");
		builder.append(freshPercent);
		builder.append(", ");
		builder.append(itemNo);
		builder.append(", ");
		builder.append(itemName);
		builder.append(", ");
		builder.append(itemPrice);
		builder.append(", ");
		builder.append(salesUnit);
		builder.append(", ");
		builder.append(itemOrigin);
		builder.append(", ");
		builder.append(itemStock);
		builder.append(", ");
		builder.append(itemImg);
		builder.append(", ");
		builder.append(itemCustScore);
		builder.append(", ");
		builder.append(itemInputDate);
		builder.append(", ");
		builder.append(discRate);
		builder.append(", ");
		builder.append(itemTakeit);
		builder.append(", ");
		builder.append(sellerId);
		builder.append(", ");
		builder.append(sellerPw);
		builder.append(", ");
		builder.append(name);
		builder.append(", ");
		builder.append(mobile);
		builder.append(", ");
		builder.append(email);
		builder.append(", ");
		builder.append(entryDate);
		builder.append(", ");
		builder.append(postNo);
		builder.append(", ");
		builder.append(address);
		builder.append(", ");
		builder.append(addressDetail);
		builder.append(", ");
		builder.append(grade);
		builder.append(", ");
		builder.append(sellerNo);
		builder.append(", ");
		builder.append(shopMobile);
		builder.append(", ");
		builder.append(shopName);
		builder.append(", ");
		builder.append(custScore);
		builder.append(", ");
		builder.append(shopKakaoId);
		builder.append(", ");
		builder.append(shopImg);
		builder.append(", ");
		builder.append(shopCategoryNo);
		builder.append(", ");
		builder.append(shopLocCode);
		return builder.toString();
	}
	
	
}
