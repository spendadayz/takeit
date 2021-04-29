/**
 * 
 */
package com.takeit.model.dto;

/**
 * @author 한소희
 *
 */
public class Category {
	private String categoryNo;
	private String categoryName;
	
	public Category() {}

	public Category(String categoryNo, String categoryName) {
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
	}


	/**
	 * @return the categoryNo
	 */
	public String getCategoryNo() {
		return categoryNo;
	}

	/**
	 * @param categoryNo the categoryNo to set
	 */
	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(categoryNo);
		builder.append(", ");
		builder.append(categoryName);
		return builder.toString();
	}
	
	
}
