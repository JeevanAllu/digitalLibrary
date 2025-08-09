package com.example.digitalLibraryPractice.repository;

import com.example.digitalLibraryPractice.Exceptions.ResourceNotFoundException;
import com.example.digitalLibraryPractice.commons.CommonAdapter;
import com.example.digitalLibraryPractice.entities.input.MembershipInputEntity;
import com.example.digitalLibraryPractice.entities.output.MembershipOutputEntity;
import com.example.digitalLibraryPractice.entities.output.UserOutputEntity;
import com.example.digitalLibraryPractice.enums.MembershipStatus;
import com.example.digitalLibraryPractice.mappers.output.MembershipOutputMapper;
import com.example.digitalLibraryPractice.model.MembershipModel;
import com.example.digitalLibraryPractice.repository.jpa.MembershipJPARepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@Slf4j
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
        log.info("Membership with membership_id {} and user_id {} is created ",entity.getId(),entity.getUser().getId());
        return this.membershipOutputMapper.mapToModel(savedOutputEntity);
    }

    public MembershipModel getById(long id){
        return this.membershipJPARepository.findById(id)
                    .map((o) -> {
                            log.info("Membership with ID : {} was found Successfully",id);
                            return this.membershipOutputMapper.mapToModel(o);
                    })
                    .orElseThrow(()->
                    new ResourceNotFoundException(MembershipModel.class,"id",String.valueOf(id))
                );
    }

    public MembershipModel updateMemberShipStatus(long membershipId, MembershipStatus status){
        MembershipOutputEntity outputEntity = this.membershipJPARepository.findById(membershipId).
                orElseThrow(()->
                new ResourceNotFoundException(MembershipOutputEntity.class,"id",String.valueOf(membershipId))
                );
        outputEntity.setStatus(status);
        this.membershipJPARepository.save(outputEntity);
        log.info("MemberShip with ID : {} successfully updated",membershipId);
        return this.membershipOutputMapper.mapToModel(outputEntity);
    }

    public Optional<MembershipOutputEntity> getNonExpiredMemberShipForUser(long id){
        return this.membershipJPARepository.findByUser_IdAndStatusNot(id,MembershipStatus.EXPIRED);
    }

    public void deleteMemberByUser(long userId){
        this.membershipJPARepository.deleteByUser_IdEquals(userId);
    }
}
