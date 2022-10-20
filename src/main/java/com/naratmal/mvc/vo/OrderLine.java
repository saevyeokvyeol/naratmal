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
public class OrderLine {
	private Long orderLineId;
	private Long orderId;
	private Long goodsId;
	private int orderLineQty;
	private int priceQty;
	private String orderLineCanceled;
	private LocalDateTime orderLineInsertDate;
	private LocalDateTime orderLineUpdateDate;
	
	private Orders orders;
	private Goods goods;
	private Review review;
	
	@Builder
	public OrderLine(Long orderLineId, Long orderId, Long goodsId, int orderLineQty, int priceQty,
			String orderLineCanceled, LocalDateTime orderLineInsertDate, LocalDateTime orderLineUpdateDate,
			Orders orders, Goods goods, Review review) {
		super();
		this.orderLineId = orderLineId;
		this.orderId = orderId;
		this.goodsId = goodsId;
		this.orderLineQty = orderLineQty;
		this.priceQty = priceQty;
		this.orderLineCanceled = orderLineCanceled;
		this.orderLineInsertDate = orderLineInsertDate;
		this.orderLineUpdateDate = orderLineUpdateDate;
		this.orders = orders;
		this.goods = goods;
		this.review = review;
	}
}
