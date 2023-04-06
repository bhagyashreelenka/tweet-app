package com.tweetapp.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The type Like check.
 */
@Document("LikeCheck")
public class LikeCheck {

    private String loginId;
    private long tweetId;

    /**
     * Instantiates a new Like check.
     *
     * @param loginId the login id
     * @param tweetId the tweet id
     */
    public LikeCheck(String loginId, long tweetId) {
        super();
        this.loginId = loginId;
        this.tweetId = tweetId;
    }

    /**
     * Instantiates a new Like check.
     */
    public LikeCheck() {
    }

    /**
     * Gets login id.
     *
     * @return the login id
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * Sets login id.
     *
     * @param loginId the login id
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * Gets tweet id.
     *
     * @return the tweet id
     */
    public long getTweetId() {
        return tweetId;
    }

    /**
     * Sets tweet id.
     *
     * @param tweetId the tweet id
     */
    public void setTweetId(long tweetId) {
        this.tweetId = tweetId;
    }

    @Override
    public String toString() {
        return "LikeCheck [loginId=" + loginId + ", tweetId=" + tweetId + "]";
    }


}

