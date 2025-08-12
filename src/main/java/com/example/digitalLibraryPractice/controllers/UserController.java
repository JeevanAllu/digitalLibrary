package com.example.digitalLibraryPractice.controllers;

import com.example.digitalLibraryPractice.adapter.BookAdapter;
import com.example.digitalLibraryPractice.adapter.UserAdapter;
import com.example.digitalLibraryPractice.commons.CommonAdapter;
import com.example.digitalLibraryPractice.entities.input.BookInputEntity;
import com.example.digitalLibraryPractice.entities.input.UserInputEntity;
import com.example.digitalLibraryPractice.mappers.input.UserInputMapper;
import com.example.digitalLibraryPractice.model.UserModel;
import com.example.digitalLibraryPractice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final CommonAdapter<UserInputEntity,UserModel> adapter;

    @Autowired
    public UserController(CommonAdapter<UserInputEntity,UserModel> adapter) {
        this.adapter = adapter;
    }


    @PostMapping("/addUser")
    public UserModel addUser(@RequestBody UserInputEntity userInputEntity){
        return this.adapter.save(userInputEntity);
    }

    @GetMapping("/getUser/{id}")
    public UserModel getUser(@PathVariable long id){
        return this.adapter.findById(id);
    }

    @PutMapping("/updateUser/{id}")
    public UserModel updateUser(@PathVariable long id ,@RequestBody UserInputEntity userInputEntity){
        return this.adapter.updateById(id,userInputEntity);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable long id){
        this.adapter.deleteById(id);
        return "Row Deleted Successfully";
    }

    @GetMapping("/getAllUsers")
    public List<UserModel> getAllUsers(){
        return this.adapter.getAll();
    }
}
