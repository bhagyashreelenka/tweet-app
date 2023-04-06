package com.tweetapp.repository;

import java.util.List;

import com.tweetapp.model.Tweet;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * The interface Tweet repository.
 */
@Repository
public interface TweetRepository extends MongoRepository<Tweet, Long>{

    /**
     * Find bylogin id list.
     *
     * @param loginId the login id
     * @param sort    the sort
     * @return the list
     */
    @Query("{'loginId' : ?0}")
    List<Tweet> findByloginId(String loginId, Sort sort);


    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    @Query("{'id' : ?0}")
    Tweet getById(long id);

}
