package com.example.digitalLibraryPractice.services;

import com.example.digitalLibraryPractice.model.MembershipModel;
import com.example.digitalLibraryPractice.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembershipService {

    private final MembershipRepository membershipRepository;

    @Autowired
    public MembershipService(MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }

    public MembershipModel save(MembershipModel model){
        return this.membershipRepository.save(model);
    }

    public MembershipModel getById(long id){
        return this.membershipRepository.getById(id);
    }
}
