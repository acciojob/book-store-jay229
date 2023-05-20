package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    HashMap<Integer,Book>bookMap;

    public BookRepository(){
        bookMap=new HashMap<>();
    }

    public Book save(Book book){
        int id= book.getId();
        bookMap.put(id,book);
        return book;
    }

    public Book findBookById(int id){
        return bookMap.get(id);
    }

    public List<Book> findAll(){
        List<Book> bookList=new ArrayList<>();
        for (Map.Entry<Integer,Book> entry:bookMap.entrySet()){
            Book book=entry.getValue();
            bookList.add(book);
        }
        return bookList;
    }

    public void deleteBookById(int id){
        bookMap.remove(id);

    }

    public void deleteAll(){
        bookMap.clear();
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> bookList=new ArrayList<>();
        for (Map.Entry<Integer,Book> entry:bookMap.entrySet()){
            Book book=entry.getValue();
            if(book.getAuthor().equals(author)){
                bookList.add(book);
            }
        }
        return bookList;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> bookList=new ArrayList<>();
        for (Map.Entry<Integer,Book> entry:bookMap.entrySet()){
            Book book=entry.getValue();
            if(book.getGenre().equals(genre)){
                bookList.add(book);
            }
        }
        return bookList;
    }
}
