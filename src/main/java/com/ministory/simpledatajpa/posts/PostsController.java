package com.ministory.simpledatajpa.posts;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostsController {

    private PostsRepository postsRepository;

    @GetMapping("/hello")
    public String posts() {
        return "Hello Posts Controller";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto post){
        postsRepository.save(post.toEntity());
    }

    @GetMapping("/posts")
    public List<Posts> findAll() {
        return postsRepository.findAll();
    }
}
