package com.example.bookstore.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.dto.payloads.BookPayload;
import com.example.bookstore.dto.requests.BookRequest;
import com.example.bookstore.model.Book;
import com.example.bookstore.services.BookService;

@RestController
@RequestMapping("/api/bookstore")
public class BookController {
    private BookService bookService;

    @GetMapping("/books")
    public List<BookPayload> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/add-books")
    public ResponseEntity<BookPayload> addBook(@RequestBody BookRequest bookRequest) {
        try {
            BookPayload newBook = bookService.createBook(bookRequest);
            return new ResponseEntity<>(newBook, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}