package com.example.digitalLibraryPractice.model;

import com.example.digitalLibraryPractice.entities.output.UserOutputEntity;
import com.example.digitalLibraryPractice.enums.MembershipStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
public class MembershipModel {

    private Long id;

    //private UserModel user;
    private UserModel user;

    private Instant startDate;

    private Instant endDate;

    private MembershipStatus status;
}
