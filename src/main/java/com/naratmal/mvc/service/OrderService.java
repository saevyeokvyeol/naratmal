package com.naratmal.mvc.service;

import java.sql.SQLException;
import java.util.List;

import com.naratmal.mvc.exception.NotDBInputException;
import com.naratmal.mvc.exception.NotExistException;
import com.naratmal.mvc.vo.Orders;

public interface OrderService {
	/**
	 * 주문 등록
	 * @param: Orders orders(사용자 아이디, 총 금액, 배송 메모)
	 * */
	void insertOrder(Orders orders) throws SQLException, NotExistException, NotDBInputException;

	/**
	 * 주문 수정
	 * @param: Orders orders(주문 아이디, 주문 상태 아이디, 총 금액)
	 * */
	void updateOrder(Orders orders) throws SQLException, NotExistException;

	/**
	 * 주문 검색
	 * @param: Orders orders(사용자 아이디, 유저 아이디, 주문 상태 아이디 중 입력된 컬럼)
	 * @return: List<Orders>
	 * */
	List<Orders> findOrder(Orders orders) throws SQLException;
}
