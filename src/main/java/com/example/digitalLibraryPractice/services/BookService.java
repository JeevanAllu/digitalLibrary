package com.example.digitalLibraryPractice.services;

import com.example.digitalLibraryPractice.model.BookModel;
import com.example.digitalLibraryPractice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public BookModel addBook(BookModel bookModel){
        return this.bookRepository.save(bookModel);
    }

    public BookModel findById(long id) {
        return this.bookRepository.findById(id);
    }

    public BookModel updateBook(BookModel bookModel){
        return this.bookRepository.save(bookModel);
    }

    public void deleteBookById(long id){
        this.bookRepository.deleteBookById(id);
    }

    public List<BookModel> findAll(){
        return this.bookRepository.findAllBooks();
    }

}
