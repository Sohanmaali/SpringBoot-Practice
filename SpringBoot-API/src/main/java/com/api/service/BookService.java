package com.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.dao.BookRepository;
import com.api.entities.Book;

@Component
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBook() {

		return (List<Book>) this.bookRepository.findAll();
	}

	public Book getBookById(int id) {

		try {
			return bookRepository.findById(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return null;
	}

	public Book addBook(Book book) {
		return this.bookRepository.save(book);

	}

	public void deleteBook(int id) {
		this.bookRepository.deleteById(id);
	}

	public void updateBook(Book book, int id) {
		this.bookRepository.save(book);
	}

//	=====================================================================
//	private static List<Book> list = new ArrayList<>();
//	static {
//		list.add(new Book(1, "Java", "sohan"));
//		list.add(new Book(2, "Python", "sohan"));
//		list.add(new Book(3, "Js", "sohan"));
//		list.add(new Book(4, "c", "sohan"));
//		list.add(new Book(5, "c++", "sohan"));
//	}
//
//	public List<Book> getAllBook() {
//		return list;
//	}
//
//	public Book getBookById(int id) {
//		Book book = null;
//		book = list.stream().filter(e -> e.getId() == id).findFirst().get();
//		return book;
//	}
//
//	public Book addBook(Book book) {
//		list.add(book);
//		return book;
//	}
//
//	public void deleteBook(int id) {
//		list = list.stream().filter(book -> book.getId() != id).collect(Collectors.toList());
//	}
//
//	public void updateBook(Book book, int id) {
//		list = list.stream().map(b -> {
//			if (b.getId() == id) {
//
//				b.setAuthor(book.getAuthor());
//				b.setTitle(book.getTitle());
//
//			}
//			return b;
//		}).collect(Collectors.toList());
//	}

}
