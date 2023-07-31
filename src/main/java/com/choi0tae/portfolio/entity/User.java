package com.choi0tae.portfolio.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.ColumnDefault;

import javax.swing.text.StyledEditorKit;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
@Slf4j
@Getter
public class User implements SoftDeletable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String authority;

    @Column(name="user_string_id", nullable = false)
    private String userStringId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birth;

    @Column(nullable = false)
    private String email;

    @Column(name="email_verified")
    @ColumnDefault(value = "false")
    private Boolean emailVerified;

    @Column(name="created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name="deleted_at")
    private LocalDateTime deletedAt;

    @Override
    public void setDeletedAt(LocalDateTime deletedTime) {
        this.deletedAt=deletedTime;
    }
}
