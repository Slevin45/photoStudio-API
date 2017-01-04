package com.example.services;

import com.example.models.request.ContactUsRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import org.apache.commons.mail.EmailConstants;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.sendgrid.*;

import java.io.IOException;

@Transactional
@Service
@Slf4j
public class EmailService {

    private static final String SUBJECT = "Contact request";
    private static final String RECEIVER = "eldar.s@smartum.pro";
    private static final String CONTENT_TYPE = "text/plain";
    @Value("${sendgrid_apikey}")
    private String apiKey;


    public void sendEmail(ContactUsRequest bean) {
        final Email from = new Email(bean.getEmail());
        final String subject = SUBJECT;
        final Email to = new Email(RECEIVER);
        final Content content = new Content(CONTENT_TYPE, bean.getMessage());
        Mail mail = new Mail(from, subject, to, content);
        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();
        try {
            request.method = Method.POST;
            request.endpoint = "mail/send";
            request.body = mail.build();
            Response response = sg.api(request);
            System.out.println(response.statusCode);
            System.out.println(response.body);
            System.out.println(response.headers);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}

