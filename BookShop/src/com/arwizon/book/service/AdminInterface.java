package com.arwizon.book.service;

import java.util.Set;

import com.arwizon.book.model.Book;

public interface AdminInterface {
	public void addBook(String bookName,String bookType,String author,int noOfCopies,double cost);
	public Set<Book> DisplayAllBooks();
	public Set<Book> searchBook(String bookName);
	public void updateBook(int bookId,int noOfCopies);

}
