package com.naratmal.mvc.vo;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Users {
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
