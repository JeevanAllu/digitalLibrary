package com.example.digitalLibraryPractice.mappers.input;

import com.example.digitalLibraryPractice.entities.input.BookInputEntity;
import com.example.digitalLibraryPractice.model.BookModel;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class BookInputMapper {

    public BookModel mapToModel(BookInputEntity bookInputEntity) {
        return BookModel.builder()
                .id(bookInputEntity.getId())
                .name(bookInputEntity.getName())
                .author(bookInputEntity.getAuthor())
                .description(bookInputEntity.getDescription())
                .publishedDate(bookInputEntity.getPublishedDate())
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();
    }
}
