package com.naratmal.mvc.vo;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Orders {
	private Long orderId;
	private String userId;
	private Long orderStateId;
	private int totalPrice;
	private String orderMemo;
	private LocalDateTime orderInsertDate;
	private LocalDateTime orderUpdateDate;
	
	private List<OrderLine> orderLines;
	
	private Users users;
	private OrderState orderState;
}
