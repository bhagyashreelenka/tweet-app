package com.tweetapp.service;

import java.util.List;

import com.tweetapp.model.Users;
import com.tweetapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type User service.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Register users.
     *
     * @param user the user
     * @return the users
     */
    public Users register(Users user) {
        return userRepository.save(user);
    }

    /**
     * Get all users list.
     *
     * @return the list
     */
    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }

    /**
     * Gets user.
     *
     * @param loginId the login id
     * @return the user
     */
    public Users getUser(String loginId) {
        return userRepository.findByloginId(loginId);
    }

    /**
     * Update password users.
     *
     * @param loginId the login id
     * @param user    the user
     * @return the users
     */
    public Users updatePassword(String loginId,Users user) {
        userRepository.DeleteByloginId(loginId);
        Users updatedUser = userRepository.save(user);

        return updatedUser;
    }

    /**
     * Search by regex list.
     *
     * @param str the str
     * @return the list
     */
    public List<Users> searchByRegex(String str){
        return userRepository.searchByRegex(str);
    }

    /**
     * Authenticate boolean.
     *
     * @param loginId  the login id
     * @param password the password
     * @return the boolean
     */
    public boolean authenticate(String loginId, String password) {
        Users user = userRepository.findByloginId(loginId);
        if(user==null)
            return false;
        if(user.getPassword().equals(password)){
            return true;
        }
        else
            return false;
    }
}
