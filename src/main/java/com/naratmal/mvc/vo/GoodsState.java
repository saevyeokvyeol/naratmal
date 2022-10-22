package com.naratmal.mvc.vo;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GoodsState {
	private Long goodsStateId;
	private String goodsStateName;
	
	private List<Goods> goodsList;

	@Builder
	public GoodsState(Long goodsStateId, String goodsStateName, List<Goods> goodsList) {
		super();
		this.goodsStateId = goodsStateId;
		this.goodsStateName = goodsStateName;
		this.goodsList = goodsList;
	}
}
