package com.naratmal.mvc.vo;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderState {
	private Long orderStateId;
	private String orderStateName;

	private List<Orders> orderList;
}
