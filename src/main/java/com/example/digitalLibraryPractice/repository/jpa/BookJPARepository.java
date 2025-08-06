package com.example.digitalLibraryPractice.repository.jpa;

import com.example.digitalLibraryPractice.entities.output.BookOutputEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BookJPARepository extends JpaRepository<BookOutputEntity, Long> {



}
