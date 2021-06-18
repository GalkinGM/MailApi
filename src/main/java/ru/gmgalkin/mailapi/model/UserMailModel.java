package ru.gmgalkin.mailapi.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
//lombok
@Getter
@Setter
public class UserMailModel {

    private String firstName;
    private String lastName;
    private String emailAddress;

}
