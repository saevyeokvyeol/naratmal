package com.naratmal.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.naratmal.mvc.vo.Cart;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CartDaoImpl implements CartDao {
	private final SqlSession sqlSession;
	
	/**
	 * 장바구니 추가
	 * @param: Cart
	 * @return: int(DB에 추가된 레코드 수)
	 * */
	@Override
	public int insertCart(Cart cart) throws SQLException {
		return sqlSession.insert("cartMapper.insertCart", cart);
	}

	/**
	 * 장바구니 수정
	 * @param: Cart(cartId와 cartQty를 받아 해당 장바구니의 수량을 변경)
	 * @return: int(DB에서 수정된 레코드 수)
	 * */
	@Override
	public int updateCart(Cart cart) throws SQLException {
		return sqlSession.delete("cartMapper.updateCart", cart);
	}

	/**
	 * 장바구니 삭제
	 * @param: Cart(cartId 혹은 userId를 받아 해당 장바구니나 회원의 장바구니 목록을 삭제)
	 * @return: int(DB에서 삭제된 레코드 수)
	 * */
	@Override
	public int deleteCart(Cart cart) throws SQLException {
		return sqlSession.delete("cartMapper.deleteCart", cart); 
	}

	/**
	 * 장바구니 검색
	 * @param: Cart(cartId, userId, goodsId 중 하나를 받아 특정 장바구니, 회원의 장바구니, 특정 상품의 장바구니 목록을 검색)
	 * @return: int(DB에 추가된 레코드 수)
	 * */
	@Override
	public List<Cart> findCart(Cart cart) throws SQLException {
		return sqlSession.selectList("cartMapper.findCart", cart);
	}

}
