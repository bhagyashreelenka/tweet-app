package com.tweetapp.controller;

import java.net.URI;
import java.util.List;

import com.tweetapp.model.Users;
import com.tweetapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * The type User controller.
 */
@CrossOrigin("http://localhost:4200")
@RestController
@Slf4j
@RequestMapping("/api/v1.0/tweets")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Register response entity.
     *
     * @param user the user
     * @return the response entity
     */
    @PostMapping("/tweets/register")
    public ResponseEntity<Void> register(@RequestBody Users user) {
        Users createdUser = userService.register(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{loginId}").buildAndExpand(createdUser.getLoginId()).toUri();
        log.info("Registering user :"+ createdUser);
        return ResponseEntity.created(uri).build();

    }

    /**
     * Get all users list.
     *
     * @return the list
     */
    @GetMapping("/tweets/users/all")
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }

    /**
     * Search by regex list.
     *
     * @param str the str
     * @return the list
     */
    @GetMapping("/tweets/user/search/{str}")
    public List<Users> searchByRegex(@PathVariable String str){
        return userService.searchByRegex(str);
    }


    /**
     * Gets user.
     *
     * @param loginId the login id
     * @return the user
     */
    @GetMapping("/tweets/user/{loginId}")
    public Users getUser(@PathVariable String loginId) {
        return userService.getUser(loginId);
    }

    /**
     * Update password response entity.
     *
     * @param loginId the login id
     * @param user    the user
     * @return the response entity
     */
    @PutMapping("/tweets/{loginId}/forgot")
    public ResponseEntity<Users> updatePassword(@PathVariable String loginId, @RequestBody Users user){
        Users u = userService.updatePassword(loginId, user);
        log.info("Password Updated for user "+u);
        return new ResponseEntity<Users>(u, HttpStatus.OK);
    }

    /**
     * Authencticate boolean.
     *
     * @param loginId  the login id
     * @param password the password
     * @return the boolean
     */
    @GetMapping("/authenticate/{loginId}/{password}")
    public boolean authencticate(@PathVariable String loginId,@PathVariable String password) {
        return userService.authenticate(loginId, password);
    }
}
