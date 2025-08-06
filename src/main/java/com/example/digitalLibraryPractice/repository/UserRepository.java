package com.example.digitalLibraryPractice.repository;


import com.example.digitalLibraryPractice.Exceptions.ResourceNotFoundException;
import com.example.digitalLibraryPractice.entities.output.BookOutputEntity;
import com.example.digitalLibraryPractice.entities.output.UserOutputEntity;
import com.example.digitalLibraryPractice.mappers.output.BookOutputMapper;
import com.example.digitalLibraryPractice.mappers.output.UserOutputMapper;
import com.example.digitalLibraryPractice.model.BookModel;
import com.example.digitalLibraryPractice.model.UserModel;
import com.example.digitalLibraryPractice.repository.jpa.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserRepository {

    private final UserJPARepository userJPARepository;
    private final UserOutputMapper userOutputMapper;

    @Autowired
    public UserRepository(UserJPARepository userJPARepository, UserOutputMapper userOutputMapper) {
        this.userJPARepository = userJPARepository;
        this.userOutputMapper = userOutputMapper;
    }

    public UserModel addUser(UserModel userModel){
        UserOutputEntity outputEntity = this.userOutputMapper.mapFromModel(userModel);
        UserOutputEntity savedOutputEntity = this.userJPARepository.save(outputEntity);
        return this.userOutputMapper.mapToModel(savedOutputEntity);
    }

    public UserModel getUser(long id){
        Optional<UserOutputEntity> outputEntity = this.userJPARepository.findById(id);
        return outputEntity.map(this.userOutputMapper::mapToModel)
                .orElseThrow(()->
                    new ResourceNotFoundException(UserModel.class,"id",String.valueOf(id))
                );
    }

    public String deleteUser(long id){
        this.userJPARepository.deleteById(id);
        return "Row deleted Successfully";
    }

    public UserModel updateUser(UserModel userModel){
        UserModel  u = this.getUser(userModel.getId());
        return this.addUser(userModel);
    }

    public List<UserModel> findAllUsers(){
        return this.userJPARepository.findAll().stream().map(this.userOutputMapper::mapToModel).toList();
    }


}
