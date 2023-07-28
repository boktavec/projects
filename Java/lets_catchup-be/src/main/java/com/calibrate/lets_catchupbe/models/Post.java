package com.calibrate.lets_catchupbe.models;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;



@Document(collection = "posts") @Getter @Setter
public class Post {
    @Id
    private String id;
    private String name;
    private String profileId;
    private String post;
    private Integer likes;
    private String date;
    private ArrayList<Comment> comments;

    public Post() {
        this.likes = 0;
        this.date = formattedTime(LocalDateTime.now());
        this.comments = new ArrayList<>();
    }

    public Post(String profileId, String name, String post) {
        this.name = name;
        this.post = post;
        this.profileId = profileId;
        this.likes = 0;
        this.date = formattedTime(LocalDateTime.now());
        this.comments = new ArrayList<>();
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void likePost() {
        this.likes = likes+1;
    }

    public String formattedTime(LocalDateTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String newTime = time.format(formatter);

        return newTime;

    }

}
