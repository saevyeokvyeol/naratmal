package com.naratmal.mvc.vo;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GoodsClass {
	private Long goodsClassId;
	private String goodsClassName;
	
	private List<Goods> goodsList;

	@Builder
	public GoodsClass(Long goodsClassId, String goodsClassName, List<Goods> goodsList) {
		super();
		this.goodsClassId = goodsClassId;
		this.goodsClassName = goodsClassName;
		this.goodsList = goodsList;
	}
}
