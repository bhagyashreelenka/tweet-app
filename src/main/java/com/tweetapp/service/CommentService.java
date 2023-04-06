package com.tweetapp.service;

import java.util.List;

import com.tweetapp.model.Comments;
import com.tweetapp.repository.CommentsRepository;
import org.springframework.data.domain.Sort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Comment service.
 */
@Service
public class CommentService {

    @Autowired
    private CommentsRepository commentsRepository;

    /**
     * Get all list.
     *
     * @param tweetId the tweet id
     * @return the list
     */
    public List<Comments> getAll(long tweetId){
        return commentsRepository.getAllBytweetId(tweetId, Sort.by(Sort.Direction.DESC, "date"));
    }

    /**
     * Post comment comments.
     *
     * @param comments the comments
     * @return the comments
     */
    public Comments postComment(Comments comments) {
        return commentsRepository.save(comments);
    }

}

