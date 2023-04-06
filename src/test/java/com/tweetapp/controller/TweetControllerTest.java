package com.tweetapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tweetapp.model.Tweet;
import com.tweetapp.model.Users;
import com.tweetapp.service.TweetService;
import com.tweetapp.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * The type Tweet controller test.
 */
@WebMvcTest(value = TweetController.class)
class TweetControllerTest {
    /**
     * The Mock mvc.
     */
    @Autowired
	MockMvc mockMvc;

    /**
     * The Object mapper.
     */
    @Autowired
	ObjectMapper objectMapper;

    /**
     * The User service.
     */
    @MockBean
	UserService userService;

    /**
     * The Tweet service.
     */
    @MockBean
	TweetService tweetService;
	
	@MockBean
	private Users user;

	@MockBean
	private Tweet tweet;

    /**
     * Sets up.
     */
    @BeforeEach
	void setUp() {
		
		user = new Users("Prathyusha", "Prathyusha", "prathyusha@gmail.com", "Prathyusha", "password", "1234567890");
		 tweet = new Tweet(100, "Prathyusha","Hello",new Date());
	}

    /**
     * Test mock mvc not null.
     */
    @Test
	@DisplayName("Test Mock MVC ")
	void testMockMvcNotNull() {
		assertThat(mockMvc).isNotNull();
	}

    /******************************************************  postTweetByUser()  @throws Exception   @throws Exception the exception*/
    @Test
	@DisplayName("Test postTweetByUser()")
	public void testPostTweetByUser() throws Exception {
		when(tweetService.postTweets(tweet)).thenReturn(tweet);
		when(tweetService.updateTweets(tweet)).thenReturn(tweet);
	
				
		
	}

    /**
     * Test update tweet by user.
     *
     * @throws Exception the exception
     */
    @Test
	@DisplayName("Test updateTweetByUser()")
	public void testUpdateTweetByUser() throws Exception {
		when(tweetService.updateTweet(100,tweet)).thenReturn(tweet);
		
	}

}
