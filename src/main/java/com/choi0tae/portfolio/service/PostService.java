package com.choi0tae.portfolio.service;


import com.choi0tae.portfolio.entity.Post;
import com.choi0tae.portfolio.entity.User;
import com.choi0tae.portfolio.exception.UserNotFoundException;
import com.choi0tae.portfolio.model.PostDtoForRequest;
import com.choi0tae.portfolio.model.PostDtoForResponse;
import com.choi0tae.portfolio.repository.PostRepository;
import com.choi0tae.portfolio.repository.UserRepository;
import jakarta.websocket.server.ServerEndpoint;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostDtoForResponse savePost(PostDtoForRequest givenDto){
        User user= userRepository.findByUserStringId(givenDto.getUser_string_id())
                .orElseThrow(()->new UserNotFoundException("올바르지 않은 아이디거나 유저를 찾을 수 없습니다."));
        Post post=givenDto.toEntity(user);

        return post.toDto();
    }

}
