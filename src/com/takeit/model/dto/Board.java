/**
 * 
 */
package com.takeit.model.dto;

import java.io.Serializable;

/**
 * @author 한소희
 */
public class Board implements Serializable{
	private String boardNo;
	private String boardWriter;
	private String boardTitle;
	private String boardContents;
	private int boardViews;
	private int boardPicks;
	private String boardDate;
	private String boardCategory;
	private String boardCategoryName;
	private String boardItem;
	private String boardItemSeller;
	
	public Board() {}
	/***
	 * 공지사항,자주하는 질문 사용자(관리자) 입력데이터
	 * @param boardWriter
	 * @param boardTitle
	 * @param boardContents
	 * @param boardCategory
	 */
	public Board(String boardWriter, String boardTitle, String boardContents, String boardCategory) {
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.boardContents = boardContents;
		this.boardCategory = boardCategory;
	}
	
	
	/***
	 * 상품문의 사용자 입력데이터
	 * @param boardWriter
	 * @param boardTitle
	 * @param boardContents
	 * @param boardCategory
	 * @param boardItem
	 */
	public Board(String boardWriter, String boardTitle, String boardContents, String boardCategory, String boardItem) {
		this(boardWriter, boardTitle, boardContents, boardCategory);
		this.boardItem = boardItem;
	}
	
	public Board(String boardWriter, String boardTitle, String boardContents, String boardCategory, String boardItem, String boardCategoryName) {
		this(boardWriter, boardTitle, boardContents, boardCategory, boardItem);
		this.boardCategoryName = boardCategoryName;
	}
	
	/***
	 * 전체입력데이터
	 * @param boardNo
	 * @param boardWriter
	 * @param boardTitle
	 * @param boardContents
	 * @param boardViews
	 * @param boardPicks
	 * @param boardDate
	 * @param boardCategory
	 * @param boardItem
	 * @param boardItemSeller
	 */
	public Board(String boardNo, String boardWriter, String boardTitle, String boardContents, int boardViews,
			int boardPicks, String boardDate, String boardCategory, String boardItem, String boardItemSeller) {
		this(boardWriter, boardTitle, boardContents, boardCategory, boardItem);
		this.boardViews = boardViews;
		this.boardPicks = boardPicks;
		this.boardDate = boardDate;
		this.boardItemSeller = boardItemSeller;
	}

	public String getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContents() {
		return boardContents;
	}

	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}

	public int getBoardViews() {
		return boardViews;
	}

	public void setBoardViews(int boardViews) {
		this.boardViews = boardViews;
	}

	public int getBoardPicks() {
		return boardPicks;
	}

	public void setBoardPicks(int boardPicks) {
		this.boardPicks = boardPicks;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	public String getBoardCategory() {
		return boardCategory;
	}

	public void setBoardCategory(String boardCategory) {
		this.boardCategory = boardCategory;
	}

	public String getBoardItem() {
		return boardItem;
	}

	public void setBoardItem(String boardItem) {
		this.boardItem = boardItem;
	}

	public String getBoardItemSeller() {
		return boardItemSeller;
	}

	public void setBoardItemSeller(String boardItemSeller) {
		this.boardItemSeller = boardItemSeller;
	}

	
	public String getBoardCategoryName() {
		return boardCategoryName;
	}
	public void setBoardCategoryName(String boardCategoryName) {
		this.boardCategoryName = boardCategoryName;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(boardNo);
		builder.append(", ");
		builder.append(boardWriter);
		builder.append(", ");
		builder.append(boardTitle);
		builder.append(", ");
		builder.append(boardContents);
		builder.append(", ");
		builder.append(boardViews);
		builder.append(", ");
		builder.append(boardPicks);
		builder.append(", ");
		builder.append(boardDate);
		builder.append(", ");
		builder.append(boardCategory);
		builder.append(", ");
		builder.append(boardItem);
		builder.append(", ");
		builder.append(boardItemSeller);
		return builder.toString();
	}

	
	
	
	
}

