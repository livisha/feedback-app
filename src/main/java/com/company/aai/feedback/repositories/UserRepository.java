package com.company.aai.feedback.repositories;

import com.company.aai.feedback.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    Optional<UserEntity> findByUserEmail(String userEmail);
}
