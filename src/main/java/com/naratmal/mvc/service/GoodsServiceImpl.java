package com.naratmal.mvc.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naratmal.mvc.dao.GoodsClassDao;
import com.naratmal.mvc.dao.GoodsDao;
import com.naratmal.mvc.exception.NotDBInputException;
import com.naratmal.mvc.exception.NotExistException;
import com.naratmal.mvc.vo.Goods;
import com.naratmal.mvc.vo.GoodsClass;
import com.naratmal.mvc.vo.Paging;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class GoodsServiceImpl implements GoodsService {
	private final GoodsDao goodsDao;
	private final GoodsClassDao goodsClassDao;
	
	/**
	 * 상품 등록
	 * @param: Goods goods(상품 클래스 아이디, 상품 이름, 상품 소개, 상품 썸네일, 상품 가격)
	 * */
	@Override
	public void insertGoods(Goods goods) throws SQLException, NotExistException, NotDBInputException {
		GoodsClass goodsClass = goodsClassDao.findGoodsClass(goods.getGoodsClassId());
		if (goodsClass == null) throw new NotExistException("상품 클래스 코드가 잘못되어 상품이 등록되지 않았습니다.");
		
		int result = goodsDao.insertGoods(goods);
		if (result != 1) throw new NotDBInputException("상품이 정상적으로 등록되지 않았습니다.");
	}

	/**
	 * 상품 수정
	 * @param: Goods goods(상품 아이디, 상품 클래스 아이디, 상품 상태 아이디, 상품 이름, 상품 소개, 상품 썸네일, 상품 가격 중 입력한 컬럼)
	 * */
	@Override
	public void updateGoods(Goods goods) throws SQLException, NotExistException, NotDBInputException {
		if (goods.getGoodsClassId() != 0) {
			GoodsClass goodsClass = goodsClassDao.findGoodsClass(goods.getGoodsClassId());
			if (goodsClass == null) throw new NotExistException("상품 클래스 코드가 잘못되어 상품이 수정되지 않았습니다.");
		}
		
		int result = goodsDao.updateGoods(goods);
		if (result != 1) throw new NotDBInputException("상품이 정상적으로 수정되지 않았습니다.");
	}

	/**
	 * 상품 검색
	 * @param: Goods goods(상품 아이디, 상품 클래스 아이디, 상품 이름 중 입력한 컬럼)
	 * @return: List<Goods>
	 * */
	@Override
	public List<Goods> findGoods(Goods goods, Paging pageCnt) throws SQLException {
		return goodsDao.findGoods(goods, pageCnt);
	}

	/**
	 * 상품 아이디로 상품 검색
	 * @param: Long goodsId
	 * @return: Goods
	 * @throws NotExistException 
	 * */
	public Goods findGoodsByGoodsId(Long goodsId) throws SQLException, NotExistException {
		Goods goods = goodsDao.findGoodsByGoodsId(goodsId);
		if (goods == null) throw new NotExistException("상품 아이디에 해당하는 상품이 존재하지 않습니다.");
		
		return goods;
	}

}
