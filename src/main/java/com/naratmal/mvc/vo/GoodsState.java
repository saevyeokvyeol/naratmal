package com.naratmal.mvc.vo;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GoodsState {
	private Long goodsStateId;
	private String goodsStateName;
	
	private List<Goods> goodsList;
}
