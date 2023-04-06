package com.tweetapp.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The type Tweet.
 */
@Document("tweet")
public class Tweet {

    @Id
    private long id;

    private String loginId;
    private String tweets;
    private Date date;

    /**
     * Instantiates a new Tweet.
     */
    public Tweet() {}

    /**
     * Instantiates a new Tweet.
     *
     * @param id      the id
     * @param loginId the login id
     * @param tweets  the tweets
     * @param date    the date
     */
    public Tweet(long id, String loginId, String tweets, Date date) {
        super();
        this.id = id;
        this.loginId = loginId;
        this.tweets = tweets;
        this.date = date;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
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
     * Gets tweets.
     *
     * @return the tweets
     */
    public String getTweets() {
        return tweets;
    }

    /**
     * Sets tweets.
     *
     * @param tweets the tweets
     */
    public void setTweets(String tweets) {
        this.tweets = tweets;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Tweet [id=" + id + ", loginId=" + loginId + ", tweets=" + tweets + ", date=" + date + "]";
    }
}
