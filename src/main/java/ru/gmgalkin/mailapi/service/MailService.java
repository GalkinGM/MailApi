package ru.gmgalkin.mailapi.service;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import ru.gmgalkin.mailapi.model.UserMailModel;

@Service
public class MailService {

    private JavaMailSender javaMailSender;

    @Autowired
    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    public void sendEmail(UserMailModel user) throws MailException {


        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setTo(user.getEmailAddress());
        mail.setSubject("Тема письма");
        mail.setText("Тело письма");

//    Этот метод send() содержит объект SimpleMailMessage в качестве параметра

        javaMailSender.send(mail);
    }

//    Этот метод используется для отправки почты, содержащей вложение.

    public void sendEmailWithAttachment(UserMailModel user) throws MailException, MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(user.getEmailAddress());
        helper.setSubject("Тема письма c вложением");
        helper.setText("Тело письма");


        ClassPathResource classPathResource = new ClassPathResource("WEB-INF/ZeouammdcgU.jpg");
        helper.addAttachment(classPathResource.getFilename(), classPathResource);

        javaMailSender.send(message);
    }

}
