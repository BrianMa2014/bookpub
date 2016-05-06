package org.bookpub.controller;

import org.bookpub.domain.Author;
import org.bookpub.domain.Book;
import org.bookpub.domain.Publisher;
import org.bookpub.repository.AuthorRepository;
import org.bookpub.repository.BookRepository;
import org.bookpub.repository.PublisherRepository;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by MaMingJiang on 2016/2/17.
 */
@RestController
@RequestMapping("/books")
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Book> getAllBooks(){

      return bookRepository.findAll();
    }

    @RequestMapping(value = "/{isbn}", method = RequestMethod.GET)
    public Map<String,Object> getBookByISBN(@PathVariable String isbn){
        Book book =  bookRepository.findBookByIsbn(isbn);
        Map<String,Object> response = new LinkedHashMap<>();
        response.put("message", "get book with isbn(" + isbn +")");
        response.put("book",book);
        return response;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Map<String,Object> addBook(@RequestBody JSONObject bookJson){
        JSONObject authorObj = bookJson.getJSONObject("author");
        Author author = new Author(authorObj.getString("firstName"),authorObj.getString("lastName"));
        authorRepository.save(author);

        JSONObject publisherObj = bookJson.getJSONObject("publisher");
        Publisher publisher = new Publisher(publisherObj.getString("name"));
        publisherRepository.save(publisher);

        JSONObject bookObj = bookJson.getJSONObject("book");
        Book book = new Book(bookObj.getString("isbn"),bookObj.getString("title"),bookObj.getString("description"),author,publisher);
        bookRepository.save(book);

        Map<String,Object> response = new LinkedHashMap<>();
        response.put("msg","add book");
        response.put("book",book);
        return response;
    }

    @RequestMapping(value = "/{isbn}/{title}",method = RequestMethod.PUT)
    public Map<String,Object> updateBook(@PathVariable String isbn,@PathVariable String title){
        Book book = bookRepository.findBookByIsbn(isbn);
        book.setTitle(title);
        bookRepository.save(book);

        Map<String,Object> response = new LinkedHashMap<>();
        response.put("msg","update book succesfully");
        response.put("book", book);
        return response;
    }
}
