package com.naratmal.mvc.vo;

import java.sql.Timestamp;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Users {
	private String userId;
	private String userName;
	private String userPassword;
	private String userTel;
	private String zipcode;
	private String addr;
	private String addrDetail;
	private String userQuit;
	private Timestamp userInsertDate;
	private Timestamp userUpdateDate;
	
	private List<Orders> orderList;
	private List<Cart> carts;
	private List<Review> reviews;
	private List<Question> questions;
	
	@Builder
	public Users(String userId, String userName, String userPassword, String userTel, String zipcode, String addr,
			String addrDetail, String userQuit, Timestamp userInsertDate, Timestamp userUpdateDate) {
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
	}
}
