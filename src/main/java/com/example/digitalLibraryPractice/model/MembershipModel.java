package com.example.digitalLibraryPractice.model;

import com.example.digitalLibraryPractice.entities.output.UserOutputEntity;
import com.example.digitalLibraryPractice.enums.MemberShipPlan;
import com.example.digitalLibraryPractice.enums.MembershipStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
public class MembershipModel {

    private long id;

    //private UserModel user;
    @JsonIgnore
    private UserModel user;

    private Instant startDate;

    private Instant endDate;

    private MembershipStatus status;

    private MemberShipPlan plan;

    @JsonProperty
    public long getUserId(){
        return this.getUser().getId();
    }
}


