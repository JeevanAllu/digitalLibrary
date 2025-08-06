package com.example.digitalLibraryPractice.adapter;

import com.example.digitalLibraryPractice.commons.CommonAdapter;
import com.example.digitalLibraryPractice.entities.input.MembershipInputEntity;
import com.example.digitalLibraryPractice.mappers.input.BookInputMapper;
import com.example.digitalLibraryPractice.mappers.input.MembershipInputMapper;
import com.example.digitalLibraryPractice.model.MembershipModel;
import com.example.digitalLibraryPractice.services.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MembershipAdapter implements CommonAdapter<MembershipInputEntity,MembershipModel>{

    private final MembershipService membershipService;
    private final MembershipInputMapper membershipInputMapper;

    @Autowired
    public MembershipAdapter(MembershipService membershipService, MembershipInputMapper membershipInputMapper) {
        this.membershipService = membershipService;
        this.membershipInputMapper = membershipInputMapper;
    }

    @Override
    public MembershipModel save(MembershipInputEntity inputEntity) {
        return this.membershipService.save(this.membershipInputMapper.mapToModel(inputEntity));
    }

    @Override
    public MembershipModel update(MembershipInputEntity inputEntity) {
        return null;
    }

    @Override
    public MembershipModel findById(long id) {
        return this.membershipService.getById(id);
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public List<MembershipModel> getAll() {
        return List.of();
    }
}
