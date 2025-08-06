package com.example.digitalLibraryPractice.services;

import com.example.digitalLibraryPractice.entities.input.BookInputEntity;
import com.example.digitalLibraryPractice.model.BookModel;
import com.example.digitalLibraryPractice.model.UserModel;
import com.example.digitalLibraryPractice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel addUser(UserModel userModel){
        return this.userRepository.addUser(userModel);
    }

    public UserModel getUser(long id){
        return this.userRepository.getUser(id);
    }

    public UserModel updateUser(UserModel userModel){
        return this.userRepository.updateUser(userModel);
    }

    public void deleteUser(long id){
        this.userRepository.deleteUser(id);
    }

    public List<UserModel> findAll(){
        return this.userRepository.findAllUsers();
    }
}
