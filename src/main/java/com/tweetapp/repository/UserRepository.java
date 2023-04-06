package com.tweetapp.repository;

import java.util.List;

import com.tweetapp.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.repository.Query;

/**
 * The interface User repository.
 */
@Repository
public interface UserRepository extends MongoRepository<Users, String>{


    /**
     * Find bylogin id users.
     *
     * @param loginId the login id
     * @return the users
     */
    @Query("{'loginId' : ?0}")
    Users findByloginId(String loginId);

    /**
     * Delete bylogin id users.
     *
     * @param loginId the login id
     * @return the users
     */
    @Query(value="{'loginId' : ?0}", delete=true)
    Users DeleteByloginId(String loginId);

    /**
     * Search by regex list.
     *
     * @param str the str
     * @return the list
     */
    @Query("{'loginId':{'$regex':'?0','$options':'i'}}")
    List<Users> searchByRegex(String str);

}
