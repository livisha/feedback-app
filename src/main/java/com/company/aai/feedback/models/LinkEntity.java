package com.company.aai.feedback.models;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LinkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private String pnr;

    @Column(nullable = false)
    private String uuid;
}
