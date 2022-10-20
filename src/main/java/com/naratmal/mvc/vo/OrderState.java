package com.naratmal.mvc.vo;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderState {
	private Long orderStateId;
	private String orderStateName;

	private List<Orders> orderList;

	@Builder
	public OrderState(Long orderStateId, String orderStateName, List<Orders> orderList) {
		super();
		this.orderStateId = orderStateId;
		this.orderStateName = orderStateName;
		this.orderList = orderList;
	}
}
