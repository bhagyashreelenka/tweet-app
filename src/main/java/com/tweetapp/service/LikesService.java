package com.tweetapp.service;

import java.util.List;

import com.tweetapp.model.LikeCheck;
import com.tweetapp.model.Likes;
import com.tweetapp.repository.LikesCheckRepository;
import com.tweetapp.repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Likes service.
 */
@Service
public class LikesService {

    @Autowired
    private LikesRepository likesRepository;

    @Autowired
    private LikesCheckRepository likesCheckRepository;

    /**
     * Gets likes count.
     *
     * @param id the id
     * @return the likes count
     */
    public Likes getLikesCount(long id) {
        return likesRepository.getLikeById(id);
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    public List<Likes> getAll() {
        return likesRepository.findAll();
    }

    /**
     * Update likes likes.
     *
     * @param id      the id
     * @param loginId the login id
     * @param likes   the likes
     * @return the likes
     */
    public Likes updateLikes(long id,String loginId, Likes likes) {;

        Likes li=likes;
        if(id==-1) {
            likesCheckRepository.save(new LikeCheck(loginId, li.getId()));
            return likesRepository.save(likes);
        }
        else {
            if(check(id, loginId)) {
                long l=li.getLikes()-2;
                li.setLikes(l);
                likesCheckRepository.deleteByloginId(loginId, id);
                likesRepository.deleteById(id);
                return likesRepository.save(li);

            }
            else {
                likesCheckRepository.save(new LikeCheck(loginId, id));
                likesRepository.deleteById(id);
                return likesRepository.save(li);
            }

        }
    }

    /**
     * Delete likes.
     *
     * @param id the id
     * @return the likes
     */
    public Likes Delete(long id) {
        return likesRepository.deleteById(id);
    }

    /**
     * Check boolean.
     *
     * @param tweetId the tweet id
     * @param loginId the login id
     * @return the boolean
     */
    public boolean check(long tweetId, String loginId) {
        List<LikeCheck> l = likesCheckRepository.findAll();

        for(int i=0;i<l.size();i++) {
            if(tweetId==l.get(i).getTweetId() && loginId.equals(l.get(i).getLoginId())) {
                return true;
            }

        }
        return false;
    }
}
