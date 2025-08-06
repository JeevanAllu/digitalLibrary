package com.example.digitalLibraryPractice.mappers.output;

import com.example.digitalLibraryPractice.entities.output.UserOutputEntity;
import com.example.digitalLibraryPractice.model.UserModel;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

@Component
public class UserOutputMapper {

    public UserModel mapToModel(UserOutputEntity UserOutputEntity){
        return UserModel.builder()
                .id(UserOutputEntity.getId())
                .firstName(UserOutputEntity.getFirstName())
                .lastName(UserOutputEntity.getLastName())
                .dateOfBirth(UserOutputEntity.getDateOfBirth())
                .email(UserOutputEntity.getEmail())
                .phoneNumber(UserOutputEntity.getPhoneNumber())
                .build();
    }

    public UserOutputEntity mapFromModel(UserModel userModel){
        return UserOutputEntity.builder()
                .id(userModel.getId() == 0 ? null : userModel.getId())
                .firstName(userModel.getFirstName())
                .lastName(userModel.getLastName())
                .dateOfBirth(userModel.getDateOfBirth())
                .email(userModel.getEmail())
                .phoneNumber(userModel.getPhoneNumber())
                .build();
    }
}
