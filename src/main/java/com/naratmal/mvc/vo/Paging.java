package com.naratmal.mvc.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paging {
	private int pageNum;
	public static int pageSize = 15;
	public static int blockCount = 5;
	public static int totalCount = 0;
	
	public Paging() {
		super();
	}

	public Paging(int pageNum) {
		super();
		this.pageNum = pageNum;
	}
}
