package com.example.digitalLibraryPractice.mappers.input;

import com.example.digitalLibraryPractice.entities.input.MembershipInputEntity;
import com.example.digitalLibraryPractice.entities.output.UserOutputEntity;
import com.example.digitalLibraryPractice.enums.MemberShipPlan;
import com.example.digitalLibraryPractice.enums.MembershipStatus;
import com.example.digitalLibraryPractice.mappers.output.UserOutputMapper;
import com.example.digitalLibraryPractice.model.MembershipModel;
import com.example.digitalLibraryPractice.model.UserModel;
import com.example.digitalLibraryPractice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class MembershipInputMapper {

    private final UserRepository userRepository;
    @Autowired
    public MembershipInputMapper(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public MembershipModel mapToModel(MembershipInputEntity inputEntity){
        UserModel userModel = userRepository.getUser(inputEntity.getUserId());
        Instant[] startEnd = this.getStartDateAndEndDate(inputEntity);
        return MembershipModel.builder()
                .user(userModel)
                .plan(inputEntity.getPlanName())
                .status(MembershipStatus.ACTIVE)
                .startDate(startEnd[0])
                .endDate(startEnd[1])
                .build();
    }

    public Instant[] getStartDateAndEndDate(MembershipInputEntity inputEntity){
        MemberShipPlan plan = inputEntity.getPlanName();
        Instant startDate = Instant.now();
        Instant endDate = null;
        switch(plan){
            case THREE_MONTHS -> endDate = this.addMonthsToInstant(startDate,3);
            case SIX_MONTHS -> endDate = this.addMonthsToInstant(startDate,6);
            case ONE_YEAR -> endDate = this.addMonthsToInstant(startDate,12);
        }
        return new Instant[]{startDate,endDate};
    }

    public Instant addMonthsToInstant(Instant start, int monthsToAdd) {
        // Convert Instant to ZonedDateTime (system default time zone)
        ZonedDateTime zdt = start.atZone(ZoneId.systemDefault());
        // Add months
        ZonedDateTime newDateTime = zdt.plusMonths(monthsToAdd);
        // Convert back to Instant
        return newDateTime.toInstant();
    }
}
