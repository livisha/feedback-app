package com.company.aai.feedback.services;

import com.company.aai.feedback.models.LinkEntity;
import com.company.aai.feedback.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    LinkRepository linkRepository;

    public String generateLink(String mail, String pnr) {

        String uuid = randomAlphaNumeric();

        LinkEntity linkEntity = LinkEntity.builder()
                .userEmail(mail)
                .pnr(pnr)
                .uuid(uuid)
                .build();

        linkRepository.save(linkEntity);

        return "http://localhost:3000/#/" +
                "sendFeedback/" + pnr + "/" + uuid;
    }

    public boolean isFeedbackTaken(String pnr, String uuid) {
        Optional<LinkEntity> optionalLinkEntity = linkRepository.isFeedbackLink(pnr,uuid);
        return !optionalLinkEntity.isPresent();
    }

    public void removeLinkDetails(String pnr, String uuid) {
        linkRepository.deleteByPnrAndUuid(pnr, uuid);
    }

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static String randomAlphaNumeric() {
        int count = 16;
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
}
