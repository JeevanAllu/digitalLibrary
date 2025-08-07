package com.example.digitalLibraryPractice.services;

import com.example.digitalLibraryPractice.Exceptions.ResourceNotFoundException;
import com.example.digitalLibraryPractice.entities.input.BookInputEntity;
import com.example.digitalLibraryPractice.model.BookModel;
import com.example.digitalLibraryPractice.model.UserModel;
import com.example.digitalLibraryPractice.model.UserPrincipal;
import com.example.digitalLibraryPractice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

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

    public UserModel getUserByEmail(String email){
        return this.userRepository.getUserByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserModel userModel = this.getUserByEmail(username);
            return new UserPrincipal(userModel);
        }
        catch(ResourceNotFoundException e){
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}
