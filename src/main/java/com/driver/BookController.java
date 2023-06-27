package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity createBook(@RequestBody Book book){
        Book newbook = bookService.createBook(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }
    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity getBookById(@PathVariable("id") String id){
        Book newbook=bookService.findBookById(id);
        return new ResponseEntity<>(newbook,HttpStatus.FOUND);
    }
    @GetMapping("/get-all-books")
    public ResponseEntity getAllBooks(){
        List<Book> bookList=bookService.findAllBooks();
        return new ResponseEntity<>(bookList,HttpStatus.FOUND);
    }
    @GetMapping("/get-books-by-author")
    public ResponseEntity getAllBooksByAuthor(@RequestParam String author){
        List<Book> bookList=bookService.findBooksByAuthor(author);
        return new ResponseEntity<>(bookList,HttpStatus.FOUND);
    }
    @GetMapping("/get-books-by-genre")
    public ResponseEntity getAllBooksByGenre(@RequestParam String genre){
        List<Book> bookList=bookService.findBooksByAuthor(genre);
        return new ResponseEntity<>(bookList,HttpStatus.FOUND);
    }
    @DeleteMapping("/delete-book-by-id/{id}")
    public ResponseEntity deleteBookById(@PathVariable("id") String id){
        bookService.deleteBookById(id);
        return new ResponseEntity<>("Success",HttpStatus.MOVED_PERMANENTLY);

    }
    @DeleteMapping("/delete-all-books")
    public ResponseEntity deleteAll(){
        bookService.deleteAllBooks();
        return new ResponseEntity<>("Success",HttpStatus.MOVED_PERMANENTLY);

    }


}
