package com.naratmal.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import com.naratmal.mvc.vo.Answer;

public interface AnswerDao {
	/**
	 * 답변 등록
	 * @param: Answer answer(질문 아이디, 답변 내용, 답변 사진)
	 * @return: int(등록된 레코드 수)
	 * */
	int insertAnswer(Answer answer) throws SQLException;

	/**
	 * 답변 수정
	 * @param: Answer answer(질문 아이디, 답변 내용, 답변 사진 중 입력된 컬럼 수정)
	 * @return: int(수정된 레코드 수)
	 * */
	int updateAnswer(Answer answer) throws SQLException;
	
	/**
	 * 답변 검색
	 * @param: Long answerId(null일 경우 전체 검색, null이 아닐 경우 해당 아이디 검색)
	 * @return: List<Answer>
	 * */
	List<Answer> findAnswer(Long answerId) throws SQLException;
}
