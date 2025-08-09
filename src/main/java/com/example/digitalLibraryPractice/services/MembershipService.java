package com.example.digitalLibraryPractice.services;

import com.example.digitalLibraryPractice.Exceptions.MembershipException;
import com.example.digitalLibraryPractice.entities.output.MembershipOutputEntity;
import com.example.digitalLibraryPractice.enums.MembershipStatus;
import com.example.digitalLibraryPractice.model.MembershipModel;
import com.example.digitalLibraryPractice.repository.MembershipRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class MembershipService {

    private final MembershipRepository membershipRepository;

    @Autowired
    public MembershipService(MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }


    public MembershipModel addMemberShip(MembershipModel model){
        if(this.doesActiveMemberShipExists(model.getUser().getId())){
            throw new MembershipException(model.getUser().getId(),true);
        }
        return this.membershipRepository.save(model);
    }

    public MembershipModel getById(long id){
        return this.membershipRepository.getById(id);
    }

    public MembershipModel updateMemberShipStatus(long userId, MembershipStatus status){
        Optional<MembershipOutputEntity> outputEntity = this.membershipRepository.getNonExpiredMemberShipForUser(userId);
        if(outputEntity.isEmpty()){
            throw new MembershipException(userId,false);
        }
        return this.membershipRepository.updateMemberShipStatus(userId,status);
    }

    public boolean doesActiveMemberShipExists(long userId){
        Optional<MembershipOutputEntity> outputEntity = this.membershipRepository.getNonExpiredMemberShipForUser(userId);
        if(outputEntity.isPresent()){
            log.error("The user with userId : {} has active membership already with membershipId : {}",userId,outputEntity.get().getId());
            return true;
        }
        log.info("The user with user_id : {} does not have active membership",userId);
        return false;
    }

    public void deleteMemberByUserId(long userId){
        this.membershipRepository.deleteMemberByUser(userId);
    }
}
