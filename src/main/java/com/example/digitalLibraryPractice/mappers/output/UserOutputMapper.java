package com.example.digitalLibraryPractice.mappers.output;

import com.example.digitalLibraryPractice.entities.output.UserOutputEntity;
import com.example.digitalLibraryPractice.model.UserModel;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

@Component
public class UserOutputMapper {

    public UserModel mapToModel(UserOutputEntity userOutputEntity){
        return UserModel.builder()
                .id(userOutputEntity.getId())
                .firstName(userOutputEntity.getFirstName())
                .lastName(userOutputEntity.getLastName())
                .dateOfBirth(userOutputEntity.getDateOfBirth())
                .password(userOutputEntity.getPassword())
                .role(userOutputEntity.getRole())
                .email(userOutputEntity.getEmail())
                .phoneNumber(userOutputEntity.getPhoneNumber())
                .build();
    }

    public UserOutputEntity mapFromModel(UserModel userModel){
        return UserOutputEntity.builder()
                .id(userModel.getId())
                .firstName(userModel.getFirstName())
                .lastName(userModel.getLastName())
                .dateOfBirth(userModel.getDateOfBirth())
                .password(userModel.getPassword())
                .role(userModel.getRole())
                .email(userModel.getEmail())
                .phoneNumber(userModel.getPhoneNumber())
                .build();
    }

//    public UserOutputEntity mapFromModel(UserModel userModel) {
//        UserOutputEntity.UserOutputEntityBuilder builder = UserOutputEntity.builder()
//                .firstName(userModel.getFirstName())
//                .lastName(userModel.getLastName())
//                .dateOfBirth(userModel.getDateOfBirth())
//                .password(userModel.getPassword())
//                .role(userModel.getRole())
//                .email(userModel.getEmail())
//                .phoneNumber(userModel.getPhoneNumber());
//
//        // Only set ID if it’s not null (update case)
//        if (userModel.getId() != null) {
//            builder.id(userModel.getId());
//        }
//        return builder.build();
//    }

}
