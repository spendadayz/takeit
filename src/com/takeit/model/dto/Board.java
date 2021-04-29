/**
 * 
 */
package com.takeit.model.dto;

import java.io.Serializable;

/**
 * @author 한소희
 *
 */
public class Board implements Serializable{
	private int boardNo;
	private String category;
	private String boardTitle;
	private String boardWriter;
	private String boardDate;
	private int boardViews;
	private int boardPicks;
	private String boardContents;
	
	public Board() {}

	//사용자 입력
	public Board(String category, String boardTitle, String boardWriter, String boardContents) {
		this.category = category;
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter;
		this.boardContents = boardContents;
	}

	public Board(int boardNo, String category, String boardTitle, String boardWriter, String boardDate,
			int boardViews, int boardPicks, String boardContents) {
		this(category, boardTitle, boardWriter, boardContents);
		this.boardNo = boardNo;
		this.boardDate = boardDate;
		this.boardViews = boardViews;
		this.boardPicks = boardPicks;
	}

	/**
	 * @return the boardNo
	 */
	public int getBoardNo() {
		return boardNo;
	}

	/**
	 * @param boardNo the boardNo to set
	 */
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the boardTitle
	 */
	public String getBoardTitle() {
		return boardTitle;
	}

	/**
	 * @param boardTitle the boardTitle to set
	 */
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	/**
	 * @return the boardWriter
	 */
	public String getBoardWriter() {
		return boardWriter;
	}

	/**
	 * @param boardWriter the boardWriter to set
	 */
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	/**
	 * @return the boardDate
	 */
	public String getBoardDate() {
		return boardDate;
	}

	/**
	 * @param boardDate the boardDate to set
	 */
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	/**
	 * @return the boardViewCount
	 */
	public int getBoardViews() {
		return boardViews;
	}

	/**
	 * @param boardViewCount the boardViewCount to set
	 */
	public void setBoardViews(int boardViews) {
		this.boardViews = boardViews;
	}

	
	public int getBoardPicks() {
		return boardPicks;
	}

	public void setBoardPicks(int boardPicks) {
		this.boardPicks = boardPicks;
	}

	/**
	 * @return the boardContents
	 */
	public String getBoardContents() {
		return boardContents;
	}

	/**
	 * @param boardContents the boardContents to set
	 */
	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(boardNo);
		builder.append(", ");
		builder.append(category);
		builder.append(", ");
		builder.append(boardTitle);
		builder.append(", ");
		builder.append(boardWriter);
		builder.append(", ");
		builder.append(boardDate);
		builder.append(", ");
		builder.append(boardViews);
		builder.append(", ");
		builder.append(boardPicks);
		builder.append(", ");
		builder.append(boardContents);
		return builder.toString();
	}
	
}

