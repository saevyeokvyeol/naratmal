package com.naratmal.mvc.vo;

import java.sql.Timestamp;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Goods {
	private Long goodsId;
	private Long goodsClassId;
	private Long goodsStateId;
	private String goodsName;
	private String goodsDetail;
	private String goodsThumbnail;
	private int goodsPrice;
	private Timestamp goodsInsertDate;
	private Timestamp goodsUpdateDate;
	
	private List<OrderLine> orderLines;
	private List<Cart> carts;
	private List<Review> reviews;
	
	private GoodsClass goodsClass;
	private GoodsState goodsState;

	@Builder
	public Goods(Long goodsId, Long goodsClassId, Long goodsStateId, String goodsName, String goodsDetail,
			String goodsThumbnail, int goodsPrice, Timestamp goodsInsertDate, Timestamp goodsUpdateDate,
			List<OrderLine> orderLines, List<Cart> carts, List<Review> reviews, GoodsClass goodsClass,
			GoodsState goodsState) {
		super();
		this.goodsId = goodsId;
		this.goodsClassId = goodsClassId;
		this.goodsStateId = goodsStateId;
		this.goodsName = goodsName;
		this.goodsDetail = goodsDetail;
		this.goodsThumbnail = goodsThumbnail;
		this.goodsPrice = goodsPrice;
		this.goodsInsertDate = goodsInsertDate;
		this.goodsUpdateDate = goodsUpdateDate;
		this.orderLines = orderLines;
		this.carts = carts;
		this.reviews = reviews;
		this.goodsClass = goodsClass;
		this.goodsState = goodsState;
	}
}
