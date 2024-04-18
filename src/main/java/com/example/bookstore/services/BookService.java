package com.example.bookstore.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.dto.payloads.BookPayload;
import com.example.bookstore.dto.requests.BookRequest;
import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    /*
     * Getting all books
     */
    public List<BookPayload> getAllBooks() {
        List<BookPayload> books = new ArrayList<>();
        for (Book book : bookRepository.findAll()) {
            books.add(convertToPayload(book));
        }
        return books;
    }

    /*
     * Getting a book by ID
     */
    public BookPayload getBookById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.map(this::convertToPayload).orElse(null);
    }

    /*
     * Creating a new book
     */
    public BookPayload createBook(BookRequest bookRequest) {
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setIsbn(bookRequest.getIsbn());
        book.setPrice(bookRequest.getPrice());
        // Set any other attributes as needed
        
        book = bookRepository.save(book);
        return convertToPayload(book);
    }

    /*
     * Updating an existing book
     */
    public BookPayload updateBook(Long id, BookRequest bookRequest) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(bookRequest.getTitle());
            book.setIsbn(bookRequest.getIsbn());
            book.setPrice(bookRequest.getPrice());
            // Update any other attributes as needed
            
            book = bookRepository.save(book);
            return convertToPayload(book);
        } else {
            // Handle the case when book with given id is not found
            return null;
        }
    }

    /*
     * Deleting a book by ID
     */
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    // Helper method to convert Book entity to BookPayload DTO
    private BookPayload convertToPayload(Book book) {
        BookPayload payload = new BookPayload();
        payload.setId(book.getId());
        payload.setTitle(book.getTitle());
        payload.setIsbn(book.getIsbn());
        payload.setPrice(book.getPrice());
        // Set any other attributes as needed
        return payload;
    }

    
}
