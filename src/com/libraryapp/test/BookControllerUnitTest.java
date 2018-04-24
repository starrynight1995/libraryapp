package com.libraryapp.test;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.libraryapp.controller.BookRestController;
import com.libraryapp.entity.Book;
import com.libraryapp.service.BookService;
import com.libraryapp.util.Utils;

public class BookControllerUnitTest {

	private MockMvc mockMvc;

	@Mock
	private BookService bookService;

	@InjectMocks
	private BookRestController bookRestController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(bookRestController).build();
	}

	// TEST - getBooks()

	@Test
	public void testGetAllBooks() throws Exception {
		List<Book> books = Arrays.asList(new Book("a82734222dsd", "Yedinci Gun", "Ihsan Oktay Anar", "Oyku"),
				new Book("a8273427bdsd", "Galiz Kahraman", "Ihsan Oktay Anar", "Oyku"));

		when(bookService.getBooks()).thenReturn(books);

		mockMvc.perform(get("/service/book/list"))
		        .andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$", hasSize(books.size())))
				.andExpect(jsonPath("$[0].id", is(books.get(0).getId())))
				.andExpect(jsonPath("$[0].name", is(books.get(0).getName())))
				.andExpect(jsonPath("$[0].author", is(books.get(0).getAuthor())))
				.andExpect(jsonPath("$[1].id", is(books.get(1).getId())))
				.andExpect(jsonPath("$[1].name", is(books.get(1).getName())))
				.andExpect(jsonPath("$[1].author", is(books.get(1).getAuthor())));

		verify(bookService, times(1)).getBooks();
		verifyNoMoreInteractions(bookService);
	}

	// TEST - addBook()

	@Test
	public void testAddBook() throws Exception {
		Book book = new Book("a8273427bdsd", "Yedinci Gun", "Ihsan Oktay Anar", "Oyku");

		mockMvc.perform(
				post("/service/book/add").contentType(MediaType.APPLICATION_JSON).content(Utils.asJsonString(book)))
				.andExpect(jsonPath("id", is(book.getId()))).andExpect(jsonPath("name", is(book.getName())))
				.andExpect(jsonPath("author", is(book.getAuthor()))).andExpect(status().isOk());

	}

	// TEST - deleteBook()

	@Test
	public void testDeleteBook() throws Exception {
		Book book = new Book("a827343457bdsd", "Yedinci Gun", "Ihsan Oktay Anar", "Oyku");

		when(bookService.deleteBook(book)).thenReturn(book);

		mockMvc.perform(
				post("/service/book/delete")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Utils.asJsonString(book)))
				.andExpect(jsonPath("id", is(book.getId())))
				.andExpect(jsonPath("name", is(book.getName())))
				.andExpect(jsonPath("author", is(book.getAuthor())))
				.andExpect(status().isOk());

	}

	// TEST - updateBook()

	@Test
	public void testUpdateBook() throws Exception {
		Book book = new Book("a84323427bdsd", "Yedinci Gun", "Ihsan Oktay Anar", "Oyku");

		when(bookService.updateBook(book)).thenReturn(book);

		mockMvc.perform(
				post("/service/book/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Utils.asJsonString(book)))
				.andExpect(jsonPath("id", is(book.getId())))
				.andExpect(jsonPath("name", is(book.getName())))
				.andExpect(jsonPath("author", is(book.getAuthor())))
				.andExpect(status().isOk());
	}

}
