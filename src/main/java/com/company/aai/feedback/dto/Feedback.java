package com.company.aai.feedback.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Feedback {

    @Id
    private int id;

    @NotNull
    private String userEmail;

    @NotNull
    private String message;

    @NotNull
    private LocalDate createdAt;

    @NotNull
    private String flightId;
}


