package com.naratmal.mvc.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naratmal.mvc.dao.CartDao;
import com.naratmal.mvc.exception.DuplicatedException;
import com.naratmal.mvc.exception.NotExistException;
import com.naratmal.mvc.exception.NotLoginException;
import com.naratmal.mvc.vo.Cart;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
	private final CartDao cartDao;

	/**
	 * 장바구니 추가
	 * @param: Cart
	 * */
	@Override
	public void insertCart(Cart cart) throws SQLException, NotLoginException, NotExistException, DuplicatedException {
		int result = cartDao.insertCart(cart);
		if (result != 1) throw new SQLException("장바구니 추가에 실패했습니다.");
	}

	/**
	 * 장바구니 수정
	 * @param: Cart(cartId와 cartQty를 받아 해당 장바구니의 수량을 변경)
	 * */
	@Override
	public void updateCart(Cart cart) throws SQLException, NotLoginException, NotExistException {
		// TODO Auto-generated method stub

	}

	/**
	 * 장바구니 삭제
	 * @param: Cart(cartId 혹은 userId를 받아 해당 장바구니나 회원의 장바구니 목록을 삭제)
	 * */
	@Override
	public void deleteCart(Cart cart) throws SQLException, NotLoginException, NotExistException {
		// TODO Auto-generated method stub

	}

	/**
	 * 장바구니 검색
	 * @param: Cart(cartId, userId, goodsId 중 하나를 받아 특정 장바구니, 회원의 장바구니, 특정 상품의 장바구니 목록을 검색)
	 * @return: int(DB에 추가된 레코드 수)
	 * */
	@Override
	public List<Cart> findCart(Cart cart) throws SQLException, NotLoginException {
		// TODO Auto-generated method stub
		return null;
	}

}
