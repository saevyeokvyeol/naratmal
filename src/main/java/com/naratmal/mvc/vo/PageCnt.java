package com.naratmal.mvc.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageCnt {
	private int pageNum;
	public static int pageSize = 10;
	public static int blockCount = 5;
	
	public PageCnt() {
		super();
	}

	public PageCnt(int pageCnt) {
		super();
		this.pageNum = pageNum;
	}
}
