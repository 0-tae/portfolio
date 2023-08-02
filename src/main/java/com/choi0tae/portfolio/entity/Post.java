package com.choi0tae.portfolio.entity;


import com.choi0tae.portfolio.model.PostDtoForResponse;
import com.choi0tae.portfolio.model.PostSummaryDtoForResponse;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table
@Slf4j
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
public class Post implements SoftDeletable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column
    private String title;

    @Column
    @ColumnDefault(value = "0")
    private Integer liked;

    @Column(name="has_watched")
    @ColumnDefault(value = "0")
    private Integer hasWatched;

    @Column(name="visible")
    @ColumnDefault(value = "true")
    private boolean visible;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    @Column(name="created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name="posted_time", nullable = false)
    private LocalTime postedTime;

    @Column(name="posted_date", nullable = false)
    private LocalDate postedDate;

    @Column(name="deleted_at")
    private LocalDateTime deletedAt;

    public void setHasWatched(int watched){
        this.hasWatched=watched;
    }

    @Override
    public void setDeletedAt(LocalDateTime deletedTime) {
        this.deletedAt=deletedTime;
    }

    public PostDtoForResponse toDto(){
        LocalDateTime now=LocalDateTime.now();

        return PostDtoForResponse.builder()
                .content(content)
                .title(title)
                .posted_date(now.toLocalDate())
                .posted_time(now.toLocalTime())
                .user_string_id(user.getUserStringId())
                .build();
    }

    public PostSummaryDtoForResponse toSummaryDto(){
        int MIN_LENGTH=30;

        return PostSummaryDtoForResponse.builder()
                .post_id(id)
                .title(title)
                .summary(content.substring(0,Math.max(MIN_LENGTH,content.length()))+"...")
                .posted_date(postedDate)
                .posted_time(postedTime)
                .build();
    }
}
