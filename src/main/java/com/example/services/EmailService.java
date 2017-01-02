package com.example.services;

import lombok.extern.slf4j.Slf4j;
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

    public void sendEmail() {
        Email from = new Email("eldar.s@smartum.com");
        String subject = "Hello World from the SendGrid Java Library!";
        Email to = new Email("snoopka1995@gmail.com");
        Content content = new Content("text/plain", "Hello, Email!");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(System.getenv("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"));
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

