package com.choi0tae.portfolio.service;


import com.choi0tae.portfolio.entity.Post;
import com.choi0tae.portfolio.entity.User;
import com.choi0tae.portfolio.exception.PostNotFoundException;
import com.choi0tae.portfolio.exception.UserNotFoundException;
import com.choi0tae.portfolio.model.PostDtoForRequest;
import com.choi0tae.portfolio.model.PostDtoForResponse;
import com.choi0tae.portfolio.model.PostSummaryDtoForResponse;
import com.choi0tae.portfolio.repository.PostRepository;
import com.choi0tae.portfolio.repository.UserRepository;
import jakarta.websocket.server.ServerEndpoint;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public Post savePost(PostDtoForRequest givenDto){
        User user= userRepository.findByUserStringId(givenDto.getUser_string_id())
                .orElseThrow(()->new UserNotFoundException("유저를 찾을 수 없습니다."));
        Post post=givenDto.toEntity(user);

        return postRepository.save(post);
    }

    public Post findByPostId(Long postId){
        return postRepository.findById(postId)
                .orElseThrow(()->new PostNotFoundException("게시물을 찾을 수 없습니다."));
    }

    public List<Post> findPostsByUserId(String userStringID){
        User user= userRepository.findByUserStringId(userStringID)
                .orElseThrow(()->new UserNotFoundException("유저를 찾을 수 없습니다."));

        return postRepository.findAllByUser(user);
    }

    /* This method is for Event-Listener, when click the post event occurred*/
    public void executeForClickEvent(Post post){
        post.setHasWatched(post.getHasWatched()+1); // increase watched_num
        postRepository.save(post);
    }


    public Post deletePost(Long postId){
        Post post=findByPostId(postId);
        post.softDelete();

        return postRepository.save(post);
    }

    public Post updatePost(Post post,PostDtoForRequest dto){
        post.setContent(dto.getContent());
        post.setTitle(dto.getTitle());
        post.setVisible(dto.getVisible());

        post.setPostedDate(LocalDateTime.now().toLocalDate());
        post.setPostedTime(LocalDateTime.now().toLocalTime());

        return postRepository.save(post);
    }
}
