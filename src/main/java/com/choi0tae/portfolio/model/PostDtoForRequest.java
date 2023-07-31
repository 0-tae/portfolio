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

    public Post toEntity(User user){
        return Post.builder()
                .createdAt(LocalDateTime.now())
                .content(content)
                .title(title)
                .user(user)
                .build();
    }
}
