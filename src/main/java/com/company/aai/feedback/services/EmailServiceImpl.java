package com.company.aai.feedback.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    SimpleMailMessage simpleMailMessage;

    @Autowired
    MimeMessageHelper mimeMessageHelper;

    @Autowired
    UserService userService;

    @Autowired
    LinkService linkService;

    @Override
    public void sendEmail(String mail, String pnr) {

        simpleMailMessage.setFrom("vp.developer4248@gmail.com");
        simpleMailMessage.setSubject("AAI :: Feedback Form");
        simpleMailMessage.setTo(mail);

        String feedbackLink = getFeedbackLink(mail, pnr);
        simpleMailMessage.setText(feedbackLink);

        javaMailSender.send(simpleMailMessage);
    }

    public String getFeedbackLink(String mail, String pnr) {

        /**
         * Check the database
         * userEmail is available or not
         * if Not then create a user with that
         * email and save to the database
         */

        boolean isPresent = userService.isUserAvailable(mail);
        if (!isPresent) {
            userService.addUserEmail(mail);
        }
        return linkService.generateLink(mail, pnr);
    }


}
