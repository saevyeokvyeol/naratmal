package com.naratmal.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import com.naratmal.mvc.vo.Goods;

public interface GoodsDao {
	/**
	 * 상품 등록
	 * @param: Goods goods(상품 클래스 아이디, 상품 이름, 상품 소개, 상품 썸네일, 상품 가격)
	 * @return: int(등록 성공한 레코드 수)
	 * */
	int insertGoods(Goods goods) throws SQLException;

	/**
	 * 상품 수정
	 * @param: Goods goods(상품 아이디 상품 클래스 아이디, 상품 이름, 상품 소개, 상품 썸네일, 상품 가격 중 입력한 컬럼)
	 * @return: int(수정 성공한 레코드 수)
	 * */
	int updateGoods(Goods goods) throws SQLException;

	/**
	 * 상품 삭제
	 * @param: Long goodsId
	 * @return: int(등록 성공한 레코드 수)
	 * */
	int deleteGoods(Long goodsId) throws SQLException;

	/**
	 * 상품 검색
	 * @param: Goods goods(상품 아이디, 상품 클래스 아이디, 상품 이름 중 입력한 컬럼)
	 * @return: int(등록 성공한 레코드 수)
	 * */
	List<Goods> findGoods(Goods goods) throws SQLException;
}