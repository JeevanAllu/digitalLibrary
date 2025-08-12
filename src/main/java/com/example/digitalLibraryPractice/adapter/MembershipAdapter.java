package com.example.digitalLibraryPractice.adapter;

import com.example.digitalLibraryPractice.commons.CommonAdapter;
import com.example.digitalLibraryPractice.entities.input.MembershipInputEntity;
import com.example.digitalLibraryPractice.entities.input.UserInputEntity;
import com.example.digitalLibraryPractice.enums.MembershipStatus;
import com.example.digitalLibraryPractice.mappers.input.BookInputMapper;
import com.example.digitalLibraryPractice.mappers.input.MembershipInputMapper;
import com.example.digitalLibraryPractice.model.MembershipModel;
import com.example.digitalLibraryPractice.model.UserModel;
import com.example.digitalLibraryPractice.services.MembershipService;
import com.example.digitalLibraryPractice.utils.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MembershipAdapter implements CommonAdapter<MembershipInputEntity,MembershipModel> {

    private final MembershipService membershipService;
    private final MembershipInputMapper membershipInputMapper;

    @Autowired
    public MembershipAdapter(MembershipService membershipService, MembershipInputMapper membershipInputMapper) {
        this.membershipService = membershipService;
        this.membershipInputMapper = membershipInputMapper;
    }

    @Override
    public MembershipModel save(MembershipInputEntity inputEntity) {
        return this.membershipService.addMemberShip(this.membershipInputMapper.mapToModel(inputEntity));
    }

    public MembershipModel changeStatus(long membershipId,MembershipStatus status){
        return this.membershipService.updateMemberShipStatus(membershipId, status);
    }

    @Override
    public MembershipModel update(MembershipInputEntity inputEntity) {
        return Todo.todo();
    }

    @Override
    public MembershipModel findById(long id) {
        return this.membershipService.getById(id);
    }

    @Override
    public UserModel updateById(long id, UserInputEntity userInputEntity) {
        return null;
    }

    public void deleteMemberByUserId(long id){
        this.membershipService.deleteMemberByUserId(id);
    }

    @Override
    public void deleteById(long id) {
        Todo.todo();
    }


    @Override
    public List<MembershipModel> getAll() {
        return Todo.todo();
    }



}

