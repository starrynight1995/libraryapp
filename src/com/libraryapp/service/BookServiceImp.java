package com.libraryapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryapp.dao.BookDAO;
import com.libraryapp.entity.Book;

@Service("bookDao")
public class BookServiceImp implements BookService {
	
	@Autowired
	BookDAO bookDao;

	@Override
	public List<Book> getBooks() {
		List<Book> books = bookDao.getBooks();
		
		return books;
	}

	@Override
	public Book addBook(Book book) {
		bookDao.addBook(book);
		
		return book;
	}

	@Override
	public Book deleteBook(Book book) {
		bookDao.deleteBook(book);
		
		return book;
	}


	@Override
	public Book updateBook(Book book) {
		bookDao.updateBook(book);
		
		return book;
	}

}
