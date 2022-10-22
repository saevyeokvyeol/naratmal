package com.naratmal.mvc.service;

import java.sql.SQLException;
import java.util.List;

import com.naratmal.mvc.exception.NotDBInputException;
import com.naratmal.mvc.exception.NotExistException;
import com.naratmal.mvc.vo.Goods;

public interface GoodsService {
	/**
	 * 상품 등록
	 * @param: Goods goods(상품 클래스 아이디, 상품 이름, 상품 소개, 상품 썸네일, 상품 가격)
	 * */
	void insertGoods(Goods goods) throws SQLException, NotExistException, NotDBInputException;

	/**
	 * 상품 수정
	 * @param: Goods goods(상품 아이디, 상품 클래스 아이디, 상품 상태 아이디, 상품 이름, 상품 소개, 상품 썸네일, 상품 가격 중 입력한 컬럼)
	 * */
	void updateGoods(Goods goods) throws SQLException, NotExistException, NotDBInputException;

	/**
	 * 상품 검색
	 * @param: Goods goods(상품 아이디, 상품 클래스 아이디, 상품 이름 중 입력한 컬럼)
	 * @return: List<Goods>
	 * */
	List<Goods> findGoods(Goods goods) throws SQLException;
}
