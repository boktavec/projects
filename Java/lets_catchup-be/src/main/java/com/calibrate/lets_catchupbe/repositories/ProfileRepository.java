package com.calibrate.lets_catchupbe.repositories;

import com.calibrate.lets_catchupbe.models.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProfileRepository extends MongoRepository<Profile, String> {
    Optional<Profile> findByEmail(String email);


}
