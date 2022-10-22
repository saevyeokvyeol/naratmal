package com.naratmal.mvc.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.naratmal.mvc.vo.PageCnt;
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
	 * @param: Users(userId, userName, userTel, userBirth, addr, userQuit 중 입력된 값에 따라 동적으로 검색)
	 * 		   Page(null이냐 아니냐에 따라서 동적으로 페이징 처리)
	 * @return: List<Users>
	 * */
	@Override
	public List<Users> findUsers(Users users, PageCnt pageCnt) throws SQLException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("users", users);
		map.put("pageCnt", pageCnt);
		return sqlSession.selectList("userMapper.findUsers", map);
	}

}
