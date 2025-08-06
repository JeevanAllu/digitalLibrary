package com.example.digitalLibraryPractice.mappers.input;

import com.example.digitalLibraryPractice.entities.input.MembershipInputEntity;
import com.example.digitalLibraryPractice.entities.output.UserOutputEntity;
import com.example.digitalLibraryPractice.mappers.output.UserOutputMapper;
import com.example.digitalLibraryPractice.model.MembershipModel;
import com.example.digitalLibraryPractice.model.UserModel;
import com.example.digitalLibraryPractice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MembershipInputMapper {

    private final UserRepository userRepository;
    @Autowired
    public MembershipInputMapper(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public MembershipModel mapToModel(MembershipInputEntity inputEntity){
        UserModel userModel = userRepository.getUser(inputEntity.getUserId());

        return MembershipModel.builder()
                .id(inputEntity.getId())
                .user(userModel)
                .startDate(inputEntity.getStartDate())
                .endDate(inputEntity.getEndDate())
                .status(inputEntity.getStatus())
                .build();
    }
}
