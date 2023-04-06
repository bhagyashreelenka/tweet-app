package com.tweetapp.controller;

import java.util.List;

import com.tweetapp.model.Likes;
import com.tweetapp.service.LikesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The type Likes controller.
 */
@CrossOrigin("http://localhost:4200")
@RestController
@Slf4j
@RequestMapping("/api/v1.0/tweets")
public class LikesController {

    @Autowired
    private LikesService likesService;

    /**
     * Gets like count.
     *
     * @param id the id
     * @return the like count
     */
    @GetMapping("/{id}/likes")
    public Likes getLikeCount(@PathVariable long id) {
        Likes l = likesService.getLikesCount(id);
       // log.info("Details of likes for tweetId "+id+" : "+l);
        return l;
    }

    /**
     * Get all list.
     *
     * @return the list
     */
    @GetMapping("/all/likes")
    public List<Likes> getAll(){
        return likesService.getAll();
    }

    /**
     * Update likes response entity.
     *
     * @param id      the id
     * @param loginId the login id
     * @param likes   the likes
     * @return the response entity
     */
    @PutMapping("/{id}/likesUpdate/{loginId}")
    public ResponseEntity<Likes> updateLikes(@PathVariable long id,@PathVariable String loginId, @RequestBody Likes likes) {
        Likes updatedLikes = likesService.updateLikes(id, loginId, likes);
        //log.info("Updating likes "+updatedLikes);
        return new ResponseEntity<Likes>(updatedLikes, HttpStatus.OK);
    }

    /**
     * Delete response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}/likes/delete")
    public ResponseEntity<Void> Delete(@PathVariable long id){
        likesService.Delete(id);
        //log.info("Deleting details of tweetId : "+id);
        return ResponseEntity.noContent().build();
    }
}
