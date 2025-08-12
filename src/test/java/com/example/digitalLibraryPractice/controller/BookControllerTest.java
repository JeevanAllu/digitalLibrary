package com.example.digitalLibraryPractice.controller;

import com.example.digitalLibraryPractice.Exceptions.ResourceNotFoundException;
import com.example.digitalLibraryPractice.commons.CommonAdapter;
import com.example.digitalLibraryPractice.controllers.BookController;
import com.example.digitalLibraryPractice.entities.input.BookInputEntity;
import com.example.digitalLibraryPractice.model.BookModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Instant;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

    @Mock
    private CommonAdapter<BookInputEntity,BookModel> adapter;

    @InjectMocks
    private BookController bookController;

    static BookInputEntity inputEntity;
    static BookModel bookModel;

    @BeforeAll
    static void setUp(){
        inputEntity = BookInputEntity.builder()
                .id(1L)
                .name("Half girl friend")
                .author("Chethan Bhagat")
                .description("this is a love story")
                .publishedDate(Instant.now())
                .build();

        bookModel = BookModel.builder()
                .id(1L)
                .name("Half girl friend")
                .author("Chethan Bhagat")
                .description("this is a love story")
                .publishedDate(Instant.now())
                .createdAt(Instant.now())
                .updatedAt(null)
                .build();

    }

    @Test
    @DisplayName("Adding new book should return a BookModel")
    void testAddBook(){
        Mockito.when(adapter.save(Mockito.any())).thenReturn(bookModel);
        ResponseEntity <?> actualResponse = this.bookController.addBook(inputEntity);
        Assertions.assertEquals(HttpStatus.CREATED,actualResponse.getStatusCode());
        Assertions.assertEquals(bookModel,actualResponse.getBody());
    }

    @Test
    @DisplayName("update new book should update the book")
    void testUpdateBook() {
        BookInputEntity modifiedInput = inputEntity.withDescription("It's a wizard fantasy book");
        BookModel modifiedModel = bookModel.withDescription("It's a wizard fantasy book");

        // Fix: Match any input entity instead of matching by reference
        Mockito.when(this.adapter.update(Mockito.any(BookInputEntity.class)))
                .thenReturn(modifiedModel);

        ResponseEntity<?> actualResponse = this.bookController.updateBook(modifiedInput);

        Assertions.assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        Assertions.assertEquals(modifiedModel, actualResponse.getBody());
    }

    @Test
    @DisplayName("update new book should give bad_request")
    void testUpdateBook_updateFailed() {
        BookInputEntity modifiedInput = inputEntity.withDescription("It's a wizard fantasy book").withId(2L);
        //BookModel modifiedModel = bookModel.withDescription("It's a wizard fantasy book");

        // Fix: Match any input entity instead of matching by reference
        Mockito.when(this.adapter.update(Mockito.any(BookInputEntity.class)))
                .thenThrow(new ResourceNotFoundException(Mockito.any()));

        ResponseEntity<?> actualResponse = this.bookController.updateBook(modifiedInput);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, actualResponse.getStatusCode());

    }

}
