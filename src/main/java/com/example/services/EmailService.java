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


import javax.mail.internet.InternetAddress;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


import java.util.Properties;

@Transactional
@Service
@Slf4j
public class EmailService {

    public void sendEmail(String senderEmail, String senderName, String recipientEmail, String receipentName,
                          String subject, String content) {
            try {
                HtmlEmail email = new HtmlEmail();
                InternetAddress address = new InternetAddress(recipientEmail, receipentName);
                email.setTo(Arrays.asList(address));
                email.setFrom(senderEmail, senderName);
                email.setSubject(subject);
                email.setCharset(EmailConstants.UTF_8);
                email.setHtmlMsg(content);
                email.setHostName("127.0.0.1");
                email.setSmtpPort(25);
                email.send();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
