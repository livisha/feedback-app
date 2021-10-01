package com.company.aai.feedback.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String flightId;

    private String carrierName;

    @Column(nullable = false)
    private String flightFrom;

    @Column(nullable = false)
    private String flightTo;
}
