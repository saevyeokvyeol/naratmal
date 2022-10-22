package com.naratmal.mvc.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.naratmal.mvc.dao.GoodsClassDao;
import com.naratmal.mvc.exception.NotDBInputException;
import com.naratmal.mvc.exception.NotExistException;
import com.naratmal.mvc.vo.GoodsClass;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class GoodsClassServiceImpl implements GoodsClassService {
	private final GoodsClassDao goodsClassDao;

	/**
	 * 상품 클래스 등록
	 * @param: String goodsClassName
	 * @return: int(등록 성공한 레코드 수)
	 * */
	@Override
	public int insertGoodsClass(String goodsClassName) throws SQLException, NotDBInputException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 상품 클래스 수정
	 * @param: GoodsClass goodsClass
	 * @return: int(수정 성공한 레코드 수)
	 * */
	@Override
	public int updateGoodsClass(GoodsClass goodsClass) throws SQLException, NotExistException, NotDBInputException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 상품 클래스 삭제
	 * @param: Long goodsClassId
	 * @return: int(삭제 성공한 레코드 수)
	 * */
	@Override
	public int deleteGoodsClass(Long goodsClassId) throws SQLException, NotExistException, NotDBInputException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 상품 클래스 검색
	 * @return: List<GoodsClass>
	 * */
	@Override
	public List<GoodsClass> findAllGoodsClass() throws SQLException {
		return goodsClassDao.findAllGoodsClass();
	}

}
