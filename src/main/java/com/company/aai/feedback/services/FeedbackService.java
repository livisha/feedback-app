package com.company.aai.feedback.services;

import com.company.aai.feedback.dto.Feedback;
import com.company.aai.feedback.exchanges.GetFeedbackRequest;

import java.time.LocalDate;
import java.util.List;

public interface FeedbackService {

    List<Feedback> getAllFeedbacks();

    void  addFeedback(GetFeedbackRequest getFeedbackRequest, LocalDate currentTime);
}
