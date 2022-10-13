package com.naratmal.mvc.vo;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.catalina.User;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Question {
	private Long questionId;
	private Long questionClassId;
	private String userId;
	private String questionTitle;
	private String questionContent;
	private String questionPicture;
	private LocalDateTime questionInsertDate;
	private LocalDateTime questionUpdateDate;
	private String answeredState;
	private String questionDeleted;
	
	private List<Answer> answers;
	
	private User user;
	private QuestionClass questionClass;
}
