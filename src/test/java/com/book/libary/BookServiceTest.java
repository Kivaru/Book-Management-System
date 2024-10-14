package com.book.libary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.book.libary.model.Book;
import com.book.libary.service.BookService;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    void testCreateBook(){
        Book book = new Book(null, "Java Basics", "John Doe", 1.69);
        Book savedBook = bookService.saveBook(book);
        assertNotNull(savedBook.getId());
        assertEquals("Java Basics", savedBook.getTitle());   
    }

    @Test
    void testGetAllBooks(){
        List<Book> books = bookService.getAllBooks();
        assertNotNull(books);
    }

    @Test
    void testUpdateBook(){
        Book book = new Book(null, "Spring Boot", "Jane Doe", 2.99);
        Book savedBook = bookService.saveBook(book);

        savedBook.setPrice(3.99);

        Book updatedBook = bookService.updateBook(savedBook.getId(), savedBook);

        assertEquals(3.99, updatedBook.getPrice());
    }

    @Test
    void testDeleteBook(){
        Book book = new Book(null, "Test Book", "Author", 10.99);
        Book savedBook = bookService.saveBook(book);

        bookService.deleteBook(savedBook.getId());
        Book deletedBook = bookService.getBookById(savedBook.getId());

        assertNull(deletedBook);
    }

}
