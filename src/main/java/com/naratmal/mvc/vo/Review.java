package com.naratmal.mvc.vo;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Review {
	private Long reviewId;
	private Long goodsId;
	private String userId;
	private Long orderLineId;
	private String reviewContent;
	private int reviewRate;
	private String reviewPicture;
	private Long reviewStateId;
	private LocalDateTime reviewInsertDate;
	private LocalDateTime reviewUpdateDate;
	
	private Goods goods;
	private Users users;
	private ReviewState reviewState;
	private OrderLine orderLine;
}
