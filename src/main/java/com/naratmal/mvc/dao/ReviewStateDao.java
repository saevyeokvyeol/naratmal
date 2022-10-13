package com.naratmal.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import com.naratmal.mvc.vo.OrderState;
import com.naratmal.mvc.vo.ReviewState;

public interface ReviewStateDao {
	/**
	 * 상품 상태 검색
	 * @param: Long reviewStateId(null이면 전체 검색, null이 아니면 해당 아이디 검색)
	 * @return: List<ReviewState>
	 * */
	List<ReviewState> findReviewState(Long reviewStateId) throws SQLException;
}
