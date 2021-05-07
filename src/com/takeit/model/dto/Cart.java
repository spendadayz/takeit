package com.takeit.model.dto;

public class Cart {
	private String memberId;
	private String itemNo;
	private String itemName;
	private String itemImg;
	private String sellerId;
	private String sellerName;
	private int cartItemQty;
	private int itemPrice;
	private int totalPrice;
	private int cartTotalPrice; //전체 구매 금액
	
	public Cart() {}

	/**장바구니 등록*/
	public Cart(String memberId, String itemNo, int cartItemQty) {
		this.memberId = memberId;
		this.itemNo = itemNo;
		this.cartItemQty = cartItemQty;
	}

	public Cart(String memberId, String itemNo, String itemImg, int cartItemQty) {
		super();
		this.memberId = memberId;
		this.itemNo = itemNo;
		this.itemImg = itemImg;
		this.cartItemQty = cartItemQty;
	}

	public Cart(String itemName, String sellerName, int cartItemQty, int totalPrice) {
		super();
		this.itemName = itemName;
		this.sellerName = sellerName;
		this.cartItemQty = cartItemQty;
		this.totalPrice = totalPrice;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
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

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public int getCartItemQty() {
		return cartItemQty;
	}

	public void setCartItemQty(int cartItemQty) {
		this.cartItemQty = cartItemQty;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String getItemImg() {
		return itemImg;
	}

	public void setItemImg(String itemImg) {
		this.itemImg = itemImg;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getCartTotalPrice() {
		return cartTotalPrice;
	}

	public void setCartTotalPrice(int cartTotalPrice) {
		this.cartTotalPrice = cartTotalPrice;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(memberId);
		builder.append(", ");
		builder.append(itemNo);
		builder.append(", ");
		builder.append(itemName);
		builder.append(", ");
		builder.append(itemImg);
		builder.append(", ");
		builder.append(sellerId);
		builder.append(", ");
		builder.append(sellerName);
		builder.append(", ");
		builder.append(cartItemQty);
		builder.append(", ");
		builder.append(itemPrice);
		builder.append(", ");
		builder.append(totalPrice);
		builder.append(", ");
		builder.append(cartTotalPrice);
		return builder.toString();
	}

	
	
	
	
	
}
