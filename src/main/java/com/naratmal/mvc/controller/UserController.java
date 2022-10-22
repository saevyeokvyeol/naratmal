package com.naratmal.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.naratmal.mvc.exception.DuplicatedException;
import com.naratmal.mvc.exception.NotDBInputException;
import com.naratmal.mvc.exception.NotExistException;
import com.naratmal.mvc.exception.NotLoginException;
import com.naratmal.mvc.service.UserService;
import com.naratmal.mvc.vo.PageCnt;
import com.naratmal.mvc.vo.Users;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	
	@RequestMapping("main/user/signup")
	public void singup() {}
	
	@RequestMapping("main/user/signup-complete")
	public void signupComplete(Users users, Model model) throws SQLException, DuplicatedException, NotDBInputException {
		userService.insertUser(users);
		List<Users> userList = userService.findUsers(null, null);
		model.addAttribute("userList", userList);
	}
	
	@RequestMapping("main/user/login")
	public void login() {}
	
	@RequestMapping("main/user/login-complete")
	public String loginComplete(Users users, HttpSession session, HttpServletRequest request) throws SQLException, NotExistException {
		Users loginUser = userService.login(users);
		session.setAttribute("loginUser", loginUser);
		return "redirect:/main/user/profile";
	}
	
	@RequestMapping("main/user/logout")
	public String logout(HttpSession session, HttpServletRequest request) {
		session.invalidate();
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping("main/user/profile")
	public void profile(Model model, HttpSession session) throws SQLException, NotExistException {
		Users loginUser = (Users)session.getAttribute("loginUser");
		Users users = userService.findById(loginUser.getUserId());
		model.addAttribute("users", users);
	}
	
	@RequestMapping("main/user/update-profile")
	public String updateProfile(Users users) throws SQLException, NotLoginException, NotDBInputException {
		userService.updateUser(users);
		return "redirect:/main/user/profile";
	}
	
	@RequestMapping("admin/user/list")
	public void findUsers(Users users, @RequestParam(defaultValue = "1") int page, Model model) throws SQLException {
		List<Users> userList = userService.findUsers(users, new PageCnt(page));
		model.addAttribute("userList", userList);
		
		int temp = (page - 1) % PageCnt.blockCount;
		int startPage = page - temp;
		int totalPage = PageCnt.totalCount / 10;
		totalPage += PageCnt.totalCount % 10 > 0 ? 1 : 0;
		
		model.addAttribute("blockCount", PageCnt.blockCount);
		model.addAttribute("startPage", startPage);
		model.addAttribute("page", page);
		model.addAttribute("totalPage", totalPage);
	}

	@ExceptionHandler(Exception.class) // Controller에서 입력한 Exception 발생 시 이동
	public ModelAndView error(Exception e) { // 발생한 Exception 정보가 필요한 경우 인수로 입력하면 자동 삽입됨
		ModelAndView modelAndView = new ModelAndView("exception");
		modelAndView.addObject("exception", e);
		e.printStackTrace();
		
		return modelAndView; 
	}
}
