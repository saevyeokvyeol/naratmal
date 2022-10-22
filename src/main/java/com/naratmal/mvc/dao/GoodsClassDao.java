package com.naratmal.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import com.naratmal.mvc.vo.GoodsClass;

public interface GoodsClassDao {
	/**
	 * 상품 클래스 등록
	 * @param: String goodsClassName
	 * @return: int(등록 성공한 레코드 수)
	 * */
	int insertGoodsClass(String goodsClassName) throws SQLException;

	/**
	 * 상품 클래스 수정
	 * @param: GoodsClass goodsClass
	 * @return: int(수정 성공한 레코드 수)
	 * */
	int updateGoodsClass(GoodsClass goodsClass) throws SQLException;

	/**
	 * 상품 클래스 삭제
	 * @param: Long goodsClassId
	 * @return: int(삭제 성공한 레코드 수)
	 * */
	int deleteGoodsClass(Long goodsClassId) throws SQLException;

	/**
	 * 상품 클래스 검색
	 * @return: List<GoodsClass>
	 * */
	List<GoodsClass> findAllGoodsClass() throws SQLException;

	/**
	 * 상품 클래스 아이디로 상품 클래스 검색
	 * @param: Long goodsClassId
	 * @return: GoodsClass
	 * */
	GoodsClass findGoodsClass(Long goodsClassId) throws SQLException;
}
