/**
 * 
 */
package com.takeit.model.dto;

import java.io.Serializable;

/**
 * @author 김효원
 *
 */
public class Review implements Serializable{

	private String reviewNo;
	private String memberId;

	private String itemNo;
	private String reviewDate;
	private String reviewTitle;
	private String reviewContents;
	private int reviewViews;
	private int reviewScore;
	private String reviewImg;



	public Review() {}
	//후기 필수입력데이터
	public Review(String itemNo,String memberId,String reviewTitle, String reviewContents, int reviewScore,String reviewImg) {


		this.itemNo =itemNo;
		this.memberId = memberId;
		this.reviewTitle = reviewTitle;
		this.reviewContents = reviewContents;
		this.reviewScore = reviewScore;
		this.reviewImg = reviewImg;

	}


	//후기 전체데이터
	public Review(String itemNo,String memberId,String reviewTitle, String reviewContents, int reviewScore,
			String reviewImg,String reviewNo,int reviewViews,String reviewDate) {
		this(itemNo, memberId, reviewTitle, reviewContents, reviewScore,reviewImg);
	
		this.reviewNo = reviewNo;
		this.reviewViews = reviewViews;
		this.reviewDate = reviewDate;


	}
	public String getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(String reviewNo) {
		this.reviewNo = reviewNo;
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
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewContents() {
		return reviewContents;
	}
	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
	}
	public int getReviewViews() {
		return reviewViews;
	}
	public void setReviewViews(int reviewViews) {
		this.reviewViews = reviewViews;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	public String getReviewImg() {
		return reviewImg;
	}
	public void setReviewImg(String reviewImg) {
		this.reviewImg = reviewImg;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(reviewNo);
		builder.append(", ");
		builder.append(memberId);
		builder.append(", ");
		builder.append(itemNo);
		builder.append(", ");
		builder.append(reviewDate);
		builder.append(", ");
		builder.append(reviewTitle);
		builder.append(", ");
		builder.append(reviewContents);
		builder.append(", ");
		builder.append(reviewViews);
		builder.append(", ");
		builder.append(reviewScore);
		builder.append(", ");
		builder.append(reviewImg);
		builder.append("]");
		return builder.toString();
	}




}