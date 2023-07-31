package com.choi0tae.portfolio.entity;

import java.time.LocalDateTime;


/*
 * This Interface specify that Entity's deletion strategy is soft-delete
 * Soft-deleted entities are NOT reflected in DB unless we are cleaning up the DB
 */
public interface SoftDeletable {
    default void softDelete(){
        this.setDeletedAt(LocalDateTime.now());
    }
    void setDeletedAt(LocalDateTime deletedTime);
}
