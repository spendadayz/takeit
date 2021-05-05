package com.takeit.common;

import com.takeit.model.dto.MessageEntity;

/**
 * 사용자 정의 예외클래스
 */
public class CommonException extends Exception {
	private MessageEntity entity;
	
	public CommonException() {}
	
	public CommonException(MessageEntity entity) {
		this.entity = entity;
	}
	
	public MessageEntity getMessageEntity() {
		return entity;
	}
}
