package com.naratmal.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import com.naratmal.mvc.vo.Orders;

public interface OrderDao {
	/**
	 * 주문 등록
	 * @param: Orders orders(사용자 아이디, 총 금액, 배송 메모)
	 * @return: int(등록된 레코드 수)
	 * */
	int insertOrder(Orders orders) throws SQLException;

	/**
	 * 주문 수정
	 * @param: Orders orders(주문 아이디, 주문 상태 아이디, 총 금액)
	 * @return: int(수정된 레코드 수)
	 * */
	int updateOrder(Orders orders) throws SQLException;

	/**
	 * 주문 검색
	 * @param: Orders orders(사용자 아이디, 유저 아이디, 주문 상태 아이디 중 입력된 컬럼)
	 * @return: List<Orders>
	 * */
	List<Orders> findOrder(Orders orders) throws SQLException;
}
