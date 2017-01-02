package com.example.repositories;

import org.jooq.DSLContext;
import org.jooq.UpdatableRecord;
import org.jooq.impl.TableImpl;

public abstract class BaseRepository<RECORD_TYPE extends UpdatableRecord, TABLE_TYPE extends TableImpl<RECORD_TYPE>> {

    private final DSLContext jooq;

    BaseRepository(DSLContext jooq) {this.jooq = jooq;}

    public DSLContext jooq() {
        return jooq;
    }

    public RECORD_TYPE newRecord() {
        return jooq().newRecord(table());
    }

    public void store(RECORD_TYPE record) {
        record.store();
    }

    public void delete(RECORD_TYPE record) {
        record.delete();
    }


    String wrapSearchText(String text) {
        return "%" + text + "%";
    }

    protected abstract TABLE_TYPE table();


}
