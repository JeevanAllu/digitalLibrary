package com.example.digitalLibraryPractice.entities.output;


import com.example.digitalLibraryPractice.enums.MembershipStatus;
import jakarta.persistence.*;
import jdk.jshell.Snippet;
import lombok.*;

import java.time.Instant;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "membership")
public class MembershipOutputEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private UserOutputEntity user;

    @Column(name = "start_date",nullable = false)
    private Instant startDate;

    @Column(name = "end_date",nullable = false)
    private Instant endDate;

    @Enumerated(EnumType.STRING)
    private MembershipStatus status;


}

