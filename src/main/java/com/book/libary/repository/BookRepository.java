package com.book.libary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.libary.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
