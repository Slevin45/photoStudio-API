package com.example.repositories;

import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.util.maven.example.tables.ContactRequest;
import org.jooq.util.maven.example.tables.records.ContactRequestRecord;
import org.springframework.stereotype.Repository;

import static org.jooq.util.maven.example.tables.ContactRequest.CONTACT_REQUEST;

@Repository
@Slf4j
public class ContactRequestRepository  extends BaseRepository<ContactRequestRecord, ContactRequest> {

    ContactRequestRepository(DSLContext jooq) {
        super(jooq);
    }

    @Override
    protected ContactRequest table() {
        return CONTACT_REQUEST;
    }

}
