package com.tweetapp.controller;

import java.net.URI;
import java.util.List;

import com.tweetapp.model.Comments;
import com.tweetapp.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * The type Comments controller.
 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/v1.0/tweets")
@Slf4j
public class CommentsController {

    @Autowired
    private CommentService commentsService;

    /**
     * Get all list.
     *
     * @param tweetId the tweet id
     * @return the list
     */
    @GetMapping("/comments/{tweetId}")
    public List<Comments> getAll(@PathVariable long tweetId){
        return commentsService.getAll(tweetId);
    }

    /**
     * Post comment response entity.
     *
     * @param tweetId  the tweet id
     * @param comments the comments
     * @return the response entity
     */
    @PostMapping("/tweets/reply/{tweetId}")
    public ResponseEntity<Void> postComment(@PathVariable long tweetId, @RequestBody Comments comments){
        Comments postedComment = commentsService.postComment(comments);
        log.info("Posted a comment for tweetId "+tweetId+" : "+postedComment);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(postedComment.getComment()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
