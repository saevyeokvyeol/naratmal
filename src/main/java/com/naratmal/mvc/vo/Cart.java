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
public class Cart {
	private Long cartId;
	private int cartQty;
	private String userId;
	private Long goodsId;
	private LocalDateTime cartInsertDate;
	private LocalDateTime cartUpdateDate;
	
	private Users users;
	private Goods goods;

	@Builder
	public Cart(Long cartId, int cartQty, String userId, Long goodsId, LocalDateTime cartInsertDate,
			LocalDateTime cartUpdateDate, Users users, Goods goods) {
		super();
		this.cartId = cartId;
		this.cartQty = cartQty;
		this.userId = userId;
		this.goodsId = goodsId;
		this.cartInsertDate = cartInsertDate;
		this.cartUpdateDate = cartUpdateDate;
		this.users = users;
		this.goods = goods;
	}
}
