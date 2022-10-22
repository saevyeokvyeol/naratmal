package com.naratmal.mvc.vo;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.catalina.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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
	
	private Users users;
	private QuestionClass questionClass;
	
	@Builder
	public Question(Long questionId, Long questionClassId, String userId, String questionTitle, String questionContent,
			String questionPicture, LocalDateTime questionInsertDate, LocalDateTime questionUpdateDate,
			String answeredState, String questionDeleted, List<Answer> answers, Users users,
			QuestionClass questionClass) {
		super();
		this.questionId = questionId;
		this.questionClassId = questionClassId;
		this.userId = userId;
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
		this.questionPicture = questionPicture;
		this.questionInsertDate = questionInsertDate;
		this.questionUpdateDate = questionUpdateDate;
		this.answeredState = answeredState;
		this.questionDeleted = questionDeleted;
		this.answers = answers;
		this.users = users;
		this.questionClass = questionClass;
	}
}
