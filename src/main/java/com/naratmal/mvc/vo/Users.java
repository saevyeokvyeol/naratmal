package com.naratmal.mvc.vo;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
public class Users {
	@Builder
	public Users(String userId, String userName, String userPassword, String userTel, String zipcode, String addr,
			String addrDetail, String userQuit, LocalDateTime userInsertDate, LocalDateTime userUpdateDate,
			List<Orders> orderList, List<Cart> carts, List<Review> reviews, List<Question> questions) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userTel = userTel;
		this.zipcode = zipcode;
		this.addr = addr;
		this.addrDetail = addrDetail;
		this.userQuit = userQuit;
		this.userInsertDate = userInsertDate;
		this.userUpdateDate = userUpdateDate;
		this.orderList = orderList;
		this.carts = carts;
		this.reviews = reviews;
		this.questions = questions;
	}
	
	private String userId;
	private String userName;
	private String userPassword;
	private String userTel;
	private String zipcode;
	private String addr;
	private String addrDetail;
	private String userQuit;
	private LocalDateTime userInsertDate;
	private LocalDateTime userUpdateDate;
	
	private List<Orders> orderList;
	private List<Cart> carts;
	private List<Review> reviews;
	private List<Question> questions;
}
