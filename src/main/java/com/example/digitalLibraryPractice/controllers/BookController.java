package com.example.digitalLibraryPractice.controllers;

import com.example.digitalLibraryPractice.Exceptions.ResourceNotFoundException;
import com.example.digitalLibraryPractice.adapter.BookAdapter;
import com.example.digitalLibraryPractice.commons.CommonAdapter;
import com.example.digitalLibraryPractice.entities.input.BookInputEntity;
import com.example.digitalLibraryPractice.entities.output.BookOutputEntity;
import com.example.digitalLibraryPractice.model.BookModel;
import com.example.digitalLibraryPractice.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final CommonAdapter<BookInputEntity,BookModel> adapter;

    @Autowired
    public BookController(CommonAdapter<BookInputEntity, BookModel> adapter) {
        this.adapter = adapter;
    }

//    @PostMapping("/add")
//    public BookModel addBook(@RequestBody BookInputEntity bookInputEntity){
//        return this.bookAdapter.save(bookInputEntity);
//    }
    @PostMapping("/add")
    public ResponseEntity<?> addBook(@Valid @RequestBody BookInputEntity book){
        return new ResponseEntity<>
                (this.adapter.save(book),
                        HttpStatus.CREATED);
    }

    @GetMapping("/getBook/{id}")
    public BookModel getBookById(@PathVariable long id){
        return this.adapter.findById(id);
    }

    @PutMapping("/updateBook")
    public ResponseEntity<?> updateBook(@Valid @RequestBody BookInputEntity book){
        try {
            return new ResponseEntity<>
                    (this.adapter.update(book),
                            HttpStatus.OK);
        }
        catch(ResourceNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/deleteBook/{id}")
    public String deleteBookById(@PathVariable Long id, BookInputEntity book){
        this.adapter.deleteById(id);
        return "BookDeleted Successfully";
    }

    @GetMapping("/getAllBooks")
    public List<BookModel>findAllBooks(){
        return this.adapter.getAll();
    }

}
