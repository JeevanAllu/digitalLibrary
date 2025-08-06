package com.example.digitalLibraryPractice.repository.jpa;

import com.example.digitalLibraryPractice.entities.output.MembershipOutputEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipJPARepository extends JpaRepository<MembershipOutputEntity, Long> {
}
