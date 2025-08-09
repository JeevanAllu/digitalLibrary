package com.example.digitalLibraryPractice.controllers;

import com.example.digitalLibraryPractice.Exceptions.MembershipException;
import com.example.digitalLibraryPractice.adapter.MembershipAdapter;
import com.example.digitalLibraryPractice.entities.input.MembershipInputEntity;
import com.example.digitalLibraryPractice.enums.MembershipStatus;
import com.example.digitalLibraryPractice.model.MembershipModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/membership")
public class MembershipController {
    private final MembershipAdapter adapter;

    @Autowired
    public MembershipController(MembershipAdapter adapter) {
        this.adapter = adapter;
    }


    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestBody MembershipInputEntity inputEntity){
        try {
            return new ResponseEntity<>(this.adapter.save(inputEntity), HttpStatus.CREATED);
        }
        catch(MembershipException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getUser/{id}")
    public MembershipModel getUser(@PathVariable long id){
        return this.adapter.findById(id);
    }

    @PutMapping("/changeStatus/{userId}")
    public ResponseEntity<?> updateStatus(@PathVariable long userId,@RequestParam MembershipStatus status){
        if(status == MembershipStatus.EXPIRED){
            return new ResponseEntity<>("User can't change membership status to Expired",HttpStatus.BAD_REQUEST);
        }
        try {
            return new ResponseEntity<>(this.adapter.changeStatus(userId, status), HttpStatus.OK);
        }
        catch(MembershipException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteMember/{userId}")
    public void deleteMemberByUserId(@PathVariable long userId){
        this.adapter.deleteMemberByUserId(userId);
    }
}
