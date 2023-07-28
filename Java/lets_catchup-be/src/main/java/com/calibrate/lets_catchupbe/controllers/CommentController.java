package com.calibrate.lets_catchupbe.controllers;

import com.calibrate.lets_catchupbe.models.Comment;
import com.calibrate.lets_catchupbe.repositories.CommentRepository;
import com.calibrate.lets_catchupbe.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @Autowired
    private CommentRepository commentRepository;

    @PostMapping("/comment")
    public void postComment(@RequestBody Comment comment){
        commentService.commentOnPost(comment);
    }

}
