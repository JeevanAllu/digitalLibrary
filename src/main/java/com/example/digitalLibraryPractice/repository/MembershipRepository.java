package com.example.digitalLibraryPractice.repository;

import com.example.digitalLibraryPractice.Exceptions.ResourceNotFoundException;
import com.example.digitalLibraryPractice.commons.CommonAdapter;
import com.example.digitalLibraryPractice.entities.input.MembershipInputEntity;
import com.example.digitalLibraryPractice.entities.output.MembershipOutputEntity;
import com.example.digitalLibraryPractice.entities.output.UserOutputEntity;
import com.example.digitalLibraryPractice.mappers.output.MembershipOutputMapper;
import com.example.digitalLibraryPractice.model.MembershipModel;
import com.example.digitalLibraryPractice.repository.jpa.MembershipJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MembershipRepository {
    //private final CommonAdapter<MembershipInputEntity,MembershipModel> adapter;

    private final MembershipOutputMapper membershipOutputMapper;
    private final MembershipJPARepository membershipJPARepository;

    @Autowired
    public MembershipRepository(MembershipOutputMapper membershipOutputMapper, MembershipJPARepository membershipJPARepository) {
        this.membershipOutputMapper = membershipOutputMapper;
        this.membershipJPARepository = membershipJPARepository;
    }


    public MembershipModel save(MembershipModel membershipModel){
        MembershipOutputEntity entity = this.membershipOutputMapper.mapFromModel(membershipModel);
        MembershipOutputEntity savedOutputEntity = this.membershipJPARepository.save(entity);
        return this.membershipOutputMapper.mapToModel(savedOutputEntity);
    }

    public MembershipModel getById(long id){
        Optional<MembershipOutputEntity> entityOptional= this.membershipJPARepository.findById(id);
        return entityOptional.map(this.membershipOutputMapper::mapToModel)
                .orElseThrow(()->
                    new ResourceNotFoundException(MembershipModel.class,"id",String.valueOf(id))
                );
    }

}
