package com.naratmal.mvc.vo;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Answer {
	private Long answerId;
	private Long questionId;
	private String answerContent;
	private String answerPicture;
	private LocalDateTime answerInsertDate;
	private LocalDateTime answerUpdateDate;
	
	private Question question;

	@Builder
	public Answer(Long answerId, Long questionId, String answerContent, String answerPicture,
			LocalDateTime answerInsertDate, LocalDateTime answerUpdateDate, Question question) {
		super();
		this.answerId = answerId;
		this.questionId = questionId;
		this.answerContent = answerContent;
		this.answerPicture = answerPicture;
		this.answerInsertDate = answerInsertDate;
		this.answerUpdateDate = answerUpdateDate;
		this.question = question;
	}
}
