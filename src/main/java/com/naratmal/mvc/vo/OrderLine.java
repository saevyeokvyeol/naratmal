package com.naratmal.mvc.vo;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
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
}
