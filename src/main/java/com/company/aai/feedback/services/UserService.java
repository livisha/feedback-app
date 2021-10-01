package com.company.aai.feedback.services;

public interface UserService {

    boolean isUserAvailable(String userEMail);

    void addUserEmail(String userEmail);
}
