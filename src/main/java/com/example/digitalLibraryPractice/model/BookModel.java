package com.example.digitalLibraryPractice.model;

import lombok.*;

import java.time.Instant;


@Data
@Builder
@With
@Getter
@Setter
@AllArgsConstructor
public class BookModel {

    private Long id;
    private String name;
    private String author;
    private String description;
    private Instant publishedDate;
    private Instant createdAt;
    private Instant updatedAt;
}
