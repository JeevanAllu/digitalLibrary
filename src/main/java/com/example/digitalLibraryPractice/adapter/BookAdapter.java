package com.example.digitalLibraryPractice.adapter;

import com.example.digitalLibraryPractice.commons.CommonAdapter;
import com.example.digitalLibraryPractice.entities.input.BookInputEntity;
import com.example.digitalLibraryPractice.mappers.input.BookInputMapper;
import com.example.digitalLibraryPractice.model.BookModel;
import com.example.digitalLibraryPractice.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookAdapter implements CommonAdapter<BookInputEntity,BookModel> {

    private final BookInputMapper bookInputMapper;
    private final BookService bookService;

    @Autowired
    public BookAdapter(BookInputMapper bookInputMapper, BookService bookService) {
        this.bookInputMapper = bookInputMapper;
        this.bookService = bookService;
    }


    @Override
    public BookModel save(BookInputEntity bookInputEntity){
        return this.bookService.addBook(this.bookInputMapper.mapToModel(bookInputEntity));
    }

    @Override
    public BookModel update(BookInputEntity bookInputEntity){
        return this.bookService.updateBook(this.bookInputMapper.mapToModel(bookInputEntity));
    }

    @Override
    public BookModel findById(long id){
        return this.bookService.findById(id);
    }

    @Override
    public void deleteById(long id){
        this.bookService.deleteBookById(id);
    }

    @Override
    public List<BookModel> getAll(){
        return this.bookService.findAll();
    }

}
