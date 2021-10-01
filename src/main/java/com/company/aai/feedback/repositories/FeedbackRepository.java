package com.company.aai.feedback.repositories;

import com.company.aai.feedback.models.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<FeedbackEntity, Integer> {
}
