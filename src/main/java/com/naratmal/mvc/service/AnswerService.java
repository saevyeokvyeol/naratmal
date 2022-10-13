package com.naratmal.mvc.service;

import java.sql.SQLException;
import java.util.List;

import com.naratmal.mvc.exception.NotDBInputException;
import com.naratmal.mvc.exception.NotExistException;
import com.naratmal.mvc.exception.NotLoginException;
import com.naratmal.mvc.vo.Answer;

public interface AnswerService {
	/**
	 * 답변 등록
	 * @param: Answer answer(질문 아이디, 답변 내용, 답변 사진)
	 * */
	void insertAnswer(Answer answer) throws SQLException, NotDBInputException, NotExistException, NotLoginException;

	/**
	 * 답변 수정
	 * @param: Answer answer(질문 아이디, 답변 내용, 답변 사진 중 입력된 컬럼 수정)
	 * */
	void updateAnswer(Answer answer) throws SQLException, NotExistException, NotLoginException;
	
	/**
	 * 답변 검색
	 * @param: Long answerId(null일 경우 전체 검색, null이 아닐 경우 해당 아이디 검색)
	 * @return: List<Answer>
	 * */
	List<Answer> findAnswer(Long answerId) throws SQLException, NotLoginException;
}
