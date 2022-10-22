package com.naratmal.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import com.naratmal.mvc.vo.GoodsState;

public interface GoodsStateDao {
	/**
	 * 전체 상품 상태 검색
	 * @return: List<GoodsState>
	 * */
	List<GoodsState> findGoodsState() throws SQLException;
	
	/**
	 * 상품 상태 아이디로 상품 상태 검색
	 * @param: Long goodsStateId
	 * @return: GoodsState
	 * */
	GoodsState findGoodsStateByGoodsStateId(Long goodsStateId) throws SQLException;
}
