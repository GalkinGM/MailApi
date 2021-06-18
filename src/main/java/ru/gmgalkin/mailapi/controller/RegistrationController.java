package ru.gmgalkin.mailapi.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.gmgalkin.mailapi.model.UserMailModel;
import ru.gmgalkin.mailapi.service.MailService;

@RestController
public class RegistrationController {

    @Autowired
    private MailService notificationService;

    @Autowired
    private UserMailModel user;

    @RequestMapping("send-mail")
    public String send() {

//      Заполняем данные получателя

        user.setFirstName("Gavriil");
        user.setLastName("Galkin");
        user.setEmailAddress("gmgalkin@gmail.com");

//        Здесь мы вызовем метод SendEmail() для отправки почты отправителю.

        try {
            notificationService.sendEmail(user);
        } catch (MailException mailException) {
            System.out.println(mailException);
        }
        return "Congratulations! Your mail has been send to the user.";
    }

    @RequestMapping("send-mail-attachment")
    public String sendWithAttachment() throws MessagingException {


//              Заполняем данные получателя

        user.setFirstName("Gavriil");
        user.setLastName("Galkin");
        user.setEmailAddress("gmgalkin@gmail.com");


//          Здесь мы вызовем метод sendEmailWithAttachment() для отправки почты отправителю с вложением

        try {
            notificationService.sendEmailWithAttachment(user);
        } catch (MailException mailException) {
            System.out.println(mailException);
        }
        return "Congratulations! Your mail has been send to the user.";
    }
}
