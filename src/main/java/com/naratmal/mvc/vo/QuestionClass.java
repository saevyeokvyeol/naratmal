package com.naratmal.mvc.vo;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QuestionClass {
	private Long questionClassId;
	private String questionClassName;
	private String questionClassUsable;
	
	private List<Question> questions;

	@Builder
	public QuestionClass(Long questionClassId, String questionClassName, String questionClassUsable,
			List<Question> questions) {
		super();
		this.questionClassId = questionClassId;
		this.questionClassName = questionClassName;
		this.questionClassUsable = questionClassUsable;
		this.questions = questions;
	}	
}
