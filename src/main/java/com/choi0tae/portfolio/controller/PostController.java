package com.choi0tae.portfolio.controller;


import com.choi0tae.portfolio.entity.Post;
import com.choi0tae.portfolio.model.PostDtoForRequest;
import com.choi0tae.portfolio.model.PostDtoForResponse;
import com.choi0tae.portfolio.model.PostSummaryDtoForResponse;
import com.choi0tae.portfolio.repository.PostRepository;
import com.choi0tae.portfolio.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    @PostMapping
    private ResponseEntity<PostDtoForResponse> create(@RequestBody PostDtoForRequest dto){
        return ResponseEntity.ok(postService.savePost(dto).toDto());
    }

    @GetMapping("/{postId}")
    private ResponseEntity<PostDtoForResponse> read(@PathVariable Long postId){
        Post fetchedPost = postService.findByPostId(postId);

        postService.executeForClickEvent(fetchedPost);

        return ResponseEntity.ok(fetchedPost.toDto());
    }

    @GetMapping("/load-list")
    private ResponseEntity<List<PostSummaryDtoForResponse>> readAll(@RequestParam String userStringId){
        return ResponseEntity.ok(
                postService.findPostsByUserId(userStringId).stream()
                .map(Post::toSummaryDto).toList());
    }

    @PutMapping("/update")
    private ResponseEntity<PostDtoForResponse> update(@RequestBody PostDtoForRequest dto, @RequestParam Long postId){
        Post post=postService.findByPostId(postId);

        return ResponseEntity.ok(postService.updatePost(post,dto).toDto());
    }

    @DeleteMapping
    private ResponseEntity<String> delete(@RequestParam Long postId){
        return ResponseEntity.ok("post : "+postId+", deleted At : "+
                postService.deletePost(postId).getDeletedAt());
    }
}
