package com.book.libary.service;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.book.libary.exception.BookNotFoundException;
import com.book.libary.model.Book;
import com.book.libary.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(int page, int size, String sortBy) {
        PageRequest pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Book> bookPage = bookRepository.findAll(pageable);
        return bookPage.getContent();
    }

    public Book getBookById(Long id){
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book Not Found with id: " + id));
    }

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book updatedBook){

        Book existingBook = bookRepository.findById(id).orElse(null);

        if(existingBook != null){
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setPrice(updatedBook.getPrice());
            return bookRepository.save(existingBook);
        }
        
        return null;

    }

    public void deleteBook(Long id){
         bookRepository.deleteById(id);
    }

}
