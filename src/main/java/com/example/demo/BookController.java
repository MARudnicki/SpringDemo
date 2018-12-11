package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private List<Book> book;

    public BookController(List<Book> book) {
        this.book = book;
    }

    @GetMapping("book")
    public List<Book> getBook() {
        return book;
    }

}
