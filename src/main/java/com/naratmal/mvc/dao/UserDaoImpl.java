package com.naratmal.mvc.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.naratmal.mvc.vo.Paging;
import com.naratmal.mvc.vo.Users;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {
	private final SqlSession sqlSession;

	/**
	 * 회원 가입
	 * @param: Users(userId, userName, userPassword, userTel, zipcode, addr, addrDetail)
	 * @return: int(insert 결과)
	 * */
	@Override
	public int insertUser(Users users) throws SQLException {
		return sqlSession.insert("userMapper.insertUser", users);
	}

	/**
	 * 로그인
	 * @param: Users(userId, UserPassword)
	 * @return: Users
	 * */
	@Override
	public Users login(Users users) throws SQLException {
		return sqlSession.selectOne("userMapper.login", users);
	}

	/**
	 * 아이디 찾기
	 * @param: String userId
	 * @return: Users
	 * */
	@Override
	public Users findById(String userId) throws SQLException {
		return sqlSession.selectOne("userMapper.findById", userId);
	}

	/**
	 * 회원 정보 수정
	 * @param: Users(userTel, zipcode, addr, addrDetail 중 입력된 값에 따라 동적으로 회원 정보 수정)
	 * @return: int(update 결과)
	 * */
	@Override
	public int updateUser(Users users) throws SQLException {
		return sqlSession.update("userMapper.updateUser", users);
	}

	/**
	 * 회원 검색
	 * @param: Users(userId, userName, userTel, userBirth, addr 중 입력된 값에 따라 동적으로 검색)
	 * 		   Page(null이냐 아니냐에 따라서 동적으로 페이징 처리)
	 * @return: List<Users>
	 * */
	@Override
	public List<Users> findUsers(Users users, Paging pageCnt) throws SQLException {
		Paging.totalCount = this.getTotalCount(users);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("users", users);
		
		int start = (pageCnt.getPageNum() - 1) * pageCnt.pageSize + 1;
		int end = pageCnt.getPageNum() * pageCnt.pageSize;
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("userMapper.findUsers", map);
	}
	
	/**
	 * 페이징 처리를 위한 전체 레코드 수 가져오기
	 * @param: Users(userId, userName, userTel, userBirth, addr 중 입력된 값에 따라 동적으로 검색)
	 * @return: int(페이지 수)
	 * */
	private int getTotalCount(Users users) throws SQLException {
		return sqlSession.selectOne("userMapper.getTotalCount");
	}
}
