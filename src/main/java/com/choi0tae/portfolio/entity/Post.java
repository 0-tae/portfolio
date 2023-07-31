package com.choi0tae.portfolio.entity;


import com.choi0tae.portfolio.model.PostDtoForResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Columns;

import java.time.LocalDateTime;

@Entity
@Table
@Slf4j
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post implements SoftDeletable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column
    @ColumnDefault(value = "(제목 없음)")
    private String title;

    @Column
    private Integer liked;

    @Column(name="has_watched")
    private Integer hasWatched;

    @Column(name="is_Visible")
    @ColumnDefault(value = "true")
    private boolean isVisible;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User user;

    @Column(name="created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name="deleted_at")
    private LocalDateTime deletedAt;

    @Override
    public void setDeletedAt(LocalDateTime deletedTime) {
        this.deletedAt=deletedTime;
    }

    public PostDtoForResponse toDto(){
        LocalDateTime timeInfo=LocalDateTime.now();

        return PostDtoForResponse.builder()
                .content(content)
                .title(title)
                .created_date(timeInfo.toLocalDate())
                .created_time(timeInfo.toLocalTime())
                .user_string_id(user.getUserStringId())
                .build();
    }
}
