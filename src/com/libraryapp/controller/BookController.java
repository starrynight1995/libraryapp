package com.libraryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.libraryapp.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	public BookService bookService;
	
	@RequestMapping("/books")
	public String getBooks() {
		return "books";
	}
	

}
