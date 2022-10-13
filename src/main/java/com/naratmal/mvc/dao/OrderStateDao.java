package com.naratmal.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import com.naratmal.mvc.vo.OrderState;

public interface OrderStateDao {
	/**
	 * 상품 상태 검색
	 * @param: Long orderStateId(null이면 전체 검색, null이 아니면 해당 아이디 검색)
	 * @return: List<OrderState>
	 * */
	List<OrderState> findOrderState(Long orderStateId) throws SQLException;
}
