package com.naratmal.mvc.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageCnt {
	private int pageNum;
	public static int pageSize = 10;
	public static int blockCount = 5;
	public static int totalCount = 0;
	
	public PageCnt() {
		super();
	}

	public PageCnt(int pageNum) {
		super();
		this.pageNum = pageNum;
	}
}
