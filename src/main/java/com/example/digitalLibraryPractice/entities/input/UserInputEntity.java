package com.example.digitalLibraryPractice.entities.input;


import com.example.digitalLibraryPractice.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserInputEntity {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private Date dateOfBirth;

    private String password;

    @Email
    private String email;

    private String phoneNumber;

    private UserRole role;

}
