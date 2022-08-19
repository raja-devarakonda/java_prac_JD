/**
 * 
 */
package com.rest.restdemo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.restdemo.model.Book;
import com.rest.restdemo.service.BookService;

/**
 * @author HY1916H
 *
 */
@RestController
@RequestMapping("/web")
//allowing a particular url to work as a client @CrossOrigin(origins="http://localhost:4200")
public class WebController {
	
		@Autowired
		BookService service;
		@GetMapping("/hi")
		public String sayHello()
	   {
		
	   return "Hello World... From Spring Book Rest";
	   
	   
	   }
		
		@GetMapping("/books")
		public Collection<Book> getBooks()
		{
			return service.getBooks();
		}
		
		@GetMapping("/books/{id}")
		public Book getBookById(@PathVariable int id) {
			
			return service.getBookById(id);
		}
		//although the url is same following the rest principles, the post and get differentiates these
		//Now for inserting a book, this method is passeed on to the service layer.
		//Since this post involves a request body which has data in the from of JSON object.
		//It is important that we convert the json object properties to the actual object and hence we use @RequestBOdy
		//THis post request is usually done by the forms, but since we dont have the forms, we can make requests using POSTMAN application
		@PostMapping("/books")
		public Book createBook(@RequestBody Book book)
		{
			return service.createBook(book);
		}
		
		@PutMapping("/books")
		public Book updateBook(@RequestBody Book toUpdate){
              return service.updateBook(toUpdate);
		}
		
		@Transactional
		@DeleteMapping("/books/{id}")
		public String deleteBookById(@PathVariable int id) {
			
			service.deleteBookById(id);
			return "Deletion successful";
			
		}

}