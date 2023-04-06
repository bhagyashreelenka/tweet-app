package com.tweetapp.repository;

import com.tweetapp.model.LikeCheck;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * The interface Likes check repository.
 */
@Repository
public interface LikesCheckRepository extends MongoRepository<LikeCheck, String> {

    /**
     * Delete bylogin id like check.
     *
     * @param loginId the login id
     * @param tweetId the tweet id
     * @return the like check
     */
    @Query(value="{'loginId' : ?0, 'tweetId' : ?1}", delete=true)
    LikeCheck deleteByloginId(String loginId, long tweetId);

}
