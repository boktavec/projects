package com.calibrate.lets_catchupbe.services;

import com.calibrate.lets_catchupbe.models.Post;
import com.calibrate.lets_catchupbe.models.Profile;
import com.calibrate.lets_catchupbe.repositories.PostRepository;
import com.calibrate.lets_catchupbe.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PostService {

    private final ProfileService profileService;
    private final PostRepository postRepository;
    private final ProfileRepository profileRepository;

    @Autowired
    public PostService(PostRepository postRepository, ProfileService profileService, ProfileRepository profileRepository) {
        this.postRepository = postRepository;
        this.profileService = profileService;
        this.profileRepository = profileRepository;

    }

    public Post getPostById(String id) {
        return postRepository.findById(id).orElse(null);
    }

    public List<Post> getAllPost() {
        return postRepository.findAll();
    }
    public ArrayList<Post> getProfilesPost(String id) {
        Profile user = profileService.getProfileById(id);

        return user.getPosts();
    }


    public void postToProfile(Post post) {
        String profileId = post.getProfileId();
        Profile profile = profileService.getProfileById(profileId);
        post.setProfileId(profileId);
        post = postRepository.save(post);
        profile.addPost(post);
        profileRepository.save(profile);
    }

    public void likePost(String profileId, String postId) {
        Profile profile = profileService.getProfileById(profileId);
        ArrayList<Post> posts = profile.getPosts();
        Iterator<Post> iterator = posts.iterator();
        while(iterator.hasNext()) {
            Post post = iterator.next();
            if(post.getId().equals(postId)) {
                post.likePost();
                postRepository.save(post);
                profileRepository.save(profile);
                return;
            }
        }

    }

}
