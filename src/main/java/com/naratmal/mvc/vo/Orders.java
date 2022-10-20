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
	
	@Builder
	public Orders(Long orderId, String userId, Long orderStateId, int totalPrice, String orderMemo,
			LocalDateTime orderInsertDate, LocalDateTime orderUpdateDate, List<OrderLine> orderLines, Users users,
			OrderState orderState) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.orderStateId = orderStateId;
		this.totalPrice = totalPrice;
		this.orderMemo = orderMemo;
		this.orderInsertDate = orderInsertDate;
		this.orderUpdateDate = orderUpdateDate;
		this.orderLines = orderLines;
		this.users = users;
		this.orderState = orderState;
	}
}
