package com.choi0tae.portfolio.controller;


import com.choi0tae.portfolio.model.PostDtoForRequest;
import com.choi0tae.portfolio.model.PostDtoForResponse;
import com.choi0tae.portfolio.repository.PostRepository;
import com.choi0tae.portfolio.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    @PostMapping
    private ResponseEntity<PostDtoForResponse> create(@RequestBody PostDtoForRequest dto){
        return ResponseEntity.ok(postService.savePost(dto));
    }
}
