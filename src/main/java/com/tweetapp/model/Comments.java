package com.tweetapp.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The type Comments.
 */
@Document("Comments")
public class Comments {

    private String comment;
    private long tweetId;
    private Date date;
    private String loginId;

    /**
     * Instantiates a new Comments.
     */
    public Comments() {
    }

    /**
     * Instantiates a new Comments.
     *
     * @param comment the comment
     * @param tweetId the tweet id
     * @param date    the date
     * @param loginId the login id
     */
    public Comments(String comment, long tweetId, Date date, String loginId) {
        super();
        this.comment = comment;
        this.tweetId = tweetId;
        this.date = date;
        this.loginId = loginId;
    }

    /**
     * Gets comment.
     *
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets comment.
     *
     * @param comment the comment
     */
    public void setComment(String comment) {
        this.comment = comment;
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

    @Override
    public String toString() {
        return "Comments [comment=" + comment + ", tweetId=" + tweetId + ", date=" + date + ", loginId=" + loginId
                + "]";
    }

}
