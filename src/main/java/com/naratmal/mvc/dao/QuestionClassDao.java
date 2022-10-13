package com.naratmal.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import com.naratmal.mvc.vo.QuestionClass;

public interface QuestionClassDao {
	/**
	 * 질문 클래스 등록
	 * @param: String questionClassName
	 * @return: int(등록 성공한 레코드 수)
	 * */
	int insertQuestionClass(String questionClassName) throws SQLException;

	/**
	 * 질문 클래스 수정
	 * @param: QuestionClass questionClass(클래스 아이디, 클래스 이름)
	 * @return: int(수정 성공한 레코드 수)
	 * */
	int updateQuestionClass(QuestionClass questionClass) throws SQLException;

	/**
	 * 질문 클래스 삭제
	 * @param: Long questionClassId
	 * @return: int(삭제 성공한 레코드 수)
	 * */
	int deleteQuestionClass(Long questionClassId) throws SQLException;

	/**
	 * 질문 클래스 검색
	 * @return: List<QuestionClass>
	 * */
	List<QuestionClass> findAllQuestionClass() throws SQLException;

	/**
	 * 질문 클래스 검색
	 * @param: Long questionClassId
	 * @return: questionClass
	 * */
	QuestionClass findQuestionClass(Long questionClassId) throws SQLException;
}
