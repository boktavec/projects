package com.calibrate.lets_catchupbe.services;

import com.calibrate.lets_catchupbe.models.Comment;
import com.calibrate.lets_catchupbe.models.Post;
import com.calibrate.lets_catchupbe.models.Profile;
import com.calibrate.lets_catchupbe.repositories.CommentRepository;
import com.calibrate.lets_catchupbe.repositories.PostRepository;
import com.calibrate.lets_catchupbe.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

@Service
public class CommentService {
    private final ProfileService profileService;
    private final PostService postService;
    private final PostRepository postRepository;
    private final ProfileRepository profileRepository;

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, PostRepository postRepository, PostService postService, ProfileService profileService, ProfileRepository profileRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.postService = postService;
        this.profileService = profileService;
        this.profileRepository = profileRepository;

    }

    public Comment getCommentById(String id) {
        return commentRepository.findById(id).orElse(null);
    }

    public void commentOnPost(Comment comment) {
        String profileId = comment.getProfileId();
        String postId = comment.getPostId();

        Profile profile = profileService.getProfileById(profileId);
        ArrayList<Post> posts = profile.getPosts();
        Iterator<Post> iterator = posts.iterator();
        while(iterator.hasNext()) {
            Post post = iterator.next();
            if(post.getId().equals(postId)) {
                post.addComment(comment);
                commentRepository.save(comment);
                postRepository.save(post);
                profileRepository.save(profile);
                return;
            }
        }

    }
}
