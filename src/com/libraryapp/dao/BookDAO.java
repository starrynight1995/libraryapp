package com.libraryapp.dao;

import java.util.List;

import com.libraryapp.entity.Book;

public interface BookDAO {
	
	public List<Book> getBooks();
	
	public void addBook(Book book);
	
	public void deleteBook(Book book);
	
	public Book getBook(String id);
	
	public void updateBook(Book book);

}
