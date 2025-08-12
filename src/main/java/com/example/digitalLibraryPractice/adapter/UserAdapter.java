package com.example.digitalLibraryPractice.adapter;

import com.example.digitalLibraryPractice.commons.CommonAdapter;
import com.example.digitalLibraryPractice.entities.input.UserInputEntity;
import com.example.digitalLibraryPractice.mappers.input.UserInputMapper;
import com.example.digitalLibraryPractice.model.UserModel;
import com.example.digitalLibraryPractice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserAdapter implements CommonAdapter<UserInputEntity,UserModel> {

    private final UserService userService;
    private final UserInputMapper userInputMapper;

    @Autowired
    public UserAdapter(UserService userService, UserInputMapper userInputMapper) {
        this.userService = userService;
        this.userInputMapper = userInputMapper;
    }

    @Override
    public UserModel save(UserInputEntity inputEntity){
        return this.userService.addUser(this.userInputMapper.mapToModel(inputEntity));
    }

    @Override
    public UserModel update(UserInputEntity userInputEntity) {
        return null;
    }

    @Override
    public UserModel findById(long id){
        return this.userService.getUser(id);
    }



    @Override
    public UserModel updateById(long id, UserInputEntity userInputEntity){
        return this.userService.updateUser(id,this.userInputMapper.mapToModel(userInputEntity));
    }

    @Override
    public void deleteById(long id){
        this.userService.deleteUser(id);
    }

    @Override
    public List<UserModel> getAll() {
        return this.userService.findAll();
    }

}
