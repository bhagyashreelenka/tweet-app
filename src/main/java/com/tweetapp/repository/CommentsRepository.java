package com.tweetapp.repository;

import java.util.List;

import com.tweetapp.model.Comments;
import org.springframework.data.domain.Sort;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * The interface Comments repository.
 */
@Repository
public interface CommentsRepository extends MongoRepository<Comments, String> {

    /**
     * Gets all bytweet id.
     *
     * @param tweetId the tweet id
     * @param sort    the sort
     * @return the all bytweet id
     */
    @Query("{'tweetId' : ?0}")
    List<Comments> getAllBytweetId(long tweetId, Sort sort);
}
