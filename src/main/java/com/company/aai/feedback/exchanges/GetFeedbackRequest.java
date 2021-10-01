package com.company.aai.feedback.exchanges;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class GetFeedbackRequest {
    private String userEmail;
    private String flightId;
    private String message;
}
