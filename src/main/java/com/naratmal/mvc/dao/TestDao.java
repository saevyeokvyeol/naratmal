package com.naratmal.mvc.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import lombok.NoArgsConstructor;

@Repository
@NoArgsConstructor
public class TestDao {
	@Resource
	private SqlSessionTemplate session;
	
	public String selectName() {
		return session.selectOne("testMapper.selectName");
	}
	
	public static void main(String[] args) {
		TestDao dao = new TestDao();
		System.out.println(dao.selectName());
	}

}
