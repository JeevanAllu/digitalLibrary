package com.example.digitalLibraryPractice.entities.input;

import com.example.digitalLibraryPractice.entities.output.UserOutputEntity;
import com.example.digitalLibraryPractice.enums.MemberShipPlan;
import com.example.digitalLibraryPractice.enums.MembershipStatus;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
public class MembershipInputEntity {

    @NotBlank
    private Long userId;

    @NotNull
    private MemberShipPlan planName;

//    private Instant startDate;
//    private Instant endDate;
//    private MembershipStatus status;
}
