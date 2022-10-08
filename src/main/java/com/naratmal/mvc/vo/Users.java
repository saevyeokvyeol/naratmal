package com.naratmal.mvc.vo;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Users {
	private String userId;
	private String userName;
	private String userPassword;
	private String userTel;
	private LocalDateTime userBirth;
	private String zipcode;
	private String addr;
	private String addrDetail;
	private String addrRef;
	private String userQuit;
	private LocalDateTime userInsertDate;
	
	private List<Orders> orderList;
	private List<Cart> carts;
	private List<Review> reviews;
	private List<Question> questions;
}
