package com.naratmal.mvc.vo;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QuestionClass {
	private Long questionClassId;
	private String questionClassName;
	private String questionClassUsable;
	
	private List<Question> questions;
}
