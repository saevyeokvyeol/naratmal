package com.naratmal.mvc.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naratmal.mvc.dao.UserDao;
import com.naratmal.mvc.exception.DuplicatedException;
import com.naratmal.mvc.exception.NotDBInputException;
import com.naratmal.mvc.exception.NotExistException;
import com.naratmal.mvc.exception.NotLoginException;
import com.naratmal.mvc.vo.Page;
import com.naratmal.mvc.vo.Users;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserDao userDao;
	
	/**
	 * 회원 가입
	 * @param: Users(userId, userName, userPassword, userTel, zipcode, addr, addrDetail)
	 * @return: int(insert 결과)
	 * */
	@Override
	public void insertUser(Users users) throws SQLException, DuplicatedException, NotDBInputException {
		if (userDao.findById(users.getUserId()) != null) {
			throw new DuplicatedException("아이디가 중복되어 계정을 생성할 수 없습니다.");
		}
		
		int result = userDao.insertUser(users);
		if (result != 1) {
			throw new NotDBInputException("계정 생성에 실패했습니다.");
		}
	}

	/**
	 * 로그인
	 * @param: Users(userId, UserPassword)
	 * @return: Users
	 * */
	@Override
	public Users login(Users users) throws SQLException, NotExistException {
		Users loginUser = userDao.login(users);
		if (loginUser == null) {
			throw new NotExistException("아이디 혹은 비밀번호가 올바르지 않습니다.");
		}
		return loginUser;
	}

	/**
	 * 아이디 찾기
	 * @param: String userId
	 * @return: Users
	 * */
	@Override
	public Users findById(String userId) throws SQLException, NotExistException {
		Users users = userDao.findById(userId);
		
		if (users == null) {
			throw new NotExistException("아이디에 해당하는 회원이 존재하지 않습니다.");
		}
		
		return users;
	}

	/**
	 * 회원 정보 수정
	 * @param: Users(userPassword, userTel, zipcode, addr, addrDetail 중 입력된 값에 따라 동적으로 회원 정보 수정)
	 * @return: int(update 결과)
	 * */
	@Override
	public void updateUser(Users users) throws SQLException, NotLoginException, NotDBInputException {
		int result = userDao.updateUser(users);
		System.out.println(result);
		if (result != 1) {
			throw new NotDBInputException("회원 정보 수정에 실패했습니다.");
		}
	}

	/**
	 * 회원 검색
	 * @param: Users(userId, userName, userTel, addr, userQuit 중 입력된 값에 따라 동적으로 검색)
	 * 			Page(null이냐 아니냐에 따라서 동적으로 페이징 처리)
	 * @return: List<Users>
	 * */
	@Override
	public List<Users> findUsers(Users users, Page page) throws SQLException {
		return userDao.findUsers(users, page);
	}
}
