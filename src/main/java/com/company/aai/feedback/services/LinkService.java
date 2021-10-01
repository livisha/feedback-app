package com.company.aai.feedback.services;

public interface LinkService {

    String generateLink(String mail, String pnr);

    boolean isFeedbackTaken(String pnr, String uuid);

    void removeLinkDetails(String pnr, String uuid);
}
