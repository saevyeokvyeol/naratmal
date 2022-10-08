package com.naratmal.mvc.vo;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Cart {
	private Long cartId;
	private int cartQty;
	private String userId;
	private Long goodsId;
	private LocalDateTime cartInsertDate;
	private LocalDateTime cartUpdateDate;
	
	private Users users;
	private Goods goods;
}
