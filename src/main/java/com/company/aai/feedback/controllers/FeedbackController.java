package com.company.aai.feedback.controllers;

import com.company.aai.feedback.dto.Feedback;
import com.company.aai.feedback.exchanges.GetFeedbackRequest;
import com.company.aai.feedback.services.EmailService;
import com.company.aai.feedback.services.FeedbackService;
import com.company.aai.feedback.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @Autowired
    EmailService emailService;

    @Autowired
    LinkService linkService;


    @GetMapping("/feedbacks")
    public ResponseEntity<List<Feedback>> feedbacks() {
        List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
        return ResponseEntity.ok().body(feedbacks);
    }

//    @PostMapping("/addFeedback")
//    public void addFeedback(@RequestBody GetFeedbackRequest getFeedbackRequest) {
//        feedbackService.addFeedback(getFeedbackRequest, LocalDate.now());
//    }

    @GetMapping("/sendFeedback/pnr={pnr}/uuid={uuid}")
    public ResponseEntity<String> checkFeedbackTakenOrNot(@PathVariable(value = "pnr") String pnr,
                                                          @PathVariable(value = "uuid") String uuid) {
        if (!linkService.isFeedbackTaken(pnr, uuid)) {
            return ResponseEntity.ok().body("Not taken");
        }
        return ResponseEntity.badRequest().body("Taken");
    }

    @PostMapping("/sendFeedback/pnr={pnr}/uuid={uuid}")
    public ResponseEntity<String> sendFeedback(@PathVariable(value = "pnr") String pnr,
                             @PathVariable(value = "uuid") String uuid,
                             @RequestBody GetFeedbackRequest getFeedbackRequest) {

        if (!linkService.isFeedbackTaken(pnr, uuid)) {
            feedbackService.addFeedback(getFeedbackRequest, LocalDate.now());
            linkService.removeLinkDetails(pnr, uuid);
            return ResponseEntity.ok().body(null);
        }
        return ResponseEntity.badRequest().body(null);
    }

    @GetMapping("/sendEmail/mail={mail}/pnr={pnr}")
    public ResponseEntity<String> sendFeedbackLinkToUser(@PathVariable(value = "mail") String mail,
                                         @PathVariable(value = "pnr") String pnr) {
        emailService.sendEmail(mail, pnr);
        return ResponseEntity.ok().body("Email-sent successfully");
    }


}