package com.example.digitalLibraryPractice.mappers.output;

import com.example.digitalLibraryPractice.entities.output.MembershipOutputEntity;
import com.example.digitalLibraryPractice.entities.output.UserOutputEntity;
import com.example.digitalLibraryPractice.model.MembershipModel;
import com.example.digitalLibraryPractice.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MembershipOutputMapper {

    private final UserOutputMapper userOutputMapper;
    @Autowired
    public MembershipOutputMapper(UserOutputMapper userOutputMapper) {
        this.userOutputMapper = userOutputMapper;
    }

    public MembershipModel mapToModel(MembershipOutputEntity outputEntity){
        return MembershipModel.builder()
                .id(outputEntity.getId())
                .user(this.userOutputMapper.mapToModel(outputEntity.getUser()))
                .startDate(outputEntity.getStartDate())
                .endDate(outputEntity.getEndDate())
                .status(outputEntity.getStatus())
                .build();
    }



    public MembershipOutputEntity mapFromModel(MembershipModel membershipModel){
        UserOutputEntity outputEntity = this.userOutputMapper.mapFromModel(membershipModel.getUser());
        return MembershipOutputEntity.builder()
                .id(membershipModel.getId() == 0 ? null : membershipModel.getId())
                .user(outputEntity)
                .startDate(membershipModel.getStartDate())
                .endDate(membershipModel.getEndDate())
                .status(membershipModel.getStatus())
                .build();
    }


}
