package com.example.digitalLibraryPractice.entities.input;

import com.example.digitalLibraryPractice.entities.output.UserOutputEntity;
import com.example.digitalLibraryPractice.enums.MembershipStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
public class MembershipInputEntity {

    private long id;

    private long userId;
    private Instant startDate;

    private Instant endDate;

    private MembershipStatus status;
}
