package com.tweetapp.service;

import java.util.List;

import com.tweetapp.model.Tweet;
import com.tweetapp.repository.TweetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * The type Tweet service.
 */
@Service
@Slf4j
public class TweetService {

    @Autowired
    private TweetRepository tweetRepository;

    private static int idCounter=0;

    /**
     * Find tweet.
     *
     * @param id the id
     * @return the tweet
     */
    public Tweet find(long id) {

        return tweetRepository.getById(id);
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<Tweet> findAll(){
        return tweetRepository.findAll(Sort.by(Sort.Direction.DESC, "date"));
    }

    /**
     * Find by login id list.
     *
     * @param loginId the login id
     * @return the list
     */
    public List<Tweet> findByLoginId(String loginId){
        return tweetRepository.findByloginId(loginId, Sort.by(Sort.Direction.DESC, "date"));
    }

    /**
     * Post tweets tweet.
     *
     * @param t the t
     * @return the tweet
     */
    public Tweet postTweets(Tweet t) {
        return tweetRepository.save(t);
    }

    /**
     * Update tweets tweet.
     *
     * @param t the t
     * @return the tweet
     */
    public Tweet updateTweets(Tweet t) {
        if(t.getId()==-1) {
            t.setId(idCounter++);
            return postTweets(t);
        }

        else {
            return tweetRepository.save(t);
        }
    }

    /**
     * Delete tweet.
     *
     * @param id the id
     */
    public void deleteTweet(long id) {
        log.info("Tweet deleted successfully!");
        tweetRepository.deleteById(id);
    }

    /**
     * Update tweet tweet.
     *
     * @param id    the id
     * @param tweet the tweet
     * @return the tweet
     */
    public Tweet updateTweet(long id, Tweet tweet) {
        tweetRepository.deleteById(id);
        Tweet updatedTweet = tweetRepository.save(tweet);
        log.info("Tweet updated successfully!");
        return updatedTweet;
    }
}
