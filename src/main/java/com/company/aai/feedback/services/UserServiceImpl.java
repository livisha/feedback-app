package com.company.aai.feedback.services;

import com.company.aai.feedback.models.UserEntity;
import com.company.aai.feedback.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isUserAvailable(String userEmail) {

        Optional<UserEntity> optionalUserEntity = userRepository.findByUserEmail(userEmail);
        if (optionalUserEntity.isPresent()) {
            return true;
        }
        return false;
    }

    public void addUserEmail(String userEmail) {
        UserEntity userEntity = UserEntity.builder()
                .userEmail(userEmail)
                .build();

        userRepository.save(userEntity);
    }
}
