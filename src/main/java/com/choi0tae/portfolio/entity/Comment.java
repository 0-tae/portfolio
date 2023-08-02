package com.choi0tae.portfolio.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table
@Slf4j
@Getter
public class Comment implements SoftDeletable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @Column
    private Integer liked;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id",referencedColumnName = "id")
    private Post post;

    @Column(name="created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name="commented_time", nullable = false)
    private LocalTime postedTime;

    @Column(name="commented_date", nullable = false)
    private LocalDate postedDate;

    @Column(name="deleted_at")
    private LocalDateTime deletedAt;

    @Override
    public void setDeletedAt(LocalDateTime deletedTime) {
        this.deletedAt=deletedTime;
    }
}
