package com.naratmal.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import com.naratmal.mvc.vo.Cart;

public interface CartDao {
	/**
	 * 장바구니 추가
	 * @param: Cart
	 * @return: int(DB에 추가된 레코드 수)
	 * */
	int insertCart(Cart cart) throws SQLException;

	/**
	 * 장바구니 수정
	 * @param: Cart(cartId와 cartQty를 받아 해당 장바구니의 수량을 변경)
	 * @return: int(DB에서 수정된 레코드 수)
	 * */
	int updateCart(Cart cart) throws SQLException;

	/**
	 * 장바구니 삭제
	 * @param: Cart(cartId 혹은 userId를 받아 해당 장바구니나 회원의 장바구니 목록을 삭제)
	 * @return: int(DB에서 삭제된 레코드 수)
	 * */
	int deleteCart(Cart cart) throws SQLException;

	/**
	 * 장바구니 검색
	 * @param: Cart(cartId, userId, goodsId 중 하나를 받아 특정 장바구니, 회원의 장바구니, 특정 상품의 장바구니 목록을 검색)
	 * @return: int(DB에 추가된 레코드 수)
	 * */
	List<Cart> findCart(Cart cart) throws SQLException;
}