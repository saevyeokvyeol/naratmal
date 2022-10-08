package com.naratmal.mvc.vo;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewState {
	private Long reviewStateId;
	private String reviewStateName;
	
	private List<Review> reviews;
}
