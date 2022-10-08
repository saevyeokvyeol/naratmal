package com.naratmal.mvc.vo;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Goods {
	private Long goodsId;
	private Long goodsClassId;
	private Long goodsStateId;
	private String goodsName;
	private String goodsDetail;
	private String goodsThumbnail;
	private int goodsPrice;
	private LocalDateTime goodsInsertDate;
	private LocalDateTime goodsUpdateDate;
	
	private List<OrderLine> orderLines;
	private List<Cart> carts;
	private List<Review> reviews;
	
	private GoodsClass goodsClass;
	private GoodsState goodsState;
}
