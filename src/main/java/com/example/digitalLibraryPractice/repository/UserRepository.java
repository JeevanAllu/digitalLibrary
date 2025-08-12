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
import org.springframework.http.ResponseEntity;
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

    public UserModel updateUser(Long userId, UserModel updatedUser) {
        UserModel existingUser = this.getUser(userId);

        if (existingUser == null) {
            throw new RuntimeException("User not found with ID: " + userId);
        }

        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setDateOfBirth(updatedUser.getDateOfBirth());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
        existingUser.setRole(updatedUser.getRole());

        return this.addUser(existingUser);
    }




    public String deleteUser(long id){
        this.userJPARepository.deleteById(id);
        return "Row deleted Successfully";
    }





    public List<UserModel> findAllUsers(){
        return this.userJPARepository.findAll().stream().map(this.userOutputMapper::mapToModel).toList();
    }

    public UserModel getUserByEmail(String email){
        return this.userJPARepository.findByEmail(email).map(this.userOutputMapper::mapToModel)
                .orElseThrow(()->
                        new ResourceNotFoundException(UserModel.class,"email",email)
                );
    }




}
