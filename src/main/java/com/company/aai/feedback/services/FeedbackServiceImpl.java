package com.company.aai.feedback.services;

import com.company.aai.feedback.dto.Feedback;
import com.company.aai.feedback.exchanges.GetFeedbackRequest;
import com.company.aai.feedback.models.FeedbackEntity;
import com.company.aai.feedback.repositories.FeedbackRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Provider;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    private Provider<ModelMapper> modelMapperProvider;

    @Override
    public List<Feedback> getAllFeedbacks() {
        List<Feedback> feedbackList = new ArrayList<>();

        List<FeedbackEntity> feedbackEntities = feedbackRepository.findAll();
        for (FeedbackEntity fe : feedbackEntities) {
            feedbackList.add(
                    modelMapperProvider.get().map(fe, Feedback.class)
            );
        }

        return feedbackList;
    }

    @Override
    public void addFeedback(GetFeedbackRequest getFeedbackRequest, LocalDate currentTime) {

        String message = getFeedbackRequest.getMessage();
        String flightId = getFeedbackRequest.getFlightId();
        String userEmail = getFeedbackRequest.getUserEmail();

        FeedbackEntity feedbackEntity = FeedbackEntity.builder()
                .userEmail(userEmail)
                .flightId(flightId)
                .message(message)
                .createdAt(currentTime)
                .build();

        feedbackRepository.save(feedbackEntity);
    }
}

