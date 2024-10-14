package com.book.libary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.book.libary.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :keyword, '%')) " + "OR LOWER(b.author) LIKE LOWER(CONCAT('%', :keyword, '%'))")

    List<Book> searchBook(@Param("keyword") String keyword);

}
