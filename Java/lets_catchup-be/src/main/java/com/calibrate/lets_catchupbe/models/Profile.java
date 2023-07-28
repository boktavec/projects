package com.calibrate.lets_catchupbe.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Document(collection = "profiles") @Getter @Setter
public class Profile {
    @Id
    private String id;
    private String fullName;
    private String firstName;
    private String lastName;
    private String email;
    private ArrayList<Friend> friends;
    private ArrayList<Friend> friendRequest;
    private ArrayList<Post> posts;


    public Profile () {
        this.friends = new ArrayList<>();
        this.friendRequest = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public Profile(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = String.format("%s %s", firstName, lastName);
        this.email = email;
        this.friends = new ArrayList<>();
        this.friendRequest = new ArrayList<>();
        this.posts = new ArrayList<>();
    }
    public void setFullName() {
        fullName = String.format("%s %s", firstName, lastName);

    }

    public void addPost(Post post) {
        String id = this.id;
        post.setProfileId(id);
        posts.add(post);
    }

    public void requestConnection(Friend request){
        friendRequest.add(request);
    }

    public void removeRequest(int index) {
        friendRequest.remove(index);
    }

    public void acceptConnection(Friend friend) {
        friends.add(friend);
    }



}
