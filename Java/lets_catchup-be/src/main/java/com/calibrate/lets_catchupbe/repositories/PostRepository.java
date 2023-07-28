package com.calibrate.lets_catchupbe.repositories;

import com.calibrate.lets_catchupbe.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    Post findByName(String name);
}
