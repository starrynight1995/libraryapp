package com.libraryapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.libraryapp.entity.Book;
import com.libraryapp.service.BookService;

@RequestMapping("/service/book")
@RestController
public class BookRestController {
	
	@Autowired
	BookService bookService;
	
	// list books
	@RequestMapping(value = "/list", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Book> listBooks() {
		List<Book> books = bookService.getBooks();
		
		return books;
	}
	
	// add book
	@RequestMapping(value="/add", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody Book addBook(@RequestBody Book book) {
		bookService.addBook(book);
		
		return book;
	}
	
	// delete book
	@RequestMapping(value="/delete", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody Book deleteBook(@RequestBody Book book) {
		bookService.deleteBook(book);
		
		return book;
	}
	
	// update book
	@RequestMapping(value="/update", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody Book editBook(@RequestBody Book book) {
		bookService.updateBook(book);
		
		return book;
	}
	

}
