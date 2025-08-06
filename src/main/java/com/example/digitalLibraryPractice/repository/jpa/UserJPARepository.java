package com.example.digitalLibraryPractice.repository.jpa;

import com.example.digitalLibraryPractice.entities.output.UserOutputEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJPARepository extends JpaRepository<UserOutputEntity,Long> {
}
