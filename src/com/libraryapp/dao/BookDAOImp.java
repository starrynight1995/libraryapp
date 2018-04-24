package com.libraryapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.libraryapp.entity.Book;

@Repository
public class BookDAOImp implements BookDAO {
	
    @Autowired
    private MongoTemplate mongoTemplate;

	@Override
	public List<Book> getBooks() {
		return (List < Book> ) mongoTemplate.findAll(Book.class, "books");
	}

	@Override
	public void addBook(Book book) {
		mongoTemplate.insert(book, "books");
	}

	@Override
	public void deleteBook(Book book) {
		mongoTemplate.remove(book, "books");
	}

	@Override
	public Book getBook(String id) {
		return mongoTemplate.findById(id, Book.class);
	}

	@Override
	public void updateBook(Book book) {
		mongoTemplate.save(book);		
	}

}
