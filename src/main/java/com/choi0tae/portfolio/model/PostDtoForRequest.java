package com.choi0tae.portfolio.model;


import com.choi0tae.portfolio.entity.Post;
import com.choi0tae.portfolio.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostDtoForRequest {
    String content;
    String title;
    String user_string_id;
    Boolean visible;

    public Post toEntity(User user){
        LocalDateTime now = LocalDateTime.now();

        return Post.builder()
                .createdAt(now)
                .postedDate(now.toLocalDate())
                .postedTime(now.toLocalTime())
                .content(content)
                .title(title==null ? "(제목 없음)" : title)
                .user(user)
                .visible(visible)
                .build();
    }
}
