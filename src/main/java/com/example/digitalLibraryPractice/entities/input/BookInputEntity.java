package com.example.digitalLibraryPractice.entities.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.With;

import java.time.Instant;

@Getter
@Setter
@Builder
@With
public class BookInputEntity {

    private Long id;

    @NotBlank(message = "name is mandatory")
    private String name;

    @NotBlank(message = "author is mandatory")
    private String author;

    private String description;

    private Instant publishedDate;
}
