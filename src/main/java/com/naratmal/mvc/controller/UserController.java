package com.naratmal.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.naratmal.mvc.exception.DuplicatedException;
import com.naratmal.mvc.exception.NotDBInputException;
import com.naratmal.mvc.exception.NotExistException;
import com.naratmal.mvc.service.UserService;
import com.naratmal.mvc.vo.Users;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("main/")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	
	@RequestMapping("signup")
	public void singup() {}
	
	@RequestMapping("signup-complete")
	public void signupComplete(Users users, Model model) throws SQLException, DuplicatedException, NotDBInputException {
		userService.insertUser(users);
		List<Users> userList = userService.findUsers(null, null);
		model.addAttribute("userList", userList);
	}
	
	@RequestMapping("login")
	public void login() {}
	
	@RequestMapping("login-complete")
	public String loginComplete(Users users, HttpSession session) throws SQLException, NotExistException {
		Users loginUser = userService.login(users);
		session.setAttribute("loginUser", loginUser);
		return "redirect:/";
	}

	@ExceptionHandler(Exception.class) // Controller에서 입력한 Exception 발생 시 이동
	public ModelAndView error(Exception e) { // 발생한 Exception 정보가 필요한 경우 인수로 입력하면 자동 삽입됨
		ModelAndView modelAndView = new ModelAndView("exception");
		modelAndView.addObject("exception", e);
		e.printStackTrace();
		
		return modelAndView;
	}
}
