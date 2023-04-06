package com.tweetapp.controller;

import java.net.URI;
import java.util.List;

import com.tweetapp.model.Tweet;
import com.tweetapp.service.TweetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * The type Tweet controller.
 */
@CrossOrigin("http://localhost:4200")
@RestController
@Slf4j
@RequestMapping("/api/v1.0/tweets")
public class TweetController {

    @Autowired
    private TweetService tweetService;

    /**
     * Gets tweet.
     *
     * @param id the id
     * @return the tweet
     */
    @GetMapping("/tweet/{id}")
    public Tweet getTweet(@PathVariable long id) {
        Tweet t = tweetService.find(id);
        log.info("Details of tweet of id"+id+" : "+t);
        return t;
    }

    /**
     * Get all tweets list.
     *
     * @return the list
     */
    @GetMapping(path="/tweets/all")
    public List<Tweet> getAllTweets(){
        return tweetService.findAll();
    }


    /**
     * Get all tweets of user list.
     *
     * @param loginId the login id
     * @return the list
     */
    @GetMapping(path="/tweets/{loginId}")
    public List<Tweet> getAllTweetsOfUser(@PathVariable String loginId){
        return tweetService.findByLoginId(loginId);
    }

    /**
     * Post tweets response entity.
     *
     * @param loginId the login id
     * @param t       the t
     * @return the response entity
     */
    @PostMapping("/tweets/{loginId}/add")
    public ResponseEntity<Void> postTweets(@PathVariable String loginId,@RequestBody Tweet t) {
        Tweet createdTweet = tweetService.updateTweets(t);
        log.info("Posting a new Tweet: "+createdTweet);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTweet.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    /**
     * Delete tweets response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/tweets/delete/{id}")
    public ResponseEntity<Void> deleteTweets(@PathVariable long id){
        tweetService.deleteTweet(id);
        log.info("Deleted tweet for id "+id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Update tweets response entity.
     *
     * @param id    the id
     * @param tweet the tweet
     * @return the response entity
     */
    @PutMapping("/tweets/update/{id}")
    public ResponseEntity<Tweet> updateTweets(@PathVariable long id, @RequestBody Tweet tweet){
        Tweet t= tweetService.updateTweet(id, tweet);
        log.info("updating tweet for id "+id+" : "+t);
        return new ResponseEntity<Tweet>(t, HttpStatus.OK);
    }

}
