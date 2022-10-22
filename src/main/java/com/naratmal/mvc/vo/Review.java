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
	
	@Builder
	public Review(Long reviewId, Long goodsId, String userId, Long orderLineId, String reviewContent, int reviewRate,
			String reviewPicture, Long reviewStateId, LocalDateTime reviewInsertDate, LocalDateTime reviewUpdateDate,
			Goods goods, Users users, ReviewState reviewState, OrderLine orderLine) {
		super();
		this.reviewId = reviewId;
		this.goodsId = goodsId;
		this.userId = userId;
		this.orderLineId = orderLineId;
		this.reviewContent = reviewContent;
		this.reviewRate = reviewRate;
		this.reviewPicture = reviewPicture;
		this.reviewStateId = reviewStateId;
		this.reviewInsertDate = reviewInsertDate;
		this.reviewUpdateDate = reviewUpdateDate;
		this.goods = goods;
		this.users = users;
		this.reviewState = reviewState;
		this.orderLine = orderLine;
	}
}
