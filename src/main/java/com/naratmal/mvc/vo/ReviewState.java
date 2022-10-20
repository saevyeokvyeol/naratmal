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
public class ReviewState {
	private Long reviewStateId;
	private String reviewStateName;
	
	private List<Review> reviews;

	@Builder
	public ReviewState(Long reviewStateId, String reviewStateName, List<Review> reviews) {
		super();
		this.reviewStateId = reviewStateId;
		this.reviewStateName = reviewStateName;
		this.reviews = reviews;
	}
	
	
}
