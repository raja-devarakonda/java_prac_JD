/**
 * 
 */
package com.rest.restdemo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.rest.restdemo.model.Book;

/**
 * @author HY1916H
 *
 */

//the jpa repository has the various methods like findAll etc, hence we extend this jpaRepository
public interface BookRepository extends JpaRepository<Book, Integer> {

	
	      public Optional<Book> findByBookId(int id);
	      public void deleteByBookId(int id);
}
