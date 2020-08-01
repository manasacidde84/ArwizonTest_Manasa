package com.arwizon.book.utility;

import com.arwizon.book.Exception.BookException;

public class Utilities {
	
	public static void validateChar(String name) throws BookException {
		if(!name.matches("[A-Za-z]+"))
			throw new BookException("This field accepts only characters");
	}
	
	public static void validateBookName(String bookName) throws BookException {
		if(!bookName.matches("[A-Za-z]+[0-9]+"))
			throw new BookException("This field accepts both characters and numerics");
	}
	
	public static void validateNumeric(String num) throws BookException {
		if(!num.matches("[0-9]+"))
			throw new BookException("This field accepts only numerics");
	}


}
