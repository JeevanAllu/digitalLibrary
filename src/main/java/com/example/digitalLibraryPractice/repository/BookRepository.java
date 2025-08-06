package com.example.digitalLibraryPractice.repository;

import com.example.digitalLibraryPractice.Exceptions.ResourceNotFoundException;
import com.example.digitalLibraryPractice.entities.output.BookOutputEntity;
import com.example.digitalLibraryPractice.mappers.output.BookOutputMapper;
import com.example.digitalLibraryPractice.model.BookModel;
import com.example.digitalLibraryPractice.repository.jpa.BookJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Component
public class BookRepository {

    private BookJPARepository bookJPARepository;
    private BookOutputMapper bookOutputMapper;

    @Autowired
    public BookRepository(BookJPARepository bookJPARepository, BookOutputMapper bookOutputMapper) {
        this.bookJPARepository = bookJPARepository;
        this.bookOutputMapper = bookOutputMapper;
    }

    public BookModel save(BookModel bookModel){
        //model to OutputEntity
        BookOutputEntity outputEntity = this.bookOutputMapper.mapFromModel(bookModel);
        //save in DB
        BookOutputEntity savedOutputEntity = this.bookJPARepository.save(outputEntity);
        //convert the saved OutputEntity to model
        //return model
        return this.bookOutputMapper.mapToModel(savedOutputEntity);
    }

    public BookModel findById(long id) {
        Optional<BookOutputEntity> optionalBookOutputEntity = this.bookJPARepository.findById(id);
        return optionalBookOutputEntity.map(bookOutputEntity ->
                this.bookOutputMapper.mapToModel(bookOutputEntity))
                .orElseThrow(() ->
                        new ResourceNotFoundException(BookModel.class,"id",String.valueOf(id))
                );
    }

    public BookModel updateBook(BookModel bookModel){
        BookModel b = this.findById(bookModel.getId());
        bookModel.setUpdatedAt(Instant.now());
        bookModel.setCreatedAt(b.getCreatedAt());
        return this.save(bookModel);
    }

    public void deleteBookById(long id)
    {
        this.bookJPARepository.deleteById(id);

    }

    public List<BookModel> findAllBooks(){
        return this.bookJPARepository.findAll().stream().map(this.bookOutputMapper::mapToModel).toList();
    }
}
