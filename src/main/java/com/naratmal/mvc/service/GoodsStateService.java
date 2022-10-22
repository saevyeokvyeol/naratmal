package com.naratmal.mvc.service;

import java.sql.SQLException;
import java.util.List;

import com.naratmal.mvc.exception.NotExistException;
import com.naratmal.mvc.vo.GoodsState;

public interface GoodsStateService {
	/**
	 * 상품 상태 검색
	 * @param: Long goodsStateId(null이면 전체 검색, null이 아니면 해당 아이디 검색)
	 * @return: List<GoodsState>
	 * */
	List<GoodsState> findGoodsState(Long goodsStateId) throws SQLException, NotExistException;
}
