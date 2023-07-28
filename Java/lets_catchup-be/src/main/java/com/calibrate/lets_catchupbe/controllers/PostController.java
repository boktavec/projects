package com.calibrate.lets_catchupbe.controllers;

import com.calibrate.lets_catchupbe.models.Post;
import com.calibrate.lets_catchupbe.services.PostService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create-post")
    public void createPost(@RequestBody Post post){
        postService.postToProfile(post);
    }

    @PostMapping("/like-post")
    public void likePost(@RequestBody LikePost post){
        String postId = post.getPostId();
        String profileId = post.getProfileId();

        postService.likePost(profileId, postId);

    }

    @GetMapping("/all-posts")
    public List<Post> getAllPost() {

        List<Post> posts = postService.getAllPost();

        return posts;
    }

    @PostMapping("/get-posts")
    public ArrayList<Post> getPosts(@RequestBody ProfilePosts id) {
        String profileId = id.getId();
        ArrayList<Post> posts = postService.getProfilesPost(profileId);
        return posts;
    }

    @PostMapping("/get-post")
    public Post getPost(@RequestBody ProfilePosts id) {
        String postId = id.getId();
        Post post = postService.getPostById(postId);
        return post;
    }

}
@AllArgsConstructor @NoArgsConstructor @Getter
class LikePost {
    private String profileId;
    private String postId;

}

@Getter @AllArgsConstructor @NoArgsConstructor
class ProfilePosts {
    private String id;
}




