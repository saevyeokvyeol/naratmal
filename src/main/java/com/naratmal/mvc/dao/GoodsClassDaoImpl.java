package com.naratmal.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.naratmal.mvc.vo.GoodsClass;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GoodsClassDaoImpl implements GoodsClassDao {
	private final SqlSession sqlSession;
	
	/**
	 * 상품 클래스 등록
	 * @param: String goodsClassName
	 * @return: int(등록 성공한 레코드 수)
	 * */
	@Override
	public int insertGoodsClass(String goodsClassName) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 상품 클래스 수정
	 * @param: GoodsClass goodsClass
	 * @return: int(수정 성공한 레코드 수)
	 * */
	@Override
	public int updateGoodsClass(GoodsClass goodsClass) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 상품 클래스 삭제
	 * @param: Long goodsClassId
	 * @return: int(삭제 성공한 레코드 수)
	 * */
	@Override
	public int deleteGoodsClass(Long goodsClassId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 상품 클래스 검색
	 * @return: List<GoodsClass>
	 * */
	@Override
	public List<GoodsClass> findAllGoodsClass() throws SQLException {
		return sqlSession.selectList("goodsMapper.findAllGoodsClass");
	}

	/**
	 * 상품 클래스 아이디로 상품 클래스 검색
	 * @param: Long goodsClassId
	 * @return: GoodsClass
	 * */
	@Override
	public GoodsClass findGoodsClass(Long goodsClassId) throws SQLException {
		return sqlSession.selectOne("goodsMapper.findGoodsClass", goodsClassId);
	}

}
