package com.calibrate.lets_catchupbe.repositories;

import com.calibrate.lets_catchupbe.models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
    Comment findById(Integer id);
}

