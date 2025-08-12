package com.example.digitalLibraryPractice.commons;

import com.example.digitalLibraryPractice.entities.input.BookInputEntity;
import com.example.digitalLibraryPractice.entities.input.UserInputEntity;
import com.example.digitalLibraryPractice.model.BookModel;
import com.example.digitalLibraryPractice.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommonAdapter<E,M>{

    M save(E e);

    M update(E e);

    M findById(long id);



    UserModel updateById(long id, UserInputEntity userInputEntity);

    void deleteById(long id);

    List<M> getAll();


}
