package com.example.digitalLibraryPractice.mappers.input;


import com.example.digitalLibraryPractice.entities.input.UserInputEntity;
import com.example.digitalLibraryPractice.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserInputMapper {

    public UserModel mapToModel(UserInputEntity userInputEntity) {
        return UserModel.builder()
                .id(userInputEntity.getId())
                .firstName(userInputEntity.getFirstName())
                .lastName(userInputEntity.getLastName())
                .dateOfBirth(userInputEntity.getDateOfBirth())
                .password(userInputEntity.getPassword())
                .role(userInputEntity.getRole())
                .email(userInputEntity.getEmail())
                .phoneNumber(userInputEntity.getPhoneNumber())
                .build();
    }
}
