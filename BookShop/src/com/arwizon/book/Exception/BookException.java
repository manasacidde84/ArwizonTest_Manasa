package com.arwizon.book.Exception;

public class BookException extends Exception {
	String detailMsg;

	public BookException(String msg) {
		this.detailMsg=msg;
	}
	
	@Override
	public String getMessage() {
		return detailMsg;
	}

}
