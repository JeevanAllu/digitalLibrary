package com.example.digitalLibraryPractice.repository.jpa;

import com.example.digitalLibraryPractice.entities.output.MembershipOutputEntity;
import com.example.digitalLibraryPractice.entities.output.UserOutputEntity;
import com.example.digitalLibraryPractice.enums.MembershipStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MembershipJPARepository extends JpaRepository<MembershipOutputEntity, Long> {


    Optional<MembershipOutputEntity> findByUser_IdAndStatusNot(Long id, MembershipStatus status);

    void deleteByUser_IdEquals(Long id);


}
