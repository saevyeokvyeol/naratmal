package com.naratmal.mvc.vo;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Answer {
	private Long answerId;
	private Long questionId;
	private String answerContent;
	private String answerPicture;
	private LocalDateTime answerInsertDate;
	private LocalDateTime answerUpdateDate;
	
	private Question question;
}
