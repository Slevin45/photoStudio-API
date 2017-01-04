package com.example.services;

import com.example.models.request.ContactUsRequest;
import com.example.repositories.ContactRequestRepository;
import lombok.extern.slf4j.Slf4j;
import org.jooq.util.maven.example.tables.records.ContactRequestRecord;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@Slf4j
public class UserService {

    private final ContactRequestRepository contactRequestRepository;
    private final EmailService emailService;

    public UserService(ContactRequestRepository contactRequestRepository, EmailService emailService) {
        this.contactRequestRepository = contactRequestRepository;
        this.emailService = emailService;
    }

    public void contactUs(ContactUsRequest bean) {
        final ContactRequestRecord contactRequestRecord = contactRequestRepository.newRecord();
        contactRequestRecord.setEmail(bean.getEmail());
        contactRequestRecord.setName(bean.getName());
        contactRequestRecord.setPhone(bean.getPhone());
        contactRequestRepository.store(contactRequestRecord);
        emailService.sendEmail(bean);
    }
}
