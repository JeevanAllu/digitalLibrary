package com.example.digitalLibraryPractice.controllers;

import com.example.digitalLibraryPractice.adapter.MembershipAdapter;
import com.example.digitalLibraryPractice.commons.CommonAdapter;
import com.example.digitalLibraryPractice.entities.input.MembershipInputEntity;
import com.example.digitalLibraryPractice.model.MembershipModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/membership")
public class MembershipController {
    private final CommonAdapter<MembershipInputEntity,MembershipModel> adapter;

    @Autowired
    public MembershipController(CommonAdapter<MembershipInputEntity, MembershipModel> adapter) {
        this.adapter = adapter;
    }


    @PostMapping("/create")
    public MembershipModel save(@RequestBody MembershipInputEntity inputEntity){
        return this.adapter.save(inputEntity);
    }

    @GetMapping("/getUser/{id}")
    public MembershipModel getUser(@PathVariable long id){
        return this.adapter.findById(id);
    }
}
