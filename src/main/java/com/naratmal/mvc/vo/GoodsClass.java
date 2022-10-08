package com.naratmal.mvc.vo;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GoodsClass {
	private Long goodsClassId;
	private String goodsClassName;
	
	private List<Goods> goodsList;
}
