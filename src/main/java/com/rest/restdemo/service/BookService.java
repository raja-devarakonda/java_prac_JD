package com.rest.restdemo.service;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.restdemo.dao.BookRepository;
import com.rest.restdemo.model.Book;


@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;
	public Collection<Book> getBooks()
	{
		return bookRepo.findAll();
		
	}
	
	//This method is passed on to the dao layer. this method is implemented by jpa repository and it is created at runtime. 
	public Book createBook(Book book) {
		// TODO Auto-generated method stub
		return bookRepo.save(book);
		
	}
	
	public Book updateBook(Book toUpdate) {
		Book book = bookRepo.findByBookId(toUpdate.getBookId()).get();
		book.setAuthor(toUpdate.getAuthor());
		book.setPrice(toUpdate.getPrice());
		book.setTitle(toUpdate.getTitle());
		book.setGenre(toUpdate.getGenre());
		return bookRepo.save(book);
		
		
	}

	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		return bookRepo.findByBookId(id).get();
	}

	public void deleteBookById(int id) {
		// TODO Auto-generated method stub
		bookRepo.deleteByBookId(id);
	}
	
}
