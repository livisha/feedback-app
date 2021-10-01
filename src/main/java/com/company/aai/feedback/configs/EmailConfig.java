package com.company.aai.feedback.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import java.util.Properties;

@Configuration
public class EmailConfig {

    @Bean
    JavaMailSender javaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        javaMailSender.setUsername("vp.developer4248@gmail.com");
        javaMailSender.setPassword("rogcpxqaoezeiono");

        Properties properties = javaMailSender.getJavaMailProperties();
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.debug","true");

        return javaMailSender;
    }

    @Bean
    SimpleMailMessage simpleMailMessage() {
        return new SimpleMailMessage();
    }

    @Bean
    MimeMessageHelper mimeMessageHelper() throws MessagingException {
        return new MimeMessageHelper(javaMailSender().createMimeMessage(),true);
    }
}
