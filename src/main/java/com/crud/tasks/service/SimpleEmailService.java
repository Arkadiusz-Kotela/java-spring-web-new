package com.crud.tasks.service;

import com.crud.tasks.domain.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class SimpleEmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMailMessage.class);

    private final JavaMailSender javaMailSender;
    private final MailCreatorService mailCreatorService;

    @Autowired
    public SimpleEmailService(JavaMailSender javaMailSender, MailCreatorService mailCreatorService) {
        this.javaMailSender = javaMailSender;
        this.mailCreatorService = mailCreatorService;
    }

    public void send(final Mail mail) {
        LOGGER.info("Starting email preparation");
        try {
            javaMailSender.send(createMimeMessage(mail));
            LOGGER.info("Email has been fired out...");
        } catch (MailException e) {
            LOGGER.info("Failed to process email ...", e.getMessage(), e);
        }
    }

    private SimpleMailMessage createMailMessage(Mail mail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        if(mail.getToCc() != null) {
            mailMessage.setCc(mail.getToCc());
        }
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());
        return mailMessage;
    }

    private MimeMessagePreparator createMimeMessage(final Mail mail) {
        return mimeMessage -> {
            MimeMessageHelper mimeHelper = new MimeMessageHelper(mimeMessage);
            mimeHelper.setTo(mail.getMailTo());
            if (mail.getToCc() != null) {
                mimeHelper.setCc(mail.getToCc());
            }
            mimeHelper.setSubject(mail.getSubject());
            mimeHelper.setText(mailCreatorService.buildTrelloCardEmail(mail.getMessage()));
        };
    }

}
