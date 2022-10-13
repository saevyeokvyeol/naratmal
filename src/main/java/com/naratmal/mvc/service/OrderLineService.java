package com.naratmal.mvc.service;

import java.sql.SQLException;
import java.util.List;

import com.naratmal.mvc.exception.NotDBInputException;
import com.naratmal.mvc.exception.NotExistException;
import com.naratmal.mvc.vo.OrderLine;

public interface OrderLineService {
	/**
	 * 주문 상세 등록
	 * @param: OrderLine orderLine(주문 아이디, 상품 아이디, 갯수, 갯수*가격)
	 * */
	void insertOrderLine(OrderLine orderLine) throws SQLException, NotDBInputException, NotExistException;

	/**
	 * 주문 상세 수정
	 * @param: OrderLine orderLine(주문 상세 아이디, 갯수, 갯수*가격, 취소 여부 중 입력된 컬럼 수정)
	 * */
	void updateOrderLine(OrderLine orderLine) throws SQLException, NotExistException;

	/**
	 * 주문 상세 검색
	 * @param: OrderLine orderLine(주문 상세 아이디, 주문 아이디, 상품 아이디 중 입력된 컬럼으로 검색)
	 * @return: List<OrderLine>
	 * */
	List<OrderLine> findOrderLine(OrderLine orderLine) throws SQLException;
}
