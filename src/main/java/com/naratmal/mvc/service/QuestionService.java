package com.naratmal.mvc.service;

import java.sql.SQLException;
import java.util.List;

import com.naratmal.mvc.exception.NotDBInputException;
import com.naratmal.mvc.exception.NotExistException;
import com.naratmal.mvc.exception.NotLoginException;
import com.naratmal.mvc.vo.Question;

public interface QuestionService {
	/**
	 * 질문 등록
	 * @param: Question question(질문 카테고리 아이디, 유저 아이디, 질문 제목, 질문 내용, 질문 사진)
	 * @return: int(등록된 레코드 수)
	 * */
	int insertQuestion(Question question) throws SQLException, NotDBInputException, NotExistException, NotLoginException;

	/**
	 * 질문 수정
	 * @param: Question question(질문 카테고리 아이디, 질문 제목, 질문 내용, 질문 사진, 답변 현황 중 입력된 컬럼 수정)
	 * @return: int(수정된 레코드 수)
	 * */
	int updateQuestion(Question question) throws SQLException, NotExistException, NotLoginException;

	/**
	 * 질문 삭제
	 * @param: Long questionId
	 * @return: int(삭제된 레코드 수)
	 * */
	int deleteQuestion(Long questionId) throws SQLException, NotExistException, NotLoginException;
	
	/**
	 * 질문 검색
	 * @param: Question question(질문 카테고리 아이디, 유저 아이디, 질문 아이디, 답변 현황 중 입력된 컬럼으로 검색)
	 * */
	List<Question> findQuestion(Question question) throws SQLException, NotLoginException;
}
