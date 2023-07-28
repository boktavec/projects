package com.calibrate.lets_catchupbe.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Document(collection = "comments") @Getter @Setter
public class Comment {
    @Id
    private String id;
    private String profileId;
    private String postId;
    private String name;
    private String comment;
    private String date;

    public Comment() {
        this.date = formattedTime(LocalDateTime.now());
    }

    public Comment(String profileId, String postId, String name, String comment) {
        this.profileId = profileId;
        this.postId = postId;
        this.name = name;
        this.comment = comment;
        this.date = formattedTime(LocalDateTime.now());
    }

    public String formattedTime(LocalDateTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String newTime = time.format(formatter);

        return newTime;

    }

}
