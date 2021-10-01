package com.company.aai.feedback.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FeedbackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private LocalDate createdAt;

    @Column(nullable = false)
    private String flightId;

}
