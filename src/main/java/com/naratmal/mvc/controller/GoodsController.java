package com.naratmal.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.naratmal.mvc.exception.NotDBInputException;
import com.naratmal.mvc.exception.NotExistException;
import com.naratmal.mvc.service.GoodsClassService;
import com.naratmal.mvc.service.GoodsService;
import com.naratmal.mvc.vo.Goods;
import com.naratmal.mvc.vo.GoodsClass;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class GoodsController {
	private final GoodsService goodsService;
	private final GoodsClassService goodsClassService;

	@RequestMapping("admin/goods/insert")
	public void insertGoodsForm() {}

	@RequestMapping("admin/goods/insert-complete")
	public void insertGoods(Goods goods, MultipartFile file, HttpSession session) throws SQLException, NotExistException, NotDBInputException, IllegalStateException, IOException {
		System.out.println(file);
		if(file != null && file.getSize() > 0) {
			File img = new File(session.getServletContext().getRealPath("resources/images/goods/") + file.getOriginalFilename());
			file.transferTo(img);
			goods.setGoodsThumbnail(file.getOriginalFilename());
		}
		goodsService.insertGoods(goods);
	}
	
	@RequestMapping("goods/selectClassAll")
	@ResponseBody
	public List<GoodsClass> selecClassAll() throws SQLException {
		return goodsClassService.findAllGoodsClass();
	}

	@ExceptionHandler(Exception.class) // Controller에서 입력한 Exception 발생 시 이동
	public ModelAndView error(Exception e) { // 발생한 Exception 정보가 필요한 경우 인수로 입력하면 자동 삽입됨
		ModelAndView modelAndView = new ModelAndView("exception");
		modelAndView.addObject("exception", e);
		e.printStackTrace();
		
		return modelAndView; 
	}
}
