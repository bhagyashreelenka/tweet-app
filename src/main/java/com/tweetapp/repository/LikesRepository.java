package com.tweetapp.repository;

import com.tweetapp.model.Likes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * The interface Likes repository.
 */
@Repository
public interface LikesRepository extends MongoRepository<Likes, String> {

    /**
     * Gets like by id.
     *
     * @param id the id
     * @return the like by id
     */
    @Query("{'id' : ?0}")
    Likes getLikeById(long id);

    /**
     * Delete by id likes.
     *
     * @param id the id
     * @return the likes
     */
    @Query(value="{'id' : ?0}", delete=true)
    Likes deleteById(long id);

}
