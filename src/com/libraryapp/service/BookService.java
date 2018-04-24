package com.libraryapp.service;

import java.util.List;

import com.libraryapp.entity.Book;

public interface BookService {
	
	public List<Book> getBooks();
	
	public Book addBook(Book book);
	
	public Book deleteBook(Book book);
		
	public Book updateBook(Book book);

}
