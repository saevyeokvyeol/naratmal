package com.naratmal.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import com.naratmal.mvc.vo.Review;

public interface ReviewDao {
	/**
	 * 리뷰 등록
	 * @param: Review review(상품 아이디, 유저 아이디, 주문 상세 아이디, 리뷰 내용, 별점, 리뷰 사진)
	 * @return: int(등록된 레코드 수)
	 * */
	int insertReview(Review review) throws SQLException;

	/**
	 * 리뷰 수정
	 * @param: Review review(리뷰 아이디, 리뷰 내용, 별점, 리뷰 사진, 리뷰 상태 아이디 중 입력한 컬럼을 수정)
	 * @return: int(등록된 레코드 수)
	 * */
	int updateReview(Review review) throws SQLException;

	/**
	 * 리뷰 삭제
	 * @param: Long reviewId
	 * @return: int(삭제한 레코드 수)
	 * */
	int deleteReview(Long reviewId) throws SQLException;

	/**
	 * 리뷰 검색
	 * @param: Review review(후기 아이디, 상품 아이디, 유저 아이디, 주문 상세 아이디 중 입력한 컬럼으로 검색)
	 * @return: List<Review>
	 * */
	List<Review> findReview(Review review) throws SQLException;
}
