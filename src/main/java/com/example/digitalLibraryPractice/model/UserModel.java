package com.example.digitalLibraryPractice.model;

import com.example.digitalLibraryPractice.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;


@Data
@Builder
@With
@Getter
@Setter
@AllArgsConstructor
public class UserModel {

    private long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String email;
    private String phoneNumber;
    private String password;
    private UserRole role;
}
