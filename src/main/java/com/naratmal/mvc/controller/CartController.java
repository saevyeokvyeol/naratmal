package com.naratmal.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.naratmal.mvc.exception.DuplicatedException;
import com.naratmal.mvc.exception.NotExistException;
import com.naratmal.mvc.exception.NotLoginException;
import com.naratmal.mvc.service.CartService;
import com.naratmal.mvc.vo.Cart;
import com.naratmal.mvc.vo.Users;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CartController {
	private final CartService cartService;
	
	@RequestMapping("cart/insert")
	@ResponseBody
	public void insertCart(Cart cart) throws SQLException, NotLoginException, NotExistException, DuplicatedException {
		cartService.insertCart(cart);
	}
	
	@RequestMapping("main/cart/list")
	public void cartListById(HttpSession session, Model model) throws SQLException, NotLoginException {
		Users users = (Users)session.getAttribute("loginUser");
		Cart cart = Cart.builder().userId(users.getUserId()).build();
		List<Cart> carts = cartService.findCart(cart);
		model.addAttribute("list", carts);
	}

	@ExceptionHandler(Exception.class) // Controller에서 입력한 Exception 발생 시 이동
	public ModelAndView error(Exception e) { // 발생한 Exception 정보가 필요한 경우 인수로 입력하면 자동 삽입됨
		ModelAndView modelAndView = new ModelAndView("exception");
		modelAndView.addObject("exception", e);
		e.printStackTrace();
		
		return modelAndView; 
	}
}
