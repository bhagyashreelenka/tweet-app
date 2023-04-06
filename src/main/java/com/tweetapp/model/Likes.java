package com.tweetapp.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The type Likes.
 */
@Document(collection="Likes")
public class Likes {

    private long id;
    private long likes;

    /**
     * Instantiates a new Likes.
     */
    public Likes() {
    }

    /**
     * Instantiates a new Likes.
     *
     * @param id    the id
     * @param likes the likes
     */
    public Likes(long id, long likes) {
        super();
        this.id = id;
        this.likes = likes;
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
     * Gets likes.
     *
     * @return the likes
     */
    public long getLikes() {
        return likes;
    }

    /**
     * Sets likes.
     *
     * @param likes the likes
     */
    public void setLikes(long likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Likes [id=" + id + ", likes=" + likes + "]";
    }

}
