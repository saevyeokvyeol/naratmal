package com.naratmal.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.naratmal.mvc.vo.Goods;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GoodsDaoImpl implements GoodsDao {
	private final SqlSession sqlSession;
	
	/**
	 * 상품 등록
	 * @param: Goods goods(상품 클래스 아이디, 상품 이름, 상품 소개, 상품 썸네일, 상품 가격)
	 * @return: int(등록 성공한 레코드 수)
	 * */
	@Override
	public int insertGoods(Goods goods) throws SQLException {
		return sqlSession.insert("goodsMapper.insertGoods", goods);
	}

	/**
	 * 상품 수정
	 * @param: Goods goods(상품 아이디, 상품 클래스 아이디, 상품 상태 아이디, 상품 이름, 상품 소개, 상품 썸네일, 상품 가격 중 입력한 컬럼)
	 * @return: int(수정 성공한 레코드 수)
	 * */
	@Override
	public int updateGoods(Goods goods) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 상품 검색
	 * @param: Goods goods(상품 아이디, 상품 클래스 아이디, 상품 이름, 상품 상태 아이디 중 입력한 컬럼)
	 * @return: List<Goods>
	 * */
	@Override
	public List<Goods> findGoods(Goods goods) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
